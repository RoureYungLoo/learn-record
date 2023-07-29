#include "header.h"

/**
 * sync         块缓冲区排入写队列
 * fsync        文件属性和文件数据
 * fdatasync    文件数据
 */

int main(int argc, char const *argv[]) {
  int fd;
  char *buf = "this is a file for 09 test.";
  fd = open("09-file", O_CREAT | O_RDWR, 0644);
  if (fd < 0) {
    perror("open error");
    exit(-1);
  }
  write(fd, buf, strlen(buf));
  //   sync();
  //   fsync();
  //   fdatasync();
  sleep(30);
  return 0;
}
