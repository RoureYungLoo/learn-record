#include <unistd.h>

#include <condition_variable>
#include <iostream>
#include <mutex>
#include <thread>

std::condition_variable cv;

int value;

void read_value() {
  std::cin >> value;
  cv.notify_all();
}

int main(int argc, char const* argv[]) {
  std::cout << "Please, enter an integer (I'll be printing dots): \n";

  std::thread th(read_value);

  std::mutex mtx;
  std::unique_lock<std::mutex> lck(mtx);
  // while (cv.wait_for(lck, std::chrono::seconds(1)) ==
  // std::cv_status::timeout) {
  //   std::cout << '.' << std::endl;
  // }

  while (cv.wait_until(lck, std::chrono::system_clock::now() +
                                std::chrono::milliseconds(1000)) ==
         std::cv_status::timeout) {
    std::cout << '.' << std::endl;
  }

  std::cout << "You entered: " << value << '\n';

  th.join();
  return 0;
}

/*

wait_for可以指定一个时间段，在当前线程收到通知或者指定的时间 rel_time 超时之前，
该线程都会处于阻塞状态。
而一旦超时或者收到了其他线程的通知，wait_for返回，剩下的 处理步骤和 wait()类似。

wait_for 的重载版本的最后一个参数pred表示 wait_for的预测条件，只有当 pred条件
为false时调用 wait()才会阻塞当前线程，并且在收到其他线程的通知后只有当 pred为
true时才会被解除阻塞。

*/
// template <class Rep, class Period>
// cv_status wait_for(unique_lock<mutex>& lck,
//                    const chrono::duration<Rep, Period>& rel_time);

// template <class Rep, class Period, class Predicate>
// bool wait_for(unique_lock<mutex>& lck,
//               const chrono::duration<Rep, Period>& rel_time, Predicate pred);
