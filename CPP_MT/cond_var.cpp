/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-30 15:36:14
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-30 16:05:23
 */
#include<iostream>
#include<thread>
#include<condition_variable>
#include<mutex>


std::mutex mtx;
std::condition_variable cv;

int cargo=0;
bool shipment_available(){return cargo!=0;}

void consume(int n){
    for (size_t i = 0; i < n; i++)
    {
        std::unique_lock<std::mutex> lck(mtx);
        cv.wait(lck,shipment_available);
        std::cout<<cargo<<"\n";
        cargo=0;
    }
    
}
int main(int argc, char const *argv[])
{
    std::thread consumer_thread(consume,10);

    for (size_t i = 0; i < 10; i++)
    {
        while (shipment_available())
        {
            /* code */
        }
        
    }
    
    return 0;
}

