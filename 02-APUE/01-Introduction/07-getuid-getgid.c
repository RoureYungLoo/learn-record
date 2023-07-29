#include "apue.h"
int main(int argc, char const *argv[])
{
    printf("用户id：%d,用户组id：%d\n",getuid(),getgid());
    return 0;
}
