#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include "apue.h"

char buf1[]="abcdefjhij";
char buf2[]="ABCDEFGHIJ";
int main(int argc, char const *argv[])
{
    int fd,ret;

    fd=creat("file.hole",FILE_MODE);
    if(fd<0) exit(-1);

    ret=write(fd,buf1,10);
    if(ret!=10) exit(-1);

    ret=lseek(fd,1000,SEEK_SET);
    if(ret==-1) exit(-1);

    ret=write(fd,buf2,10);
    if(ret!=10) exit(-1);

    return 0;
}
