#!/usr/local/bin/lua

-- Lua 的模块是由变量、函数等已知元素组成的 table
-- 加载模块 require("my_module")
--  执行 require 后会返回一个由模块常量或函数组成的 table，
--  并且还会定义一个包含该 table 的全局变量。
require("my_module")
print(my_module.const_var1)
my_module.func3()

local mm=require("my_module")
print(mm.const_var1)
mm.func1()

-- 加载机制 自定义的模块，模块文件不是放在哪个文件目录都行
-- 函数 require 有它自己的文件路径加载策略 它会尝试从 Lua 文件或 C 程序库中加载模块。
-- 环境变量 LUA_PATH
-- 环境变量 LUA_CPATH
-- 调用 package.loadfile 来加载模块

-- 动态链接C包, loadlib(库的绝对路径,初始化函数),返回值为初始化函数(并未调用)
