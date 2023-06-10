#include <unistd.h>

#include <condition_variable>
#include <iostream>
#include <mutex>
#include <thread>

// th1调用wait：th1被阻塞，th1自动释放锁
// th1被notify：th1被唤醒，th1自动获得锁，锁的状态和被阻塞前相同

std::mutex mtx;
std::condition_variable cv;

int cargo = 0;
bool ship_available() { return cargo != 0; }

void consume(int n) {
  for (int i = 0; i < n; i++) {
    std::unique_lock<std::mutex> lck(mtx);  // 自动上锁

    // 第二个参数为false才阻塞（wait），阻塞完即unlock，给其它线程资源
    cv.wait(lck, ship_available);

    std::cout << cargo << "\n";

    cargo = 0;
  }
}

int main(int argc, char const* argv[]) {
  std::thread xiaofei(consume, 10);
  for (int i = 0; i < 10; i++) {
    while (ship_available()) std::this_thread::yield();
    std::unique_lock<std::mutex> lck(mtx);
    cargo = i + 1;
    cv.notify_one();
  }
  xiaofei.join();
  return 0;
}

/*
有2个类：condition_variable和condition_variable_any,
    前者需结合unique_lock使用，后者可以结合任何锁使用
condition_variable条件变量可以阻塞（wait、wait_for、wait_until）调用的线程直到
使用（notify_one或notify_all）通知恢复为止。

函数名                 说明
condition_variable	  构建对象
析构	                 删除
wait	                Wait until notified
wait_for	            Wait for timeout or until notified
wait_until	          Wait until notified or time point
notify_one	          解锁一个线程，如果有多个，则未知哪个线程执行
notify_all	          解锁所有线程
cv_status	            这是一个类，表示variable 的状态，如下所示

  enum class cv_status { no_timeout, timeout };


*/
