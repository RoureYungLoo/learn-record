/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-06-06 16:14:50
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-06-06 16:21:05
 */
#include <iostream>
#include <memory>

void func(void) {
  int *ptr_int = (int *)malloc(10 * sizeof(int));
  ptr_int[10] = 0;  // 堆内存溢出
}  // ptr_int 内存未释放

int main(int argc, char **argv) {
  func();
  return 0;
}
