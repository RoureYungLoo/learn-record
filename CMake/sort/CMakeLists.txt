
cmake_minimum_required(VERSION 3.15)

project(sort)

# 源文件
aux_source_directory(./ SRC_SORT)

# 头文件
include_directories(${HEADER_PATH})

# libsort.a 链接静态库 libcalc.a
link_directories(${LIB_A_PATH})
link_libraries(${LIB_CALC})

# 静态库生成的路径
set(LIBRARY_OUTPUT_PATH ${LIB_A_PATH})

# 生成静态库
add_library(${LIB_SORT} STATIC ${SRC_SORT})