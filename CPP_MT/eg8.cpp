#include <future>
#include <iostream>
using namespace std;

void count_big_number() {
  for (int i = 0; i <= 10'0000'0000; i++) {
  }
}

int main(int argc, char const *argv[]) {
    std::future<void> fut=async(std::launch::async,
    count_big_number);
    cout<<"请等待"<<flush;
    while (fut.wait_for(std::chrono::seconds(1))!=std::future_status::ready)
    {
        cout<<"."<<flush;
    }
    cout<<endl<<"Finished"<<endl;
    
  /* code */
  return 0;
}
