/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-28 21:31:30
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-28 23:04:32
 */
#include <iostream>
#include <map>

void print(std::map<std::string, int> pairs);
std::map<std::string, int> genTmpMap();

// 打印迭代器指向的键值对
template <class T>
void printIterator(T it);
// void printIterator(std::map<std::string, int>::iterator it);
// void printIterator(std::map<std::string, int>::const_iterator it);
// void printIterator(std::map<std::string, int>::reverse_iterator it);
// void printIterator(std::map<std::string, int>::const_reverse_iterator it);

int main(int argc, char const *argv[]) {
  // create a map [Start]
  std::map<std::string, int> map01;  // 1、空的
  std::map<std::string, int> map02{{"key201", 201},
                                   {"key203", 203},
                                   {"key204", 204},
                                   {"key202", 202}};  // 2、初始化列表
  std::map<std::string, int> map03{
      std::make_pair("key301", 301),
      std::make_pair("key302", 302)};       // 3、初始化列表和make_pair
  std::map<std::string, int> map04(map03);  // 4、调用拷贝构造函数
  std::map<std::string, int> map05(genTmpMap());  // 5、调用移动构造函数
  std::map<std::string, int> map06(++map02.begin(),
                                   --map02.end());  // 6、范围拷贝
  std::map<std::string, int, std::greater<std::string>> map07{
      {"key_y", 123},
      {"key_a", 124},
      {"key_c", 125},
      {"key_x", 126},
      {"key_b", 127}};  // 7、指定排序规则
  // create a map [End]
  print(map01);
  print(map02);
  print(map03);
  print(map04);
  print(map05);
  print(map06);
  //   print(map07);//编译报错
  for (std::map<std::string, int>::iterator it = map07.begin();
       it != map07.end(); it++) {
    std::cout << it->first << ": " << it->second << std::endl;
  }
  // map members [Start]
  std::cout << "==========[map members]=========\n";

  std::map<std::string, int>::iterator it;
  it = map07.begin();
  printIterator(it);
  it = --map07.end();
  printIterator(it);  // 注意位置

  std::map<std::string, int>::const_iterator cit;
  cit = map07.cbegin();
  //   cit->second=123;编译报错
  printIterator(cit);
  cit = --map07.cend();
  //   cit->first="test";编译报错
  printIterator(cit);

  std::map<std::string, int>::reverse_iterator rit;
  rit = map07.rbegin();
  printIterator(rit);
  rit = --map07.rend();
  printIterator(rit);

  std::map<std::string, int>::const_reverse_iterator crit;
  crit = map07.crbegin();
  printIterator(crit);
  crit = --map07.crend();
  printIterator(crit);

  it = map07.find("key_c");
  printIterator(it);
  it = map07.find(
      "key_cc");  // 找不到则返回指向最后一个元素下一个位置的双向迭代器
  printIterator(--it);

  it = map07.lower_bound("key_c");  // 第一个大于或等于 key 的键值对的双向迭代器
  printIterator(it);

  it = map07.upper_bound("key_c");  // 第一个大于 key 的键值对的迭代器
  printIterator(it);

  auto pair1 = map07.equal_range("key_c");  // 返回一个pair对象，2个双向迭代器
  std::pair<std::map<std::string,int>::iterator,std::map<std::string,int>::iterator> pair2=map07.equal_range("key_c");//返回一个pair对象，2个双向迭代器
  printIterator(pair2.first);
  printIterator(pair2.second);
  
  // map members [End]

  return 0;
}

void print(std::map<std::string, int> pairs) {
  for (auto pair : pairs)
    std::cout << pair.first << ": " << pair.second << std::endl;
}

std::map<std::string, int> genTmpMap() {
  std::map<std::string, int> tmpMap{{"keytmp1", 1001},
                                    std::make_pair("keytmp2", 1002)};
  return tmpMap;
}

// 打印迭代器指向的键值对
template <class T>
void printIterator(T it) {
  std::cout << it->first << ": " << it->second << std::endl;
}
// void printIterator(std::map<std::string, int>::const_iterator it) {
//   std::cout << it->first << ": " << it->second << std::endl;
// }
// void printIterator(std::map<std::string, int>::reverse_iterator it) {
//   std::cout << it->first << ": " << it->second << std::endl;
// }
// void printIterator(std::map<std::string, int>::const_reverse_iterator it) {
//   std::cout << it->first << ": " << it->second << std::endl;
// }