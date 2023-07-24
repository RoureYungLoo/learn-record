#include "header.h"
/**
 * pread = lseek + read 组合而成的原子操作
 * pwrite = lseek + write 组合而成的原子操作
*/
char* filename="file-for-pread-pwrite";
int main(int argc, char const *argv[])
{
    ssize_t nread,nwrite;
    int fd;
    char buf[1024];
    memset(buf,0,1024);

    if ((fd=open(filename,O_RDWR,0644))<0)
    {
        perror("open failed: ");
        exit(-1);
    }
    
    nread=pread(fd,buf,10,5);
    printf("读取%d字节：%s\n",nread,buf);
    printf("当前文件lseek位置：%d\n",lseek(fd,0,SEEK_CUR));

    const char* msg="abcde";
    nwrite = pwrite(fd,msg,strlen(msg),3); //覆盖写！！！
    printf("当前文件lseek位置：%d\n",lseek(fd,0,SEEK_CUR));

    return 0;
}
