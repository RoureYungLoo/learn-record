#include "header.h"
int main(int argc, char const *argv[]) {
  int i;
  struct stat buf;
  char *ptr = "** unknown mode **";
  for (i = 1; i < argc; i++) {
    printf("%s: ", argv[i]);
    lstat(argv[i],&buf);
    if (S_ISREG(buf.st_mode)) ptr = "regular";
    if (S_ISDIR(buf.st_mode)) ptr = "directory";
    if (S_ISCHR(buf.st_mode)) ptr = "char";
    if (S_ISBLK(buf.st_mode)) ptr = "block";
    if (S_ISFIFO(buf.st_mode)) ptr = "fifo";
    if (S_ISLNK(buf.st_mode)) ptr = "symbolic link";
    if (S_ISSOCK(buf.st_mode)) ptr = "socket";
    printf("%s \n", ptr);
  }

  return 0;
}
