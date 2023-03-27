#include <stdio.h>
int func();
/*
int main() {
  func();
  printf("%d", num);//编译不通过
  return 0;
}
int num = 3;
int func() { printf("%d\n", num); }
*/

int main() {
  func();
  extern int num;     // 声明外部变量
  printf("%d", num);  // 编译通过
  return 0;
}
int num = 3;
int func() { printf("%d\n", num); }