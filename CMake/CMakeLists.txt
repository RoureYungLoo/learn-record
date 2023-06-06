


cmake_minimum_required(VERSION 3.15)

project(cal)

# 宏定义
add_definitions(-DDEBUG)

# 包含头文件
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include)

# 搜索源文件
file(GLOB SRC_LIST ${CMAKE_CURRENT_SOURCE_DIR}/*.cpp)

# 指定库文件路径
link_directories(${CMAKE_CURRENT_SOURCE_DIR}/liba)

# 链接静态库
link_libraries(calc)

# 输出可执行文件
add_executable(calculator ${SRC_LIST})

#[[ 字符串拼接
  set (变量 ${var1} ${var2} str1 str2 ...)
]]
# set(var1 /home)
# set(var2 /ruoyang)
# set(myvar ${var1} ${var2} /test )

# message(WARNING "${myvar}")  #输出： /home;/ruoyang;/test

#[[ 字符串追加
  list(APPEND 变量 ${var1} ${var2} /test ... )
]]
# list(APPEND myvar2 ${var1} ${var2} test 1 2 3 ) #输出：/home;/ruoyang;test;1;2;3
# message(WARNING "${myvar2}")

#[[ 字符串移除
  list(REMOVE_ITEM 变量 value1 value2 ...)
]]
# list(REMOVE_ITEM myvar2 1 2 3 test)
# message(WARNING "${myvar2}") #输出： /home;/ruoyang

#[[ list 其他操作
  list(LENGTH 变量 长度变量) 获取变量的长度，存储在长度变量中
  list(GET 变量 index1 index2 indexxx ... 输出变量)
  list(JOIN 变量 连接符 输出变量)
  list(FIND 变量 查找关键字 输出变量)
  list(APPEND )
  list(INSERT 变量 index str1 str2 ...)
  list(PREPEND 变量 elem1 elem2 ...) 插入到index为0的位置
  list(POP_BACK 变量 [输出变量])
  list(POP_FRONT 变量 [输出变量])
  list(REMOVE_ITEM 变量 str1 str2 ...)
  list(REMOVE_AT 变量 index1 index2 ...)
  list(REMOVE_DUPLICATES 变量)
  list(REVERSE 变量)
  list(SORT 变量 排序方法 大小写敏感 升序降序)
  list(SORT 变量 STRING/FILE_BASENAME/NATURAL SENSITIVE/INSENSITIVE ASCENDING/DESCENDING)
]]

#[[ 宏定义
  add_definitions(-DXXX)
]]