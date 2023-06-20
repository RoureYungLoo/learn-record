#!/usr/local/bin/lua

--[[
    每个迭代器对象代表容器中的确定的地址。
    Lua 中迭代器是一种支持指针类型的结构，它可以遍历集合的每一个元素。
    在Lua中常常使用函数来描述迭代器，每次调用该函数就返回集合的下一个元素。Lua 的迭代器包含以下两种类型：
--]] --[[
    -- 泛型for迭代器
t = {1, 23, 5, 7, 9}
for k, v in pairs(t) do
    print(k, v)
end
-- ]] --[[无状态的迭代器
-- 不保留任何状态的迭代器
-- 每一次迭代，迭代函数都是用两个变量（状态常量和控制变量）的值作为参数被调用，
-- 一个无状态的迭代器只利用这两个值可以获取下一个元素。
function square(iterMaxCount, curNum)
    if (curNum < iterMaxCount) then
        curNum = curNum + 1
        return curNum, curNum * curNum
    end
end

for i, n in square, 3, 0 do
    print(i, n)
end
-- ]] ---[[
-- 多状态的迭代器: 保存多个状态信息而不是简单的状态常量和控制变量
-- 1.使用闭包 2.使用table
array = {"Google", "Baidu"}

function elemIter(collection)
    local index = 0;
    local count = #collection

    return function() -- 闭包函数
        index = index + 1
        if index <= count then
            return collection[index] -- 返回迭代器的当前元素
        end
    end
end

for elem in elemIter(array) do
    print(elem)
end
-- ]]
