/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-30 11:29:49
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-30 11:44:26
 */
#include <iostream>
#include <mutex>
#include <thread>
#include<unistd.h>
struct Box {
  explicit Box(int num) : num_things(num) {}
  int num_things;
  std::mutex m;
};

void transfer(Box &from,Box &to,int num){
std::unique_lock<std::mutex> lock1(from.m,std::defer_lock);
std::unique_lock<std::mutex> lock2(to.m,std::defer_lock);

std::lock(lock1,lock2);
from.num_things-=num;
to.num_things+=num;
}//自动解锁
int main(int argc, char const *argv[]) { 
    Box acc1(100);
    Box acc2(50);

    std::thread th1(transfer,std::ref(acc1),std::ref(acc2),10);
    std::thread th2(transfer,std::ref(acc2),std::ref(acc1),5);

    th1.join();
    th2.join();

std::cout<<"acc1.num_things: "<<acc1.num_things<<std::endl;
std::cout<<"acc2.num_things: "<<acc2.num_things<<std::endl;
    
    return 0; }
