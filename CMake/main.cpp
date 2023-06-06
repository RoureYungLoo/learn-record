/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-06-05 17:13:25
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-06-06 09:46:33
 */

#include <iostream>
#include <string>

#include "header.h"
int main(void) {
  double a, b, c, d;
  a = my_add(8, 2);
  b = my_sub(8, 2);
  c = my_multi(8, 2);
  d = my_div(8, 2);

#ifdef DEBUG
  printf("这是一行日志\n");
#endif

  std::cout << "加：8+2=" << a << std::endl;
  std::cout << "减：8-2=" << b << std::endl;
  std::cout << "乘：8*2=" << c << std::endl;
  std::cout << "除：8/2=" << d << std::endl;

  return 0;
}
