#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include "apue.h"
#include <unistd.h>
int main(int argc, char const *argv[])
{
    char buf[1024],*filename="/etc/passwd";
    int fd,nread;
    memset(buf,0,1024);
    fd=open(filename,O_RDONLY);

    if(fd<0) exit(-1);
    
    nread=read(fd,buf,20);
    if(nread==-1) exit(-1);
    printf("读取文件 \"%s\" %d 字节：%s\n",filename,nread,buf);
    return 0;
}
