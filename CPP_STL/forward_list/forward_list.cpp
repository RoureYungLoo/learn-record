#include <array>
#include <forward_list>
#include <iostream>

void print(std::forward_list<int> items);
int main(int argc, char const *argv[]) {
  // forward_list created start ，added by ruoyang at 2023.3.23 20：00
  std::forward_list<int> values;            // empty
  std::forward_list<int> values2(10);       // with default value
  std::forward_list<int> values3(10, 5);    // with assigned value
  std::forward_list<int> values4(values3);  // copy another forward_list
  std::array<int, 10> arr{11, 12, 13, 14, 15, 16, 17};
  std::forward_list<int> values5(
      arr.begin() + 2,
      arr.begin() + 7);  // index[2,7),copy another container from first to last
  std::forward_list<int> values6({1, 2, 3, 4, 5, 6, 7});
  //  forward_list created end
  print(values);
  print(values2);
  print(values3);
  print(values4);
  print(values5);
  print(values6);
  // forward_list iterator member start ，added by ruoyang at 2023.3.23 20：13
  std::forward_list<int>::iterator it = values5.before_begin();
  std::forward_list<int>::iterator it2 = values5.begin();
  std::forward_list<int>::iterator it3 = values5.end();
  // std::cout<<*(it)<<std::endl; illegal access
  std::cout << *(++it) << std::endl;
  std::cout << *it2 << std::endl;
  // std::cout<<*it3<<std::endl; illegal access

  std::forward_list<int>::const_iterator cit = values5.cbefore_begin();
  std::forward_list<int>::const_iterator cit2 = values5.cbegin();
  std::forward_list<int>::const_iterator cit3 = values5.cend();
  // std::cout << *cit << std::endl; illegal access
  std::cout << *(++cit) << std::endl;
  std::cout << *cit2 << std::endl;
  // std::cout<<*cit3<<std::endl; illegal access
  // forward_list iterator member end
  //forward_list insert member start , added by ruoyang at 2023.3.23 21：03
  values6.push_front(-11);
  values6.emplace_front(-12);
  values6.emplace_after(++values6.cbegin(),-9);
  values6.insert_after(values6.cbefore_begin(),-19);
  values6.splice_after(values6.cbefore_begin(),values5,values5.cbegin(),values5.cend());
  print(values6); 
  //forward_list insert member end
  return 0;
}

void print(std::forward_list<int> items) {
  for (auto item : items) {
    std::cout << item << " ";
  }
  std::cout << std::endl;
}
