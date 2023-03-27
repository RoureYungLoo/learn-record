/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-27 22:55:07
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-27 23:02:36
 */
#include<stdio.h>
int main(){
    extern int num;// 引用另一个文件的变量
    printf("%d\n",num);
    extern void func();//引用另一个文件的函数
    func();
    return 0;
}
//gcc main.c mudule.c -o main