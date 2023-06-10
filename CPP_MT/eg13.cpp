#include <unistd.h>

#include <iostream>
#include <thread>

void func(int x) {
  for (int i = 0; i < 10'0000'0000; i++) {
    /* code */
  }
  std::this_thread::sleep_for(std::chrono::seconds(1));
  auto tid=std::this_thread::get_id();
  std::cout << tid << std::endl;
}

int main(int argc, char const *argv[]) {
  // 创建线程
  std::thread th1(func, 1), th2(func, 2);
  
  // th1 = std::thread(func,1);
  // std::thread th2;
  // th2 = std::thread(func,100);

  // 启动th1、th2线程的线程结束前需要指定以何种方式等待th1、th2线程执行结束
//   th1.detach();
//   th2.detach();

    th1.join();
    th2.join();
  return 0;
}
