/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-03-27 22:55:19
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-03-27 23:05:04
 */
#include<stdio.h>
 int num=5; //加上static后不能被其他文件引用
 void func(){ //加上static后不能被其他文件引用
    printf("%d in moudule.c",num);
}