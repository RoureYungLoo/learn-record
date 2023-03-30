/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-27 15:21:59
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-29 17:42:20
 */
#include <iostream>
#include <string>
#include <utility>
int main(int argc, char const *argv[]) {
  /* code */

  std::pair<std::string, double> pair0;
  std::pair<std::string, double> pair1{"key",12.34};
  std::pair<std::string, std::string> pair2("keyone", "value one");
  std::pair<std::string, std::string> pair2_copy(pair2);
  std::pair<std::string, std::string> pair3(std::make_pair("key3", "value3"));
  std::pair<std::string, std::string> pair3_2 =
      std::make_pair("key32", "value3_2");
  std::pair<std::string, std::string> pair4(std::string("key4"),
                                            std::string("value4"));

  pair4.first = "keyy4";
  pair4.second = "valuee5";
  pair4.swap(pair3_2);
  
  std::cout << pair1.first << " : " << pair1.second << std::endl;
  std::cout << pair2.first << " : " << pair2.second << std::endl;
  std::cout << pair2_copy.first << " : " << pair2_copy.second << std::endl;
  std::cout << pair3.first << " : " << pair3.second << std::endl;
  std::cout << pair3_2.first << " : " << pair3_2.second << std::endl;
  std::cout << pair4.first << " : " << pair4.second << std::endl;

//  pair 对象重载了 <、<=、>、>=、==、!= 
  return 0;
}
