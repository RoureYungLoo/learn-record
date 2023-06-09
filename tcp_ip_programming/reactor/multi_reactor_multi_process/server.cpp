#include <iostream>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/epoll.h>
#include <vector>
#include <sys/wait.h>

const int MAX_EVENTS = 10;
const int BUFFER_SIZE = 1024;
const int REACTOR_PROCESS_COUNT = 4;
const int WORKER_PROCESS_COUNT = 8;

void handleEvent(int clientSocket) {
    char buffer[BUFFER_SIZE];

    // 处理连接的事件
    ssize_t bytesRead = read(clientSocket, buffer, BUFFER_SIZE);
    if (bytesRead == -1) {
        std::cerr << "Failed to read from socket." << std::endl;
        close(clientSocket);
        return;
    } else if (bytesRead == 0) {
        // 客户端连接关闭
        std::cout << "Client disconnected." << std::endl;
        close(clientSocket);
        return;
    }

    // 处理接收到的数据
    std::cout << "Received data: " << std::string(buffer, bytesRead) << std::endl;
    // 可以在这里编写相应的逻辑进行数据处理、回复等操作

    close(clientSocket);
}

void workerProcess(int epollFd) {
    epoll_event events[MAX_EVENTS];

    while (true) {
        int readyFdCount = epoll_wait(epollFd, events, MAX_EVENTS, -1);
        if (readyFdCount == -1) {
            std::cerr << "Failed to wait for events." << std::endl;
            break;
        }

        for (int i = 0; i < readyFdCount; ++i) {
            int fd = events[i].data.fd;
            handleEvent(fd);
        }
    }
}

void reactorProcess(int listenSocket) {
    int epollFd = epoll_create1(0);
    if (epollFd == -1) {
        std::cerr << "Failed to create epoll instance." << std::endl;
        close(listenSocket);
        return;
    }

    epoll_event event{};
    event.data.fd = listenSocket;
    event.events = EPOLLIN;

    // 将监听套接字注册到当前 Reactor 进程的事件循环中
    if (epoll_ctl(epollFd, EPOLL_CTL_ADD, listenSocket, &event) == -1) {
        std::cerr << "Failed to add listen socket to epoll." << std::endl;
        close(listenSocket);
        close(epollFd);
        return;
    }

    std::vector<pid_t> workerProcesses;
    // 创建多个 Worker 进程
    for (int i = 0; i < WORKER_PROCESS_COUNT; ++i) {
        pid_t pid = fork();

        if (pid == -1) {
            std::cerr << "Failed to fork worker process." << std::endl;
            break;
        } else if (pid == 0) {
            // 子进程中运行工作线程
            workerProcess(epollFd);
            exit(0);
        } else {
            // 父进程中记录子进程的 PID
            workerProcesses.push_back(pid);
        }
    }

    epoll_event events[MAX_EVENTS];

    while (true) {
        int readyFdCount = epoll_wait(epollFd, events, MAX_EVENTS, -1);
        if (readyFdCount == -1) {
            std::cerr << "Failed to wait for events." << std::endl;
            break;
        }

        for (int i = 0; i < readyFdCount; ++i) {
            int fd = events[i].data.fd;
            if (fd == listenSocket) {
                // 有新的连接请求
                sockaddr_in clientAddress{};
                socklen_t clientAddressLength = sizeof(clientAddress);
                int clientSocket = accept(listenSocket, (struct sockaddr *)&clientAddress, &clientAddressLength);
                if (clientSocket == -1) {
                    std::cerr << "Failed to accept client connection." << std::endl;
                    continue;
                }

                // 设置新连接套接字为非阻塞模式
                fcntl(clientSocket, F_SETFL, O_NONBLOCK);

                event.data.fd = clientSocket;
                event.events = EPOLLIN | EPOLLET;  // 监听读事件和边缘触发模式
                if (epoll_ctl(epollFd, EPOLL_CTL_ADD, clientSocket, &event) == -1) {
                    std::cerr << "Failed to add client socket to epoll." << std::endl;
                    close(clientSocket);
                    continue;
                }
            } else {
                // 将连接套接字分配给一个工作进程处理
                int processIndex = i % WORKER_PROCESS_COUNT;
                pid_t workerPid = workerProcesses[processIndex];
                send(workerPid, &fd, sizeof(int), 0);
            }
        }
    }

    close(epollFd);

    // 等待工作进程退出
    for (pid_t pid : workerProcesses) {
        int status;
        waitpid(pid, &status, 0);
    }
}

int main() {
    int listenSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (listenSocket == -1) {
        std::cerr << "Failed to create socket." << std::endl;
        return 1;
    }

    // 设置监听套接字为非阻塞模式
    fcntl(listenSocket, F_SETFL, O_NONBLOCK);

    // 绑定监听套接字到指定端口
    sockaddr_in serverAddress{};
    serverAddress.sin_family = AF_INET;
    serverAddress.sin_addr.s_addr = INADDR_ANY;
    serverAddress.sin_port = htons(8080);
    if (bind(listenSocket, (struct sockaddr *)&serverAddress, sizeof(serverAddress)) == -1) {
        std::cerr << "Failed to bind socket." << std::endl;
        close(listenSocket);
        return 1;
    }

    // 开始监听连接请求
    if (listen(listenSocket, SOMAXCONN) == -1) {
        std::cerr << "Failed to listen on socket." << std::endl;
        close(listenSocket);
        return 1;
    }

    // 创建多个 Reactor 进程
    std::vector<pid_t> reactorProcesses;
    for (int i = 0; i < REACTOR_PROCESS_COUNT; ++i) {
        pid_t pid = fork();

        if (pid == -1) {
            std::cerr << "Failed to fork reactor process." << std::endl;
            break;
        } else if (pid == 0) {
            // 子进程中运行 Reactor
            reactorProcess(listenSocket);
            exit(0);
        } else {
            // 父进程中记录子进程的 PID
            reactorProcesses.push_back(pid);
        }
    }

    // 等待 Reactor 进程退出
    for (pid_t pid : reactorProcesses) {
        int status;
        waitpid(pid, &status, 0);
    }

    close(listenSocket);

    return 0;
}
