#include "apue.h"
#include <sys/wait.h>
int main(int argc, char const *argv[])
{
    char buf[MAXLINE];
    pid_t pid;
    int status;
    printf("##");
    
    while (fgets(buf,MAXLINE,stdin)!=NULL)
    {
        if (buf[strlen(buf)-1]=='\n')
        {
            buf[strlen(buf)-1]=0;
        }
        if ((pid=fork())==0) //子进程
        {
            execlp(buf,buf,(char*)0);
            err_ret("不能执行 %s",buf);
            exit(127);
        }
        //父进程
        if ((pid=waitpid(pid,&status,0))<0)
        {
            err_sys("waitpid error");
        }
        printf("##");
    
    }
    
    return 0;
}
