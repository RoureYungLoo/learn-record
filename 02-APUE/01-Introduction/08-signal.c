#include <sys/wait.h>

#include "apue.h"

static void catch (int);
int main(int argc, char const *argv[]) {
  char buf[MAXLINE];
  pid_t pid;
  int status;
  printf("##");

    signal(SIGINT,catch);

  while (fgets(buf, MAXLINE, stdin) != NULL) {
    if (buf[strlen(buf) - 1] == '\n') {
      buf[strlen(buf) - 1] = 0;
    }
    if ((pid = fork()) == 0)  // 子进程
    {
      execlp(buf, buf, (char *)0);
      err_ret("不能执行 %s", buf);
      exit(127);
    }
    // 父进程
    if ((pid = waitpid(pid, &status, 0)) < 0) {
      err_sys("waitpid error");
    }
    printf("##");
  }
  return 0;
}

static void catch (int signo) { printf("interrupt\n%%"); }