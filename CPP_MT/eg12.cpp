#include <atomic>
#include <iostream>
#include <thread>
using namespace std;

std::atomic<bool> ready = 0;

void sleep(uintmax_t ms) {
  this_thread::sleep_for(std::chrono::milliseconds(ms));
}

void count() {
  while (!ready) {
    this_thread::yield();
  }
  for (size_t i = 0; i < 20'0000'0000; i++) {
  }
  cout << "Thread " << this_thread::get_id() << " finished!" << endl;
  return;
}
int main(int argc, char const *argv[]) {
  thread th[10];
  for (size_t i = 0; i < 10; i++) {
    th[i] = thread(::count);
  }
  sleep(5000);
  ready = true;
  cout << "start!\n";
  for (size_t i = 0; i < 10; i++) {
    th[i].join();
  }

  return 0;
}
