#!/usr/local/bin/lua

--[[ 数组 
相同数据类型的元素按一定顺序排列的集合，可以是一维数组和多维数组。数组的大小不是固定的。
下标默认从1开始，下标可为负整数
-- ]] --[[ 一维数组
--]] --[[
arr = {"hello", "world"}
for i = 1, 2 do
    print(arr[i])
end

arr2 = {}
for i = -3, 3 do
    arr2[i] = 2 * i
end
for i = -3, 3 do
    print(arr2[i])
end

-- ]] -- 多维数组---[[ 
arr = {}
for i = 1, 3 do
    arr[i] = {}
    for j = 1, 3 do
        arr[i][j] = i * j
    end
end

for i = 1, 3 do
    for j = 1, 3 do
        print(arr[i][j])
    end
end

arr2 = {}
rows = 3 -- 行
col = 3 -- 列
for r = 1, rows do
    for c = 1, col do
        arr2[r * rows + c] = r * c
    end
end

for r = 1, rows do
    for c = 1, col do
        print(arr2[r * rows + c])
    end
end

-- ]]
