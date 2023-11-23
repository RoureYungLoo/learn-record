#!/usr/local/bin/lua

-- local input = io.read()
-- print(input)

function values(t)
    local i = 0 -- 函数values内的局部变量
    return function() -- 返回一个函数
        i = i + 1
        return t[i]
    end
end

t={10,20,30}
iter=values(t)
while true do
    local element=iter()
    if element ==nil  then
        break
    end
    print(element)
end

local var_list
local exp_lsit
arr={1,3,5,7}
-- for k in pairs(arr) do
--     print(k)
-- end
print(pairs(arr)) --> function: 0x419cb0      table: 0x875dd0 nil
-- for k in 1,3,5 do
    -- print(k)
-- end
local util=require"util"
local f,t=pairs(arr)
print(util.table_2_string(t))
for index, value in ipairs({'one','two','three'}) do
    print(index,' ',value)
end

for k,v in next,arr do
    print(v)
end

lines={
    luaH_set=10,
    luaH_get=24,
    luaH_present=48
}

for key, value in pairs(lines) do
    print(key)
end

a={}
for n in pairs(lines) do
    a[#a+1] = n
end
table.sort(a)
for _, n in ipairs(a) do
    print(n)
end

-- f: 排序方式
function pairs_by_key(t,f)
    local a={}
    for n in pairs(t) do
        a[#a+1] = n
    end    
    table.sort(a,f)
    local i=0
    return function ()
        i=i+1
        return a[i],t[a[i]]
    end
end

for k,v in pairs_by_key(lines) do
    print(k,v)
end
-- 真正迭代器
function all_words(f)
    for line in io.lines() do
        for word in string.gmatch(line,"%w+")do
            f(word)
        end
    end
end
-- all_words(print)
local count=0
all_words(function (w)
    if w=="hello" then
        count=count+1
    end
end)

print(count)