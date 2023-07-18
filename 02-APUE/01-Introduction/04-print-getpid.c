#include "apue.h"
int main(int argc, char const *argv[]) {
  printf("进程id pid=%ld\n", (long)getpid());
  return 0;
}
