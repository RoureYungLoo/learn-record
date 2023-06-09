
#include <future>
#include <iostream>
#include <thread>
using namespace std;

template <class... Args>
decltype(auto) sum(Args&&... args) {
  return (0 + ... + args);
}

template <class... Args>
void sum_thread(std::promise<long long>& val, Args&&... args) {
  val.set_value(sum(args...));
}

int main(int argc, char const* argv[]) {
  std::promise<long long> sum_val;
  thread get_sum(sum_thread<int, int, int>, std::ref(sum_val), 1, 10, 100);
  cout << sum_val.get_future().get() << endl;
  get_sum.join();
  /* code */
  return 0;
}
