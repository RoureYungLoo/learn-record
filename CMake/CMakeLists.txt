
# 单行注释 my calculator

#[[
多
行
注
释
]]

#[[ 使用变量 
  SET(VAR VALUE)
]]
# set(SRC_LIST add.cpp div.cpp multi.cpp sub.cpp main.cpp )

cmake_minimum_required(VERSION 3.15)

project(cal)

# 指定CXX标准 ： 方式一
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD 14)
set(CMAKE_CXX_STANDARD 17)
# 方式二：cmake .. -DCMAKE_CXX_STANDARD=11 -DCMAKE_CXX_STANDARD=14 -DCMAKE_CXX_STANDARD=17

# 指定可执行文件输出路径，路径不存在则自动创建
set(EXECUTABLE_OUTPUT_PATH /home/ruoyang/output)

# 指定库文件输出路径，路径不存在则自动创建
# set(LIBRARY_OUTPUT_PATH /home/ruoyang/lib)

# 包含头文件
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include)

# 搜索源文件
# aux_source_directory(${PROJECT_SOURCE_DIR}/src SRC_LIST)

file(GLOB SRC_LIST ${CMAKE_CURRENT_SOURCE_DIR}/*.cpp)

# 输出文件
# add_executable(calculator add.cpp div.cpp multi.cpp sub.cpp main.cpp)

# add_executable(calculator ${SRC_LIST})

# 制作动态库
# add_library(cal SHARED ${SRC_LIST})

# 制作静态库
# add_library(calc STATIC ${SRC_LIST})


# 指定库文件路径
link_directories(${CMAKE_CURRENT_SOURCE_DIR}/liba)

# 链接静态库
link_libraries(calc)

# 输出可执行文件
add_executable(calculator ${SRC_LIST})


#[[ 搜索文件
aux_source_directory(路径 变量)

file(搜索方式 变量 路径和文件后缀)
  GLOB 非递归
  GLOB/RECURSE 递归

PROJECT_SOURCE_DIR：cmake .. 中的..
CMAKE_CURRENT_SOURCE_DIR：当前CMakeLists.txt所在的路径
]] 

#[[ 包含头文件 
  include_directories(头文件路径，而不是具体的头文件)
]]

#[[ 制作链接库文件
  add_library(库名称 STATIC/SHARED 源文件1 源文件2 ... )

libxxx.so linux动态库
libxxx.dll windows动态库
libxxx.lib windows静态库
libxxx.a linux静态库

tips: 静态库文件会被打包到可执行文件中，而动态库则不会被打包到可执行文件中

]]

#[[ 指定库文件输出路径
  set(LIBRARY_OUTPUT_PATH 你的路径)
]]

#[[ 指定库文件路径
  link_directories(库文件路径)
]]

#[[ 链接静态库
  link_libraries(<xxx1> <xxx2> ...)

]]
