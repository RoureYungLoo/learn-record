#include <atomic>
#include <future>
#include <iostream>
#include <mutex>
#include <thread>
using namespace std;

// 无参、无返回值的函数
void doit() { cout << "world" << endl; }

// 有参、无返回值的函数
void count_num(int id, unsigned int n) {
  for (unsigned int i = 1; i <= n; i++)
    ;
  cout << "Thread " << id << "finished" << endl;
}

// 有参、有返回值的函数
template <class... Args>
decltype(auto) sum(Args &&...args) {
  return (0 + ... + args);
}

// 带有引用参数
template <class T>
void alt_val(T &x, T val) {
  x = val;
}

// atomic_int n = 0;
std::atomic<int> n = 0;
/*
real    0m1.831s
user    0m14.043s
sys     0m0.091s
*/
mutex mtx;
void count10000() {
  for (size_t i = 0; i < 100000; i++) {
    // mtx.lock();
    n++;
    // mtx.unlock();
    /*
    real    0m18.366s
    user    0m52.233s
    sys     1m25.801s
    */
  }
}

int main(int argc, char const *argv[]) {
  std::future<int> val =
      async(std::launch::async, sum<int, int, int>, 1, 10, 100);
  cout << val.get() << endl;

  //   thread ths[1000];
  //   for (thread &th : ths) th = thread(count10000);
  //   for (thread &th : ths) th.join();
  //   cout << n << endl;

  //   thread ths[100];
  //   int nums[100];
  //   for (size_t i = 0; i < 100; i++) {
  //     ths[i] = thread(alt_val<int>, std::ref(nums[i]), i + 1);
  //   }

  //   for (size_t i = 0; i < 100; i++) {
  //     ths[i].join();
  //     cout << nums[i] << endl;
  //   }

  //   thread ths[10];
  //   for (size_t i = 0; i < 10; i++) {
  //     ths[i] = thread(count_num, i, 100000);//创建线程并传递参数
  //   }
  //   for (size_t i = 0; i < 10; i++) {
  //     ths[i].join();
  //   }

  //   thread a([] { cout << "hello," << flush; }), b(doit);
  //   a.join();
  //   b.join();
  return 0;
}
