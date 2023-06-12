#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/poll.h>
#include <sys/socket.h>
#include <unistd.h>

#define OPEN_MAX 1024
#define BUFSIZE 1024

int main(int argc, char const *argv[]) {
  /* code */

  int srv_fd, clnt_fd;
  struct sockaddr_in srv_addr, clnt_addr;
  srv_addr.sin_family = AF_INET;
  srv_addr.sin_addr.s_addr = inet_addr("127.0.0.1");
  srv_addr.sin_port = htons(5000);

  socklen_t srv_addr_len, clnt_addr_len;
  srv_addr_len = sizeof(srv_addr);

  srv_fd = socket(AF_INET, SOCK_STREAM, 0);

  bind(srv_fd, (struct sockaddr *)&srv_addr, srv_addr_len);

  listen(srv_fd, 100);

  struct pollfd pfds[OPEN_MAX];
  pfds[0].fd = srv_fd;
  pfds[0].events = POLLIN;

  for (int i = 1; i < OPEN_MAX; i++) {
    pfds[i].fd = -1;
  }

  int max_fd = 0;
  char buf[BUFSIZE];
  memset(buf, 0, BUFSIZE);

  while (1) {
    int nfds = poll(pfds, max_fd + 1, -1);
    //
    if (pfds[0].revents & POLLIN) {
      clnt_fd = accept(srv_fd, (struct sockaddr *)&clnt_addr, &clnt_addr_len);

      for (int i = 0; i < OPEN_MAX; i++) {
        if (pfds[i].fd == -1) {
          pfds[i].fd = clnt_fd;
          pfds[i].events = POLLIN;
          max_fd++;
          break;
        }
      }
      if (--nfds <= 0) continue;
    }

    for (int i = 1; i <= max_fd; i++) {
        
      if (pfds[i].fd & POLLIN) {
        read(pfds[i].fd, buf, BUFSIZE);
        write(pfds[i].fd, buf, BUFSIZE);
      }

      if (--nfds <= 0) {
        break;
      }
    }
  }

  for (int i = 0; i < max_fd + 1; i++) {
    if (pfds[i].fd != -1) {
      close(pfds[i].fd);
    }
  }

  return 0;
}
