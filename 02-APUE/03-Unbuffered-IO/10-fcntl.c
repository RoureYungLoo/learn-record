
#include <fcntl.h>

#include "apue.h"

void set_fl(int fd, int flags);
void clr_fl(int fd, int flags);

void set_fl(int fd, int flags) {
  int val;
  if ((val = fcntl(fd, F_GETFL, 0)) < 0) {
    err_sys("fcntl F_GETFL error");
  }
  val |= flags; //设置flags
  if ((fcntl(fd, F_SETFL, val)) < 0) {
    err_sys("fcntl F_SETFL error");
  }
}

void clr_fl(int fd, int flags) {
  int val;
  if ((val = fcntl(fd, F_GETFL, 0)) < 0) {
    err_sys("fcntl F_GETFL error");
  }
  val &= ~flags; //关闭flags
  if ((fcntl(fd, F_SETFL, val)) < 0) {
    err_sys("fcntl F_SETFL error");
  }
}
void clr_fl(int fd, int flags) {}
int main(int argc, char const *argv[]) {
  int val;
  if (argc != 2) err_quit("usage: a.out [fd]");

  val = fcntl((atoi(argv[1])), F_GETFL, 0);
  if (val < 0) {
    err_sys("fcntl error");
  }

  switch (val & O_ACCMODE) {
    case O_RDONLY:
      printf("read only");
      break;

    case O_WRONLY:
      printf("write only");
      break;

    case O_RDWR:
      printf("read write");
      break;
    default:
      printf("unknown access mode");
      break;
  }

  if (val & O_APPEND) {
    printf(", append");
  }

  if (val & O_NONBLOCK) {
    printf(", non blokcking");
  }

  if (val & O_SYNC) {
    printf(", synchronous writes");
  }

#if !defined(_POSIX_C_SOURCE) && defined(O_FSYNC) && (O_FSYNC != OSYNC)
  if (val & O_FSYNC) {
    printf(", synchronous writes");
  }
#endif
  printf("\n");
  return 0;
}
