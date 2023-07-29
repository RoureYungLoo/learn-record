#include <stdio.h>  
#include <sys/stat.h>  
#include <fcntl.h>  
#include <stdlib.h>  
#include <unistd.h> 
#include <errno.h>

int open(const char *pathname, int oflag, ... /*mode_t mode*/);
int openat(int fd, const char *pathname, int oflag, ... /*mode_t mode*/);
/**
 * 1. pathname是绝对路径，此时open()=openat()
 * 2. pathname是相对路径，当
 *                          fd!=AT_FDCWD时，打开的路径为'fd/pathname' (非进程的工作目录)
 *                          fd==AT_FDCWD时，打开当前路径下的pathname，等同于open()
 */
int main(int argc, char const *argv[]) {
  int fd;
  fd = open("testfile.txt", O_RDWR);
  printf("fd: %d\n", fd);

//   fd = open("testdir",O_RDONLY);
  fd = open("/home/ruoyang",O_RDONLY);
//   读写方式打开/home/ruoyang/file.txt
  int newfd=openat(fd,"file.txt",O_RDWR);
  perror(errno);
  printf("newfd: %d\n", newfd);

  return 0;
}
