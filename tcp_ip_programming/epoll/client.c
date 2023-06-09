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

#define BUFSIZE 40

int main(int argc, char const *argv[]) {
  int clnt_fd;
  int len;
  struct sockaddr_in srv_addr;
  char buf[BUFSIZE];
  memset(&srv_addr, 0, sizeof(srv_addr));
  srv_addr.sin_family = AF_INET;
  srv_addr.sin_addr.s_addr = inet_addr("192.168.198.128");
  srv_addr.sin_port = htons(8000);

  clnt_fd = socket(AF_INET, SOCK_STREAM, 0);
  if (clnt_fd < 0) {
    perror("socket error");
    exit(-1);
  }

  if (connect(clnt_fd, (struct sockaddr *)&srv_addr, sizeof(srv_addr)) < 0) {
    perror("connect error");
    exit(-1);
  }

  while (1) {
    memset(buf, 0, sizeof(buf));
    printf("Please input the message: ");
    scanf("%s", buf);
    // exit
    if (strcmp(buf, "exit") == 0) break;

    send(clnt_fd, buf, strlen(buf), 0);

    len = recv(clnt_fd, buf, BUFSIZE, 0);
    if (len < 0) {
      perror("recv failed");
      exit(-1);
    }
    printf("从服务端收到的消息: %s\n", buf);
  }

  close(clnt_fd);
  return 0;
}
