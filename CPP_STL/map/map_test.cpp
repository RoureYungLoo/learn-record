/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-28 21:31:30
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-04-12 21:56:08
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
  std::pair<std::map<std::string, int>::iterator,
            std::map<std::string, int>::iterator>
      pair2 = map07.equal_range("key_c");  // 返回一个pair对象，2个双向迭代器
  printIterator(pair2.first);
  printIterator(pair2.second);

  if (map01.empty()) {
    std::cout << "map empty\n";
  } else {
    std::cout << "map not empty\n";
  }

  map02.swap(map03);
  map03.swap(map02);
  print(map02);
  print(map03);
  // map members [End]
  std::cout << map07.size() << ", " << map07.max_size() << "\n";
  std::cout << map07.count("key_x") << "\n";

  map07["key_b"] = 128;
  std::cout << map07["key_b"] << "\n";
  std::cout << map07.at("key_b") << "\n";

  map02.emplace(std::make_pair("key_start", 129));
  print(map02);
  map02.emplace_hint(map02.begin(), std::make_pair("key111", 111));
  print(map02);

  // map02.clear();
  print(map02);
  std::cout << "====================insert===============\n";
  // map insert
  // 1. map[newKey]=newValue

  // 2. map.insert()
  std::pair<std::string, int> pair3 = {"keyxxx", 100};
  std::pair<std::map<std::string, int>::iterator, bool> ret1, ret2;
  ret1 = map01.insert(pair3);  // 引用传参，返回一个pair对象
  std::cout << ret1.first->first << ": " << ret1.first->second << "\n";
  std::cout << ret1.second << "\n";
  //
  std::pair<std::string, int> pair4 = {"keyxxx", 200};
  ret2 = map01.insert(
      pair4);  // 引用传参，返回一个pair对象<map::iterator,bool>,插入失败时返回的pair对象中的迭代器指向已有key的键值对对象,bool为0
  map01.insert({"key1", 1});
  map01.insert(std::pair<std::string, int>{"key2", 2});
  map01.insert(std::make_pair("key3", 3));

  std::cout << ret2.first->first << ": " << ret2.first->second << "\n";
  std::cout << ret2.second << "\n";

  std::pair<std::string, int> pair5 = {"key4", 300};
  map01.insert(map01.cbegin(), pair5);
  map01.insert(map01.cend(), std::pair<std::string, int>("key21", 21));
  map01.insert(map03.cbegin(), map03.cend());

  map01.insert({{"a", 1}, {"b", 2}, {"c", 3}});

  //3. map.emplace()
  std::pair<std::map<std::string,int>::iterator,bool>ret3;
  ret3 = map01.emplace("b",2);
  printIterator(ret3.first);
  std::cout<<ret3.second<<std::endl;
  
  //4. map.emplace_hint()
  std::map<std::string ,int >::iterator ret4;
  ret4=map01.emplace_hint(map01.begin(),"d",4);
  printIterator(ret4);

  print(map01);
  // erase
  std::cout << "====================erase===============\n";
  map01.erase(map01.cbegin());
  map01.erase("key301");
  map01.erase(map01.begin(),map01.end());

  print(map01);
  std::cout << "====================get value===============\n";
  // get the value of a key
  // 1. map[key]
  std::cout << map07["key_a"] << std::endl;
  // 2. map.at(key)
  std::cout << map07.at("key_a") << std::endl;
  // 3. map.find(key)
  std::cout << map07.find("key_a")->first << ": " << map07.find("key_a")->second
            << std::endl;

  // 4. traverse your map
  for (auto pair : map03) {
    if (!pair.first.compare("key202")) {
      std::cout << pair.second << std::endl;
    }
  }

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