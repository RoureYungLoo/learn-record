#include <unistd.h>

#include <iostream>
#include <mutex>
#include <thread>

struct Box {
  explicit Box(int num) : num_things(num) {}
  int num_things;
  std::mutex mtx;
};

void transfer(Box& from, Box& to, int num) {
  
  // defer_lock表示创建时不加锁
  std::unique_lock<std::mutex> lock1(from.mtx,std::defer_lock);
  std::unique_lock<std::mutex> lock2(to.mtx,std::defer_lock);

  std::lock(lock1,lock2);

  from.num_things -= num;
  to.num_things += num;

  // lock1.unlock();
  // lock2.unlock();
  
}//作用域结束自动解锁，也可以手动解锁

int main(int argc, char const* argv[]) {
  Box box1(100);
  Box box2(50);

  std::thread th1(transfer, std::ref(box1), std::ref(box2), 10),
      th2(transfer, std::ref(box2), std::ref(box1), 5);
  th1.join();
  th2.join();
  std::cout << box1.num_things << std::endl;
  std::cout << box2.num_things << std::endl;

  return 0;
}

/*
unique_lock
    lock_guard 的升级加强版
    特点：
        ·创建时可以不锁定（通过指定第二个参数为std::defer_lock），而在需要时再锁定
        ·可以随时加锁解锁
        ·作用域规则同 lock_grard，析构时自动释放锁
        ·不可复制，可移动
        ·条件变量需要该类型的锁作为参数（此时必须使用unique_lock）


*/
