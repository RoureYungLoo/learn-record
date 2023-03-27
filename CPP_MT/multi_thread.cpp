/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-24 15:26:38
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-24 17:12:07
 */
#include <unistd.h>
#include <iostream>
#include <thread>
using std::chrono::system_clock;

void thread_func();
void thread_func2(int x);

int main(int argc, char const *argv[]) {
  int c = 0;
  std::thread thread01(thread_func);
  std::thread thread02(thread_func2, 100);

  // thread01.join();
  // thread02.join();
  thread01.detach();
  thread02.detach();

  // std::thread (thread_func2,3).detach();
  while (1) {
    sleep(1);
    if (c == 10) std::this_thread::yield();
    // std::cout << c << ": 主线程ID: " << std::this_thread::get_id() <<
    // std::endl;
  }

  return 0;
}

void thread_func() {
  int i = 0;
  while (i++ < 777) {
    std::this_thread::sleep_for(std::chrono::seconds(1));
    // std::this_thread::sleep_for(std::chrono::milliseconds(200));
    std::cout <<i<< ": 子线程1 : " << std::this_thread::get_id() << std::endl;
  }
}

void thread_func2(int x) {
  int i = 0;
  while (1) {

    // std::this_thread::sleep_for(std::chrono::seconds(3));
    // std::this_thread::sleep_for(std::chrono::milliseconds(500));

    std::time_t tt=system_clock::to_time_t(system_clock::now());
    struct std::tm* ptm=std::localtime(&tt);
    ++ptm->tm_min;//1分钟
    ptm->tm_sec=0;
    std::this_thread::sleep_until(system_clock::from_time_t(mktime(ptm)));
    std::cout << "子线程2,x= " << x << "线程ID: " << std::this_thread::get_id()
              << std::endl;
  }
}