#include "apue.h"
#include <errno.h>
int main(int argc, char const *argv[])
{
    fprintf(stderr,"EACCES: %s\n",strerror(EACCES));
    errno=ENOENT;
    perror(argv[0]);
    return 0;
}
