#!/usr/bin/lua

-- function table_2_string(t)
--     local printed_table_cache = {}
--     local result_string = ""
--     local CRLF = '\n'
--     local function table_2_string_core(t, indent)
--         if (printed_table_cache[tostring(t)]) then
--             result_string = result_string .. indent .. "*" .. tostring(t) .. CRLF
--         else
--             printed_table_cache[tostring(t)] = true
--             if (type(t) == "table") then
--                 for pos, val in pairs(t) do
--                     if (type(val) == "table") then
--                         result_string = result_string .. indent .. "[" .. pos .. "] => " .. tostring(t) .. " {" .. CRLF
--                         table_2_string_core(val, indent .. string.rep(" ", string.len(pos) + 8))
--                         result_string = result_string .. indent .. string.rep(" ", string.len(pos) + 6) .. "}" .. CRLF
--                     elseif (type(val) == "string") then
--                         result_string = result_string .. indent .. "[" .. pos .. '] => "' .. val .. '"' .. CRLF
--                     else
--                         result_string = result_string .. indent .. "[" .. pos .. "] => " .. tostring(val) .. CRLF
--                     end
--                 end
--             else
--                 result_string = result_string .. indent .. tostring(t) .. CRLF
--             end
--         end
--     end
--     if (type(t) == "table") then
--         result_string = result_string .. tostring(t) .. " {" .. CRLF
--         table_2_string_core(t, "  ")
--         result_string = result_string .. "}" .. CRLF
--     else
--         table_2_string_core(t, "  ")
--     end
--     result_string = result_string .. CRLF
--     return result_string
-- end

-- -- print(table_2_string(_G))

-- function get_field(f)
--     local v = _G
--     for word in string.gmatch(f, "[%a_][%w_]*") do
--         v = v[word]
--     end
--     return v
-- end

-- function set_field(f, v)
--     local t = _G
--     for word, d in string.gmatch(f, "([%a_][%w_]*)(%.?)") do
--         if d == '.' then
--             t[word] = t[word] or {}
--             t = t[word]
--         else
--             t[word] = v
--         end
--     end
-- end

-- set_field("t.x.y", 10)
-- -- print(table_2_string(t.x.y))
-- print(get_field("t.x.y"))

-- --全局变量的声明

-- setmetatable(_G, {
--     __index = function(_, n)
--         error("尝试访问未声明的变量" .. n, 2)
--     end,
--     -- __newindex=function (_,n)
--     --     error("尝试写未声明的变量" .. n,2)
--     -- end
--     __newindex = function(t, n, v)
--         local w = debug.getinfo(2, "S").what
--         if w ~= "main" and w ~= "C" then
--             error("尝试写未声明的变量" .. n, 2)
--         end
--         rawset(t, n, v)
--     end
-- })
-- function declare(name, init_value)
--     rawset(_G, name, init_value or false)
-- end

-- local a = 5
-- -- declare(b, 7)
-- print(a)
-- -- print(b)

-- print(table_2_string(debug.getinfo(2, "S")))

-- -- if rawget(_G,var)==nil then
-- --     print('var is nil')
-- -- end

-- local declared_names = {}
-- setmetatable(_G, {
--     __newindex = function(t, n, v)
--         if not declared_names[n] then
--             local w = debug.getinfo(2, "S").what
--             if w ~= "main" and w ~= "C" then
--                 print("尝试写未声明的变量")
--             end
--             declared_names[n] = true
--         end
--         rawset(t, n, v)
--     end,
--     __index = function(_, n)
--         if not declared_names[n] then
--             print("尝试访问未声明的变量")
--         else
--             return nil
--         end
--     end
-- })
-- x = nil
-- -- print(x)
-- -- print(table_2_string(_ENV))

-- local print,sin=print,math.sin
-- -- _ENV=nil
-- print(13)
-- print(sin(13))
-- -- print(math.cos(13))
-- var_a=13
-- local var_a=12
-- print(var_a)
-- print(_ENV.var_a)
-- print(_G.var_a)

-- _ENV = { print = _ENV.print }
-- print(1)
---------------------------------------

--[[a = 1
local newgt = {}
setmetatable(newgt, {
    __index = _G
})
_ENV = newgt --设置新环境
print(a)
a=10
print(a,_G.a)
_G.a=20
print(_G.a)
--]]

--[[
-- _ENV = { _G = _G }
-- local function foo()
--     _G.print(a)
-- end
-- a = 10
-- foo()
-- _ENV = { _G = _G, a = 20 }
-- foo()

-- a = 2
-- do
--     local _ENV = { print = print, a = 14 }
--     print(a)
-- end
-- print(a)

function factory(_ENV)
    return function()
        return a
    end
end

f1 = factory({ a = 6 })
f2 = factory({ a = 7 })
print(f1())
print(f2())
-- ]]

--[[
-- local M={}
-- local _G=_G
-- _ENV=nil

local M = {}

local sqrt = math.sqrt
local io = io

_ENV = nil
-- ]]

---[[
    f=load("b=10;return a")
    env={a=20}
    debug.setupvalue(f,1,env)
    print(f())
    print(env.b)
--]]
