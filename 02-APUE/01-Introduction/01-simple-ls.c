#include <dirent.h>

#include "apue.h"
int main(int argc, char const *argv[]) {
  DIR *dp;
  struct dirent *dirp;
  dp = opendir(argv[1]);
  while ((dirp = readdir(dp)) != NULL) {
    printf("%s\t", dirp->d_name);
  }
  closedir(dp);
  printf("\n");
  return 0;
}
