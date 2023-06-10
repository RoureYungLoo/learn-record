#include <unistd.h>

#include <iostream>
#include <mutex>
#include <thread>

std::mutex mtx_aaa;

// void print_block(int n, char c) {
//   mtx_aaa.lock();  // 加锁
//   for (int i = 0; i < n; i++) {
//     std::this_thread::sleep_for(std::chrono::milliseconds(10));  // 10ms
//     std::cout << c;
//   }
//   std::cout << '\n';

//   mtx_aaa.unlock();  // 解锁
// }

void print_block(int n, char c) {
  
  std::lock_guard<std::mutex> lock(mtx_aaa);

  for (int i = 0; i < n; i++) {
    std::this_thread::sleep_for(std::chrono::milliseconds(10));  // 10ms
    std::cout << c;
  }
  std::cout << '\n';

}

int main(int argc, char const *argv[]) {
  /* code */
  std::thread th1(print_block, 20, '*'), th2(print_block, 20, '$');
  th1.join();
  th2.join();
  return 0;
}

/*
Mutex类
    std::mutex	最基本的 Mutex 类。
    std::recursive_mutex	递归 Mutex 类。
    std::time_mutex	定时 Mutex 类。
    std::recursive_timed_mutex	定时递归 Mutex 类。

Mutex类操作
    lock()：资源上锁
    unlock()：解锁资源
    trylock()：查看是否上锁，它有下列3种类情况：
        （1）未上锁返回false，并锁住；
        （2）其他线程已经上锁，返回true；
        （3）同一个线程已经对它上锁，将会产生死锁。

lock_guard
    创建lock_guard对象时，它将尝试获取提供给它的互斥锁的所有权。
    当控制流离开lock_guard对象的作用域时，lock_guard析构并释放互斥量。
    特点：
        ·创建即加锁，作用域结束自动析构并解锁，无需手工解锁
        ·不能中途解锁，必须等作用域结束才解锁
        ·不能复制

unique_lock
    lock_guard 的升级加强版
    特点：
        ·创建时可以不锁定（通过指定第二个参数为std::defer_lock），而在需要时再锁定
        ·可以随时加锁解锁
        ·作用域规则同 lock_grard，析构时自动释放锁
        ·不可复制，可移动
        ·条件变量需要该类型的锁作为参数（此时必须使用unique_lock）


*/
