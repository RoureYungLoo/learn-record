
###
 # @Description: Description
 # @Version: 1.0
 # @Author: luruoyang
 # @Date: 2023-03-28 23:43:14
 # @LastEditors: luruoyang
 # @LastEditTime: 2023-03-28 23:45:35
### 

#!/bin/bash

input="user.csv"
while IFS=',' read -r uid u_name
do
    echo "Adding user $uid $u_name"
done < $input
