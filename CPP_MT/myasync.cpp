
#include <unistd.h>

#include <future>
#include <iostream>
#include <thread>
using namespace std;
int main(int argc, char const* argv[]) {
  std::async(
      std::launch::async,
      [](const char* msg) {
        sleep(3);
        cout << msg << flush;
      },
      "Hello,");
  cout << "world" << endl;
  return 0;
}
