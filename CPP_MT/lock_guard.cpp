/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-30 10:53:27
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-30 11:26:54
 */
#include<iostream>
#include<mutex>
#include<thread>
#include<unistd.h>
int global=0;
std::mutex mtx_global;

void increment(){
    const std::lock_guard<std::mutex> lock(mtx_global);//lock_guard
    ++global;
    std::cout<<std::this_thread::get_id()<<": "<<global<<std::endl;
}//自动解锁
int main(int argc, char const *argv[])
{
    std::thread th1(increment);
    std::thread th2(increment);
    th1.detach();
    th2.detach();
    sleep(100);
    return 0;
}
