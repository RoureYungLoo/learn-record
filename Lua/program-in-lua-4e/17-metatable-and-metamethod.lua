#!/usr/local/bin/lua

local util = require "util"
local table_2_string = util.table_2_string
-- 数据类型 数据类型的操作
local tb1 = {}
local tb2 = {}
print(tb1)
print(tb2)
print(setmetatable(tb1, tb2))
print(getmetatable(tb1))

-- print(table_2_string(getmetatable("test")))

local set = require "Set"
local s1 = set.new({1, 3, 5, 7})
local s2 = set.new({5, 7, 9, 11})
print(set.tostring(s1))
print(set.tostring(s2))
-- print(set.tostring(set.union(s1,s2)))
-- print(set.tostring(set.intersection(s1,s2)))
print(set.tostring(s1 + s2))
print(set.tostring(s1 * s2))

s1 = set.new({2, 4})
s2 = set.new({4, 10, 2})
print(s1 <= s2)
print(s1 < s2)
print(s1 >= s1)
print(s1 > s1)
print(s1 == s2 * s1)
print(s2)
-- print(table_2_string(getmetatable(s2)))

local prototype = {
    x = 0,
    y = 0,
    width = 100,
    height = 100
}

local mt = {
    -- __index = function(_, k) -- table key
    --     return prototype[k]
    -- end
    __index = prototype,
    __newindex = function(t, key, val)
        print("__newindex: ", t, " key: ", key, " value: ", val)
    end
}
-- __newindex字段有何作用呢？其实它可以起到一个很好的限制筛选作用。可以防止表被赋值，加入些杂七杂八
-- 的元素。有时候一表多用可能会导致些lua中的垃圾回收相关的问题
function new(o)
    setmetatable(o, mt)
    return o
end

w = new {x = 10, y = 20}
print(w.width)
print(w.height)
print(rawget(w, "width")) -- 原始访问
w.a = 2
print(w.a)
-- metatable
local metatable = {
    __index = "",
    __newindex = "",
    __gc = "",
    __mode = "",
    __len = "",
    __eq = "",
    __add = "",
    __sub = "",
    __mul = "",
    __mod = "",
    __pow = "",
    __div = "",
    __idiv = "",
    __band = "",
    __bor = "",
    __bxor = "",
    __shl = "",
    __shr = "",
    __unm = "",
    __bnot = "",
    __lt = "",
    __le = "",
    __concat = "",
    __call = ""
}

-- 具有默认值的表
function set_default(tab, dft_val)
    local mtt = {
        __index = function(...)
            -- local args={...}
            -- print(table_2_string(args))
            return dft_val
        end
    }
    setmetatable(tab, mtt)
end

-- 共用元表的默认值的表的元表
local mtt2 = {
    __index = function(t)
        return t.___
    end
}
function set_default2(t, d)
    t.___ = d
    setmetatable(t, mtt2)
end
local tb = {}
set_default2(tb, 99)
print(tb.rt) --> 99

tab = {x = 10, y = 20}
print(tab.x, tab.z)
set_default(tab, 999)
print(tab.e, " ", tab.k) --访问不存在的key，返回默认值

local key = {} --唯一key
local mt3 = {
    __index = function(t)
        return t[k]
    end
}
function set_default3(t, d)
    t[key] = d
    setmetatable(t, mt)
end

-- 对偶表示 （需要弱引用表）
local dual_tab = {
    [{}] = 99,
    [{}] = 999,
    [{}] = 9999
}

--记忆元表 （需要弱引用表）

--跟踪表的访问
function track_table(t)
    local proxy = {}

    --代理表的元表
    local mt = {
        __index = function(_, k)
            print("*access to element" .. tostring(k))
            return t[k] -- 访问原来的表
        end,
        __newindex = function(_, k, v)
            print("*update of element " .. tostring(k) .. " to " .. tostring(v))
            t[k] = v
        end,
        __pairs = function()
            return function(_, k) --迭代函数
                local nextkey, nextvalue = next(t, k)
                if nextkey ~= nil then
                    print("*traversing element " .. tostring(nextkey))
                end
                return nextkey, nextvalue
            end
        end,
        __len = function()
            return #t
        end
    }
    setmetatable(proxy, mt)
    return proxy
end
t = {}
t = track_table(t)
t[2] = "hello"
print(t[2])
t = track_table({10, 20, 30})
print(#t)
for k, v in pairs(t) do
    print(k, v)
end
--只读表

function readonly_table(t)
    local proxy = {}
    local mt = {
        __index = t,
        __newindex = function(t, k, v)
            error("attempt to update a read-only table", 2)
        end
    }
    setmetatable(proxy, mt)
    return proxy
end
local days =
    readonly_table {
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday"
}
print(days[1])
days[2] = "Noday"
