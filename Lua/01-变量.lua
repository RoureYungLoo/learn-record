#!/usr/local/bin/lua

--[[ 变量
    默认值为nil
    1.全局变量: 非local变量都是全局变量
    2.局部变量: 用local显式声明的变量，作用域位从声明位置开始到所在语句块结束
    3.表中的域
 a = 5
local b = 5

function joke()
    c = 5
    local d = 6
end

joke()
print(c, d)

do
    local a = 6
    b = 6
    print(a, b)
end
print(a, b)
--]] --[[
    赋值语句
 a = "hello" .. " world"
t = {}
t.n = 0
t.n = t.n + 10
print(a)
print(t.n)

m, n = 15 * 2, 2 * t.n
print(m, n)
m, n = n, m
print(m, n)

a, b, c = 0, 1
print(a, b, c)

a, b = a + 1, b + 1, b + 2
print(a, b)

-- x, y, z = 0
x, y, z = 0, 0, 0
print(x, y, z)

function getval()
    return 1, 2
end

a, b = getval()
print(a, b)
--]] --[[ 索引
 方括号和点操作符
 当索引为字符串类型时,site["key"]可以简写为site.key
]] site = {}
site["key"] = "this is a value"
print(site["key"])
print(site.key)
