
cmake_minimum_required(VERSION 3.15)

project(cal)

# 源文件
aux_source_directory(./ SRC_CAL)

# 头文件
include_directories(${HEADER_PATH})

# 动态库生成的路径
set(LIBRARY_OUTPUT_PATH ${LIB_SO_PATH})

# 生成动态库
add_library(${LIB_CALC} SHARED ${SRC_CAL})