/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-06-09 10:40:37
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-06-09 13:16:52
 */

#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <sys/epoll.h>
#include <sys/socket.h>
#include <sys/time.h>
#include <sys/types.h>
#include <unistd.h>

#define BUFSIZE 4096
#define MAX_EVENTS 100
int main(int argc, char const *argv[]) {
  int srv_fd, clnt_fd;
  int len;
  struct sockaddr_in srv_addr, clnt_addr;
  socklen_t srv_addr_len = sizeof(srv_addr);
  socklen_t clnt_addr_len = sizeof(clnt_addr);
  char buf[BUFSIZE];

  memset(&srv_addr, 0, sizeof(srv_addr));
  srv_addr.sin_family = AF_INET;
  srv_addr.sin_addr.s_addr = INADDR_ANY;
  srv_addr.sin_port = htons(8000);

  srv_fd = socket(AF_INET, SOCK_STREAM, 0);
  if (srv_fd < 0) {
    perror("socket error");
    exit(-1);
  }


  if (bind(srv_fd, (struct sockaddr *)&srv_addr, sizeof(srv_addr)) < 0) {
    perror("bind error");
    exit(-1);
  }
  listen(srv_fd, 5);

  srv_addr_len = sizeof(srv_addr);

  int epfd = epoll_create(1);
  if (epfd == -1) {
    perror("epoll_create failed");
    exit(-1);
  }
  struct epoll_event ev;
  struct epoll_event evs[MAX_EVENTS];
  ev.events = EPOLLIN;
  ev.data.fd = srv_fd;

  if (epoll_ctl(epfd, EPOLL_CTL_ADD, srv_fd, &ev) < 0) {
    perror("epll_ctl:srv_fd register failed");
    exit(-1);
  }
  int nfds;  // 监听事件发生的个数

  while (1) {
    nfds = epoll_wait(epfd, evs, MAX_EVENTS, -1);
    if (nfds == -1) {
      perror("start epoll_wait failed");
      exit(-1);
    }
    // printf("epoll wait\n");
    for (int i = 0; i < nfds; i++) {
      if (evs[i].data.fd == srv_fd) {  // 客户端连接请求来了
        clnt_fd = accept(srv_fd, (struct sockaddr *)&clnt_addr, &clnt_addr_len);
        if (clnt_fd < 0) {
          perror("accept client_sockfd failed");
          exit(-1);
        }

        ev.events = EPOLLIN;
        ev.data.fd = clnt_fd;
        if (epoll_ctl(epfd, EPOLL_CTL_ADD, clnt_fd, &ev) < 0) {
          perror("epoll_ctl:clnt_fd register failed");
          exit(EXIT_FAILURE);
        }

        printf("client %s has connected.\n", inet_ntoa(clnt_addr.sin_addr));
      } else {  // 客户端有数据发送过来
        memset(buf, 0, sizeof(buf));

        len = recv(clnt_fd, buf, BUFSIZE - 1, 0);

        if (len < 0) {
          perror("receive from client failed");
          exit(-1);
        }
        printf("从客户端收到的消息：%s\n", buf);
        send(clnt_fd, "I have received your message.", 30, 0);
      }
    }
  }

  close(clnt_fd);
  close(srv_fd);
  return 0;
}
