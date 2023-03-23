
#include <iostream>
#include <list>


void print(std::list<int> items);
bool Predicate(int x) { return x >= 40; }      // 谓词函数
bool Predicate2(int x) { return x % 2 == 0; }  // 谓词函数

int main(int argc, char const *argv[]) {
  std::list<int> values({23, 14, 51, 87, 15, 51, 29, 53, 43, 19, 57, 29, 41});
  std::list<int> items({1, 2, 3, 3, 5, 6, 7, 8, 9, 10});
  /**=============[list容器]====[删除元素]=========[start]=========
   * pop_front()，删除位于 list 容器头部的一个元素。
   * pop_back()，删除位于 list 容器尾部的一个元素。
   * erase()，该成员函数既可以删除 list
   * 容器中指定位置处的元素，也可以删除容器中某个区域内的多个元素。
   * clear()，删除 list 容器存储的所有元素。
   * remove(val)，删除容器中所有等于 val 的元素。
   * unique()，删除容器中相邻的重复元素，只保留一份。
   * remove_if()，删除容器中满足条件的元素。
   */
  //   values.pop_front();
  items.pop_back();
  auto first = values.cbegin(), last = values.cend();
  for (int i = 0; i < 3; i++) {
    first++;
    last--;
  }
  values.erase(first, last);
  values.erase(values.cbegin());
  values.clear();
  values.remove(51);
  items.unique();

  values.remove_if(Predicate);
  items.remove_if(Predicate2);
  items.remove_if([](int x) { return x % 2 != 0; });
  // =============[list容器]====[删除元素]=========[end]=========
  // list 元素访问：不支持list[i], list.at(), list.data()

  // list.front() 返回首元素的引用
  // list.back()   返回尾元素的引用
  std::cout << *(--std::end(values)) << " ";
  std::cout << *std::begin(values) << "\n";
  std::cout << values.front() << " " << values.back() << std::endl;
  values.assign(10, 111);
  values.assign(items.begin(), items.end());

  /**==========[list容器]==[插入元素]=============================
   * 1、push_front()：向 list 容器首个元素前添加新元素；
   * 2、push_back()：向 list 容器最后一个元素后添加新元素；
   * 3、emplace_front()：在容器首个元素前直接生成新的元素；
   * 4、emplace_back()：在容器最后一个元素后直接生成新的元素；
   * 5、emplace()：在容器的指定位置直接生成新的元素；
   * 6、insert()：在指定位置插入新元素；
   * 7、splice()：将其他 list
   * 容器存储的多个元素添加[移动]到当前list容器的指定位置处。
   */
  values.push_front(111);
  values.push_back(999);
  values.emplace_front(11);
  values.emplace_back(99);
  values.emplace(values.cbegin(), 1111);
  values.insert(values.cbegin(), 1111);
  values.insert(values.cbegin(), 2, -11);
  values.insert(values.cbegin(), {1, 2, 3});

  auto last = items.begin();
  for (int i = 0; i < 4; i++) {
    last++;
  }
  values.insert(values.begin(), items.begin(), last);

  values.splice(values.cend(), items);
  values.splice(values.cbegin(), items, --items.cend());
  auto index = items.begin();
  auto pos = values.begin();
  int i = 0;
  while (i++ < 4) {
    index++;
    if (i < 3) pos++;
  }
  //   values.splice(pos, items, index);//5
  values.splice(pos, items, items.begin(), index);  // 1,2,3,4
  print(values);
  // print(items);
  return 0;
}

void print(std::list<int> items) {
  std::list<int>::iterator it;
  for (it = items.begin(); it != items.end(); it++) {
    std::cout << *it << " ";
  }
  std::cout << std::endl;
}
