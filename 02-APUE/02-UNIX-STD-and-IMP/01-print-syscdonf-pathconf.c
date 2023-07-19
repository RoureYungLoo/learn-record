#include <errno.h>
#include <limits.h>

#include "apue.h"

static void print_sysconf(char *, int);
static void print_pathconf(char *, const char *, int);

int main(int argc, char const *argv[]) {
  //   if (argc!=2)
  // err_quit("usage: a.out <dirname>");

  // #ifdef ARG_MAX
  //   printf("ARG_MAX defined to be %ld\n", (long)ARG_MAX + 0);
  // #else
  //   printf("no symbol for ARG_MAX\n");
  // #endif

  // #ifdef _SC_ARG_MAX
  //   print_sysconf("ARG_MAX=", _SC_ARG_MAX);
  // #else
  //   printf("no symbol for _SC_ARG_MAX\n");
  // #endif

  // #ifdef _PC_MAX_CANON
  //   print_pathconf("MAX_CANON = ", argv[1], _PC_MAX_CANON);
  // #else
  //   printf("no symbol for _PC_MAX_CANON\n");
  // #endif

  //   printf("每个进程最多打开文件数 ：%ld\n", sysconf(_SC_OPEN_MAX));
  //   printf("登录名最大长度 ：%ld\n", sysconf(_SC_LOGIN_NAME_MAX));

  char *path;
  int fd;
  if (argc == 1) {
    path = ".";
  } else {
    path = argv[1];
  }
  printf(path);
  printf("路径 %s 文件链接计数的最大值 ：%ld\n", path,
         pathconf(path, _PC_LINK_MAX));
  fd = fopen(argv[1], "w+");
  printf("路径%s的符号链接字节数%ld\n",argv[1],(fd,_PC_SYMLINK_MAX));

  return 0;
}

static void print_sysconf(char *msg, int name) {
  long val;
  fputs(msg, stdout);
  errno = 0;
  if ((val = sysconf(name)) < 0) {
    if (errno != 0) {
      if (errno == EINVAL) {
        fputc(" (不支持)\n", stdout);
      } else {
        fputc(" (no limit)\n", stdout);
      }
    } else {
      printf("%ld\n", val);
    }
  }
}
static void print_pathconf(char *msg, const char *path, int name) {
  long val;
  fputc(msg, stdout);
  errno = 0;
  if ((val = pathconf(path, name)) < 0) {
    if (errno != 0) {
      if (errno == EINVAL) {
        fputc(" (不支持)\n", stdout);
      } else {
        err_sys("pathconf error,path=%s ", path);
      }
    } else {
      fputc(" (no limit)\n", stdout);
    }
  } else {
    printf(" %ld\n", val);
  }
}
