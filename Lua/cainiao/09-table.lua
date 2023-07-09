#!/usr/local/bin/lua

--[[
Lua table 使用关联型数组，可以用任意类型的值来作数组的索引，但这个值不能是 nil。
Lua table 是不固定大小的，可以根据自己需要进行扩容。
Lua 通过table来解决模块（module）、包（package）和对象（Object）的。
    例如string.format表示使用"format"来索引table string。
]] --[[
tbl = {}
tbl[1] = "lua"
tbl["two"] = "nginx"

function printt(tbl)
    for k, v in pairs(tbl) do
        print(k .. ": " .. v)
    end
end
cpy = tbl
printt(tbl)
printt(cpy)
cpy[1] = "LUA"
printt(tbl)
printt(cpy)
tbl = nil
-- printt(tbl)
printt(cpy)
-- ]] --[[ table常用操作
table.concat()
table.insert() 默认插入尾部
table.maxn()
table.remove() 默认从最后一个开始删除
table.sort
]] --[[ 连接
fruits = {"banana", "orange", "apple"}
print(table.concat(fruits))
print(table.concat(fruits, "-"))
print(table.concat(fruits, "-", 2, 3))
-- ]] --[[
-- 插入和删除
fruits = {"banana", "orange", "apple"}
table.insert(fruits, "mango")
table.insert(fruits, 2, "grapes")
table.remove(fruits)
print(table.concat(fruits, " "))
-- ]] --[[
-- 排序
fruits = {"banana", "orange", "apple", "mango"}
print(table.concat(fruits, " "))
table.sort(fruits)
print(table.concat(fruits, " "))
-- ]] --[[
-- 最大值  Lua5.2+已删除
function maxn(t)
    local mn = nil;
    for k, v in pairs(t) do
        if (mn == nil) then
            mn = v
        end
        if (mn < v) then
            mn = v
        end
    end
    return mn
end
tbl = {
    [1] = 2,
    [2] = 6,
    [3] = 34,
    [26] = 5
}
print("最大值：", maxn(tbl));
print("长度，", #tbl)
-- 当我们获取 table 的长度的时候无论是使用 # 还是 table.getn 其都会在索引中断
-- 的地方停止计数，而导致无法正确取得 table 的长度。
-- ]] 
