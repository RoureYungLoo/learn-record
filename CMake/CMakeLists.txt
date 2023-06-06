
cmake_minimum_required(VERSION 3.15)

project(my_project)

# 生成库的路径
set(LIB_A_PATH ${CMAKE_CURRENT_SOURCE_DIR}/lib/liba)
set(LIB_SO_PATH ${CMAKE_CURRENT_SOURCE_DIR}/lib/libso)

# 生成可执行文件路径
set(EXEC_PATH ${CMAKE_CURRENT_SOURCE_DIR}/bin)

# 头文件路径
set(HEADER_PATH ${CMAKE_CURRENT_SOURCE_DIR}/include)

# 库文件名称
set(LIB_CALC calc)
set(LIB_SORT sort)

# 可执行程序名
set(TEST1 test1)
set(TEST2 test2)

# 添加子目录
add_subdirectory(calc)
add_subdirectory(sort)
add_subdirectory(test1)
add_subdirectory(test2)