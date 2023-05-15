#include <iostream>
#include <set>

void printSet(std::set<std::string> set);

std::set<std::string> retSet() {
  std::set<std::string> a_set{"cat", "dog", "pig", "month", "day", "year"};
  return a_set;
}
int main() {
  // 1.默认构造函数
  std::set<std::string> myset;
  // 2.使用{ }
  std::set<std::string> myset2{"elem1", "elem2", "elem3"};
  // 3.拷贝构造函数
  std::set<std::string> myset3(myset2);
  std::set<std::string> myset3_2 = myset3;
  // 4.移动构造函数
  std::set<std::string> myset4(retSet());
  std::set<std::string> myset4_2 = retSet();
  // 5.使用已有set
  std::set<std::string> myset5(myset4.begin(), myset4.end());
  // 6.指定排序规则
  std::set<std::string, std::greater<std::string>> myset6{"one", "two",
                                                          "three"};

  printSet(myset2);
}

void printSet(std::set<std::string> set) {
  for (auto elem : set) std::cout << elem << std::endl;
}