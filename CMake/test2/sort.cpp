#include "sort.h"

#include <iostream>

#include "calc.h"
int main(int argc, char const *argv[]) {
  insert();
  select();
  double ret = my_add(3, 4);
  std::cout << "sort测试中调用calc add: 3+4=" << ret << std::endl;
  return 0;
}
