#include "header.h"
int main(int argc, char const *argv[])
{
    char *filename="write_test_file";
    char  *buf="this is a file for test write.\n";
    int fd,nwrite;
    fd=open(filename,O_RDWR|O_CREAT|O_EXCL,0644);
    if (fd<0) exit(-1);
    
    // nwrite=write(fd,buf,sizeof(buf));// X    
    nwrite=write(fd,buf,strlen(buf));// √ 
    if (nwrite==-1) exit(-1);

    close(fd);
    return 0;
}
