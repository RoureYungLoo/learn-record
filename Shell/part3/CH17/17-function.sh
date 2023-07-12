#!/bin/bash

# # 方式一
# function func1(){
#     #commands
#     echo "函数例程1"
# }
# # 方式二
# func2(){
#     #commands
#     echo "函数例程2"
# }

# func1
# func2

# count=1
# while [ $count -le 5 ]
# do
#     func1
#     count=$[ $count+1 ]
# done

# 返回值
# 默认退出码
function func1(){
    echo "trying to display a non-existent file"
    ls -l 
}

echo "testing the function:" 
func1
echo "退出码是：$?"