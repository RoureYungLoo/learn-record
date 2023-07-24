#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include "apue.h"

int main(int argc, char const *argv[])
{
    if (argc!=2)
    {
        exit(-1);
    }
    const char* filename=argv[1];
    int fd;
    fd=open(filename,O_RDWR|O_CREAT|O_TRUNC,0644);
    printf("打开的%s,fd=%d\n",filename,fd);
    if(close(fd)==0)
    printf("close %s success\n",filename);
    return 0;
}
