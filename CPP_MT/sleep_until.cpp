
#include <chrono>
#include <iostream>
#include <thread>

void func() {
  using std::chrono::system_clock;
  std::time_t tt = system_clock::to_time_t(system_clock::now());

  struct std::tm* ptm = std::localtime(&tt);
  ++ptm->tm_min;
  ptm->tm_sec = 0;
  //暂停执行，一分钟后恢复
  std::this_thread::sleep_until(system_clock::from_time_t(mktime(ptm)));
}

int main(int argc, char const* argv[]) {
  /* code */
  std::thread th1(func);
  th1.join();
  return 0;
}
