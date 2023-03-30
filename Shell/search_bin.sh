#!/bin/bash
###
# @Description: Description
# @Version: 1.0
# @Author: luruoyang
# @Date: 2023-03-28 23:26:44
 # @LastEditors: luruoyang
 # @LastEditTime: 2023-03-29 00:26:02
###

IFS_OLD=$IFS
IFS=:
Bin_Lists=~/bin.list.$(date +%y%m%d).txt

echo "" >"$Bin_Lists"
for dir in $PATH; do
    for file in $dir/*; do
        if [ -x "$file" ]; then
            echo "$file" >>"$Bin_Lists"
        fi
    done
done
IFS=$IFS_OLD
