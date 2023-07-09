#!/usr/bin/lua

---[[
print("Hello world")

function fact(n)
    if not n then
        n=3  --默认值
    end
    if n==0 then
        return 1
    else
        return n*fact(n-1)
    end
end

print("enter a number: ")
-- n=io.read("*n")
print(fact(n))
-- ]]

-- 单行注释

--[[
    多行注释
]]

--[[
    多行开关注释
--]]

--全局变量，未初始化时值为nil
-- print(var)

---[[ lua是动态类型语言，有8种数据类型：
-- nil
-- boolean
-- number
-- string
-- userdata
-- funtion
-- thread
-- table
print(type(nil))
print(type(true))
print(type(10.4*3))
print(type("Hello world"))
print(type(io.stdin))
print(type(print))
print(type(type))
print(type({}))
print(type(type(X)))
-- ]]

---[[ nil
全局变量在第一次被赋值前的默认值就是 而将 nil 赋值给全局变量则相当于将其删除
-- ]]

---[[ boolean
a=false
b="b"
c="c"
print(a and b)
print(b and a)
print(a or b)
print(b or a)
-- and or 短路求值
print(a and b or c) -- a ? b : c
-- ]]

---[[ 独立解释器：/usr/bin/lua
--  lua -e "print('hi')" --> hi
--  lua -e "print('hi')" -i --> hi ,然后进入交互模式
--  lua -llib -e "x=10"    -->加载lib库

print(arg[-2])  --> nil
print(arg[-1])  --> /uar/bin/lua
print(arg[0])   --> ./01-入门.lua
print(arg[1])   --> ni 
print(arg[2])   --> hao
print(arg[3])   --> ma
-- ]]

function factp(n)
    if n and n<0 then 
        return 0
    end
    if n and n==0 then
        return 1
    else
        return n*fact(n-1)
    end
end
print(factp(0))

print(type(nil)==nil)   --> false
print(arg[0])