/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-30 10:10:54
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-30 10:30:08
 */
#include <unistd.h>

#include <iostream>
#include <mutex>
#include <thread>

std::mutex mtx;

void func(int n, char c) {
  mtx.lock();
  for (size_t i = 0; i < n; i++) {
    std::cout << c;
    std::this_thread::sleep_for(std::chrono::milliseconds(500));
  }
  std::cout << std::endl;
  mtx.unlock();
}
int main(int argc, char const *argv[]) {
  std::thread th1(func, 10, '*');
  std::thread th2(func, 15, '$');
  th1.detach();
  th2.detach();
  sleep(500);
  return 0;
}
