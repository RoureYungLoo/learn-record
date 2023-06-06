
#include "calc.h"

#include <iostream>

int main(int argc, char const *argv[]) {
  double a, b, c, d;
  a = my_add(8, 2);
  b = my_sub(8, 2);
  c = my_multi(8, 2);
  d = my_div(8, 2);
  std::cout << "加：8+2=" << a << std::endl;
  std::cout << "减：8-2=" << b << std::endl;
  std::cout << "乘：8*2=" << c << std::endl;
  std::cout << "除：8/2=" << d << std::endl;
  return 0;
}
