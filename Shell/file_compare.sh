#!/bin/bash
###
 # @Description: Description
 # @Version: 1.0
 # @Author: luruoyang
 # @Date: 2023-03-28 08:27:33
 # @LastEditors: luruoyang
 # @LastEditTime: 2023-03-28 08:47:34
### 
# -d 目录是否存在
# -e 文件（）是否存在
# -f 文件（）是否存在
# -r
# -s
# -w
# -x
# -O
# -G
# -nt
# -ot

jump_dir=/home/ruoyang
file=code.desktop
if [ -e $jump_dir ]
then
    echo "The dir $jump_dir exists."
    if [ -e $jump_dir ]
    then
        echo "the file $jump_dir  exists."
        if [ -e $file ]
        then
            echo "the file $file exists."
        else
            echo "the file $file does not exist."
            ls  -al $jump_dir/$file
        fi
    else
        echo "The file $jump_dir does not exists"
    fi
else
    echo "The dir $jump_dir does not exists."
fi
