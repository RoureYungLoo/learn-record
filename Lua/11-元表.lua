#!/usr/local/bin/lua
--  Lua 提供了元表(Metatable)，允许我们改变 table 的行为(例如两个table相加)，每个
-- 行为关联了对应的元方法。

-- mytable={}
-- mymetatable={}
-- setmetatable(mytable,mymetatable)
-- getmetatable(mytable)

-- mytable= setmetatable({key1="value1"},{
--     __index=function(mytable,key)
--         if (key=="key2") then
--             return "metatablevalue"
--         end
--             return nil
--     end
-- })
-- print(mytable.key1,mytable.key2,mytable.key3)

-- mymetatable={}
-- mytable=setmetatable({key1="value1"},{__newindex=mymetatable})

-- print(mytable.key1)

-- mytable.newkey="new value2"
-- print(mytable.newkey,mymetatable.newkey)

-- mytable.key1="new value1"
-- print(mytable.key1,mymetatable.key1)

-- tbl={key1="val1"}
-- metatbl={
--     __newindex=function(t,k,v)
--         rawset(t,k,"\"".. v .."\"")
--     end
-- }
-- setmetatable(tbl,metatbl)

-- tbl.key1="new val1"
-- tbl.key2=4

-- print(tbl.key1,tbl.key2)

--为表添加操作符
-- function table_maxn(t)
--     local mn=0
--     for k,v in pairs(t) do
--         if (mn<k) then
--             mn=k
--         end
--     end
--     return mn
-- end

-- tb1={1,2,3}
-- tb2={4,5,6}

-- metatb={
--     __add=function(t1,t2)
--         for i=1,table_maxn(t2) do
--             table.insert(t1,table_maxn(t1)+1,t2[i])
--         end
--         return t1 
--     end
-- }
-- setmetatable(tb1,metatb)
-- newtb=tb1+tb2
-- for k,v in pairs(newtb) do
--     print(k,v)
-- end

-- __call 元方法
-- metatbl={
--     __call=function(t1,t2)
--         local sum=0
--         for i=1,table_maxn(t1) do 
--             sum=sum+t1[i]
--         end
--         for i=1,table_maxn(t2) do
--             sum=sum+t2[i]
--         end
--         return sum
--     end
-- }
-- setmetatable(tb1,metatbl)
-- print(tb1(tb2))

--  __tostring 元方法
tbl={10,20,30}
metatbl={
    __tostring=function(t)
        local sum=0
        for k,v in pairs(t) do
            sum=sum+v
        end
        return "表中所有元素的和为：" .. sum
    end
}

setmetatable(tbl,metatbl)

print(tbl)