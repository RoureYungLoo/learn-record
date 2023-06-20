#!/usr/local/bin/lua

--[[ 函数定义
 local function func_name(arg1,arg2,...,argn)
    statements
    return ret
 end
 不加local为全局函数，加local为局部函数
--]] --[[ 
function max(num1, num2)
    if (num1 > num2) then
        ret = num1;
    else
        ret = num2;
    end
    return ret
end

print("10 和 4的最大值为" .. max(10, 4))
print("5 和 6的最大值为" .. max(5, 6))
-- ]] -- 可以将函数作为参数传递给函数
--[[
myprint = function(param)
    print("## " .. param .. " ##")
end

function add(num1, num2, func)
    ret = num1 + num2
    func(ret)
end
myprint(10)
add(2, 5, myprint)
-- ]] --[[ 多返回值 用逗号隔开
s, e = string.find("helloworld", "owo")
print(s, e)
function maximum(a)
    local min_index = 1
    local m = a[min_index]
    for i, val in ipairs(a) do
        if val > m then
            min_index = i
            m = val
        end
    end
    return m, min_index
end

print(maximum({8, 10, 23, 12, 5}))
-- ]] --[[
-- 可变参数
function add(...)
    local sum = 0
    for i, v in ipairs {...} do
        sum = sum + v
        -- print(v)
    end
    return sum
end
print(add(3, 4, 5, 6, 7))

function average(...)
    ret = 0
    local arg = {...}
    for i, v in ipairs(arg) do
        ret = ret + v
    end
    print("总共传入了" .. #arg .. "个参数")
    return ret / #arg
end

print("平均值：", average(10, 5, 3, 4, 5, 6))
-- ]] --[[ 固定参数+可变参数
function fwrite(fmt, ...)
    return io.write(string.format(fmt, ...))
end

fwrite("hello\n")

fwrite("%d %d\n", 1, 2)
--]] --[[ select函数
-- select('#', …) 返回可变参数的长度。
-- select(n, …) 用于返回从index为n开始到结束位置的所有参数列表。
function f(...)
    a = select(3, ...) -- >从第三个位置开始，变量 a 对应右边变量列表的第一个参数
    print(a)

    print(select(3, ...))
    -- print("可变参数个数：" .. select('#', ...))
end
f(0, 1, 2, 3, 4, 5)
-- ]] ---[[
do
    function foo(...)
        for i = 1, select('#', ...) do -- >获取参数总数
            local arg = select(i, ...); -- >读取参数，arg 对应的是右边变量列表的第一个参数
            print("arg", arg);
        end
    end
    foo(21, 12, 13, 14)
end
-- ]]
