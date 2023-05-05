#!/bin/bash
###
 # @Description: Description
 # @Version: 1.0
 # @Author: luruoyang
 # @Date: 2023-04-10 11:26:38
 # @LastEditors: luruoyang
 # @LastEditTime: 2023-04-12 23:04:59
### 

read -p "输入名字："
echo "你好 $REPLY"

# read -p "输入你的名字：" first last
# echo "你的输入： $last $first"

# read -p "请输入年龄：" age
# days=$[ $age*365 ]
# echo "你活了${days}天"

# echo -n "输入你的名字："
# read name
# echo "hello $name"

# echo
# while getopts :ab:cd opt
# do
#     case "$opt" in 
#     a) echo "发现选项-a";;
#     b) echo "发现选项-b,选项值为$OPTARG";;
#     c) echo "发现选项-c";;
#     d) echo "发现选项-d";;
#     *) echo "未知选项: $opt";;
#     esac
# done
# shift $[ $OPTIND - 1 ]
# echo
# count=1
# for param in "$@"
# do
#     echo "Param $count: $param"
#     count=$[ $count + 1 ]
# done



# set -- $(getopt -q ab:cd "$@")
# echo
# while [ -n "$1" ]
# do
#     case "$1" in
#     -a) echo "发现选项-a";;
#     -b) param="$2"
#         echo "发现选项-b，其选项值为 $param"
#         shift;;
#     -c) echo "发现选项-c";;
#     --) shift
#         break;;
#     *) echo "$1 不是选项";;
#     esac
#     shift
# done
# count=1
# for param in "$@"
# do
#     echo "Param #$count: $param"
#     count=$((count+1))
# done


# while [ -n "$1" ] 
# do
#     case "$1" in
#         -a) echo "发现选项-a" ;; 
#         -b) param="$2"
#             echo "发现选项-b，其选项值为 $param" 
#             shift;;
#         -c) echo "发现选项-c" ;;
#         --) shift
#             break ;;
#         *) echo "$1 不是选项" ;;
#     esac
#     shift
# done
# count=1
# for param in "$@"
# do 
#     echo "参数#$count: $param"
#     count=$((count +1 ))
# done



# while [ -n "$1" ]
# do
#     case "$1" in 
#     -a) echo "发现-a选项" ;;
#     -b) echo "发现-b选项" ;;
#     -c) echo "发现-c选项" ;;
#     --) shift
#         break ;;
#     *) echo "$1 不是一个选项" ;;
#     esac
#     shift
# done

# count=1
# for param in "$@"
# do
#     echo "Param #$count: $param"
#     count=$(( count +1))
# done



# echo script_name:"$(basename $0)"
# echo param nums:$#

# echo "\$*: $* "
# echo "\$@: $@ "
# count=1
# for param in "$*"
# do 
#     echo "\$* Param #$count = $param"
# done


# count=1
# for param in "$@"
# do 
#     echo "\$@ Param #$count = $param"
# done

# while [ -n "$1" ]
# do
#     echo "Param 1 = $1"

#     shift
# done
# echo "script_name: $(basename "$0")"
