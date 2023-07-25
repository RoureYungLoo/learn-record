#include "header.h"

/**
 * stat
 * fstat 相对于当前目录的fd
 * fstatat  符号链接所指向的文件相关信息
 * lstat    符号链接本身的相关信息，而不是其指向文件的信息
 */
void p_sb( struct stat sb);
int main(int argc, char const* argv[]) {
  const char* filename = "/etc/passwd";
  struct stat sb;
  int fd, ret;

  // ret=stat(filename,&sb);

  if ((fd = open(filename, O_RDONLY)) == -1) {
    err_sys("open error");
    exit(-1);
  }

  if ((fstat(fd, &sb)) == -1) {
    err_sys("fstat error");
    exit(-1);
  }
//   fstatat(fd,"/usr/lib64/libz.so",&sb,AT_SYMLINK_NOFOLLOW);
// fd=AT_FDCWD
//      1.pathname是绝对路径，则忽略fd
//      2.pathname是相对路径，计算fd/pathname的文件信息
// AT_SYMLINK_NOFOLLOW控制是否计算实际文件的信息
  if (ret == -1) {
    err_sys("stat error");
  }

p_sb(sb);
  return 0;
}
void p_sb( struct stat sb) {
  printf("st_atime: %ld\n", sb.st_atime);
  // printf("%ld\n",sb.st_atimensec);
  printf("st_blksize %ld\n", sb.st_blksize);
  printf("st_blocks %ld\n", sb.st_blocks);
  printf("st_ctime %ld\n", sb.st_ctime);
  // printf("%ld\n",sb.st_ctimensec);
  printf("st_dev %ld\n", sb.st_dev);
  printf("st_gid %ld\n", sb.st_gid);
  printf("st_ino %ld\n", sb.st_ino);
  printf("st_mode %ld\n", sb.st_mode);
  printf("st_mtime %ld\n", sb.st_mtime);
  // printf("%ld\n",sb.st_mtimensec);
  printf("st_nlink %d\n", sb.st_nlink);
  printf("st_rdev %d\n", sb.st_rdev);
  printf("st_size %d\n", sb.st_size);
  printf("st_uid %d\n", sb.st_uid);
}
/**
 * 普通文件
 * 目录文件
 * 块设备文件
 * 字符文件
 * 管道文件
 * 套接字文件
 * 符号链接文件
 */