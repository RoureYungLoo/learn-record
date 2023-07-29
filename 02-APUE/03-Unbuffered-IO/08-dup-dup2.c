#include "header.h"

int main(int argc, char const *argv[])
{
    int fd,newfd,newfd2;
    fd=open("/etc/passwd",O_RDONLY);
    if(fd<0){
        perror("open error");
        exit(-1);
    }
    
    newfd=dup(fd);
    if(newfd==-1){
        perror("dup error");
        exit(-2);
    }
    printf("newfd : %d\n",newfd);

    if ((newfd2=dup2(fd,10))==-1){ //原子操作
        perror("dup2 error");
        exit(-3);
    }
    printf("newfd2 : %d\n",newfd2);

    return 0;
}
