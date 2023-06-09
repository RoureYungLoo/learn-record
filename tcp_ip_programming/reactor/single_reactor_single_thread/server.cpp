#include <fcntl.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <sys/epoll.h>
#include <unistd.h>

#include <iostream>

const int MAX_EVENTS = 10;
const int BUFFER_SIZE = 1024;

int main() {
  int listenSocket = socket(AF_INET, SOCK_STREAM, 0);
  if (listenSocket == -1) {
    std::cerr << "Failed to create socket." << std::endl;
    return 1;
  }

  // 设置监听套接字为非阻塞模式
  fcntl(listenSocket, F_SETFL, O_NONBLOCK);

  // 绑定监听套接字到指定端口
  struct sockaddr_in serverAddress{};
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

  // 将监听套接字注册到事件循环中
  if (epoll_ctl(epollFd, EPOLL_CTL_ADD, listenSocket, &event) == -1) {
    std::cerr << "Failed to add listen socket to epoll." << std::endl;
    close(listenSocket);
    close(epollFd);
    return 1;
  }

  epoll_event events[MAX_EVENTS];
  char buffer[BUFFER_SIZE];

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
        }

        std::cout << "New client connected." << std::endl;
      } else {
        // 已连接套接字有数据可读
        ssize_t bytesRead = read(fd, buffer, BUFFER_SIZE);
        if (bytesRead == -1) {
          std::cerr << "Failed to read from socket." << std::endl;
          continue;
        } else if (bytesRead == 0) {
          // 客户端连接关闭
          std::cout << "Client disconnected." << std::endl;
          close(fd);
        } else {
          // 处理接收到的数据
          std::cout << "Received data: " << std::string(buffer, bytesRead)
                    << std::endl;
          // 可以在这里编写相应的逻辑进行数据处理、回复等操作
        }
      }
    }
  }

  close(listenSocket);
  close(epollFd);

  return 0;
}
