
cmake_minimum_required(VERSION 3.15)

project(test2)

# 源文件
aux_source_directory(./ SRC_TEST2)

# 头文件
include_directories(${HEADER_PATH})

# 从哪里找静态库文件
link_directories(${LIB_A_PATH})

# 链接哪个静态库文件
link_libraries(${LIB_SORT})

# 可执行文件放到哪里
set(EXECUTABLE_OUTPUT_PATH ${EXEC_PATH})

# 生成可执行文件
add_executable(${TEST2} ${SRC_TEST2})