#include <fcntl.h>
#include <netinet/in.h>
#include <sys/epoll.h>
#include <sys/socket.h>
#include <unistd.h>

#include <iostream>
#include <mutex>
#include <thread>
#include <vector>

const int MAX_EVENTS = 10;
const int BUFFER_SIZE = 1024;
const int THREAD_POOL_SIZE = 4;

std::mutex mtx;

void processEvent(int clientSocket) {//
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

void handlerThread(int epollFd) {
  epoll_event events[MAX_EVENTS];

  while (true) {
    int readyFdCount = epoll_wait(epollFd, events, MAX_EVENTS, -1);
    if (readyFdCount == -1) {
      std::cerr << "Failed to wait for events." << std::endl;
      break;
    }

    for (int i = 0; i < readyFdCount; ++i) {
      int fd = events[i].data.fd;
      processEvent(fd);
    }
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
  if (bind(listenSocket, (struct sockaddr *)&serverAddress,
           sizeof(serverAddress)) == -1) {
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

  int epollFd = epoll_create1(0);
  if (epollFd == -1) {
    std::cerr << "Failed to create epoll instance." << std::endl;
    close(listenSocket);
    return 1;
  }

  epoll_event event{};
  event.data.fd = listenSocket;
  event.events = EPOLLIN;

  // 将监听套接字注册到主 Reactor 线程的事件循环中
  if (epoll_ctl(epollFd, EPOLL_CTL_ADD, listenSocket, &event) == -1) {
    std::cerr << "Failed to add listen socket to epoll." << std::endl;
    close(listenSocket);
    close(epollFd);
    return 1;
  }

  // 创建线程池
  std::vector<std::thread> threadPool;
  for (int i = 0; i < THREAD_POOL_SIZE; ++i) {
    threadPool.emplace_back(handlerThread, epollFd);
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
        int clientSocket =
            accept(listenSocket, (struct sockaddr *)&clientAddress,
                   &clientAddressLength);
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

        // 将连接套接字分配给工作线程处理
        int threadIndex = i % THREAD_POOL_SIZE;
        mtx.lock();
        int workerFd = events[i].data.fd;
        mtx.unlock();
        epoll_ctl(epollFd, EPOLL_CTL_DEL, workerFd, NULL);
        epoll_event newEvent{};
        newEvent.data.fd = workerFd;
        newEvent.events = EPOLLIN | EPOLLET;  // 监听读事件和边缘触发模式
        epoll_ctl(epollFd, EPOLL_CTL_ADD, workerFd, &newEvent);
      }
    }
  }

  close(listenSocket);
  close(epollFd);

  // 等待工作线程退出
  for (auto &thread : threadPool) {
    thread.join();
  }

  return 0;
}
