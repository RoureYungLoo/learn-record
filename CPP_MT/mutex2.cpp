/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-30 10:33:24
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-30 10:50:21
 */
#include<iostream>
#include<thread>
#include<mutex>
#include<unistd.h>
//如果是不同mutex变量，因为不涉及到同一资源的竞争，
//所以下列代码运行可能会出现交替打印的情况，或者另一个线程可以修改共同的全局变量！！！：
int num=9999;

std::mutex mtx_1;
std::mutex mtx_2;

void func1(int n,char c){

    mtx_1.lock();
    for (size_t i = 0; i < n; i++)
    {
        num=1;
        std::cout<<"第"<<i<<"次,"<<std::this_thread::get_id()<<": "<< num<<std::endl;
        std::this_thread::sleep_for(std::chrono::milliseconds(500));
    }
    std::cout<<std::endl;
    mtx_1.unlock();
}
void func2(int n,char c){
    mtx_2.lock();
    num=2;
    for (size_t i = 0; i < n; i++)
    {
        num=2;
        std::cout<<"第"<<i<<"次,"<<std::this_thread::get_id()<<": "<<num<<std::endl;
        std::this_thread::sleep_for(std::chrono::milliseconds(700));
    }
    mtx_2.unlock();
    
}
int main(int argc, char const *argv[])
{
    std::thread th1(func1,10,'*');
    std::thread th2(func2,20,'$');
    th1.detach();
    th2.detach();
    sleep(100);
    return 0;
}
