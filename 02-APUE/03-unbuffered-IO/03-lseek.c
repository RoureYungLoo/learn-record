#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include "apue.h"

int main(int argc, char const *argv[])
{
    // if (argc!=2)
    // {
    //     exit(-1);
    // }
    //echo "this is a test file." > creatfile 
    //文件长度20
    // int fd=open(argv[1],O_RDWR);
    // if (fd<0) exit(-1);
    // off_t offset=lseek(fd,10,SEEK_SET);
    // if (offset==-1) exit(-1);
    // printf("文件 %s 当前偏移量 %ld \n",argv[1],offset);

    // offset=lseek(fd,-2,SEEK_END);
    // if (offset==-1) exit(-1);
    // printf("文件 %s 当前偏移量 %ld \n",argv[1],offset);//19

    // offset=lseek(fd,-3,SEEK_CUR);//16
    // if (offset==-1) exit(-1);
    // printf("文件 %s 当前偏移量 %ld \n",argv[1],offset);

    if (lseek(STDIN_FILENO,0,SEEK_CUR)==-1)
    {
        printf("不能对标准输入设置偏移量\n");
    }else{
        printf("可以对标准输入设置偏移量\n");
    }
    
    return 0;
}
