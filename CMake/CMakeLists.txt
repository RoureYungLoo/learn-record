


cmake_minimum_required(VERSION 3.15)

project(cal)

#[[ 字符串拼接
  set (变量 ${var1} ${var2} str1 str2 ...)
]]
set(var1 /home)
set(var2 /ruoyang)
set(myvar ${var1} ${var2} /test )

message(WARNING "${myvar}")  #输出： /home;/ruoyang;/test

#[[ 字符串追加
  list(APPEND 变量 ${var1} ${var2} /test ... )
]]
list(APPEND myvar2 ${var1} ${var2} test 1 2 3 ) #输出：/home;/ruoyang;test;1;2;3
message(WARNING "${myvar2}")

#[[ 字符串移除
  list(REMOVE_ITEM 变量 value1 value2 ...)
]]
list(REMOVE_ITEM myvar2 1 2 3 test)
message(WARNING "${myvar2}") #输出： /home;/ruoyang