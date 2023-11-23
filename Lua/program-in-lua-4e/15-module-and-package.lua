#!/usr/local/bin/lua

local util=require"util"
local table_2_string=util.table_2_string

-- function ttable_2_string(t)
-- 	local printed_table_cache = {}
-- 	local result_string = ""
-- 	local CRLF = '\n'
-- 	local function table_2_string_core(t, indent) 
-- 		if (printed_table_cache[tostring(t)]) then
--             -- result_string = result_string..indent.."*"..tostring(t)..CRLF
--             result_string = result_string.."*"..tostring(t)..CRLF
--         else
--             printed_table_cache[tostring(t)]=true
--             if (type(t)=="table") then
--                 for pos,val in pairs(t) do
--                     if (type(val)=="table") then
--                         -- result_string = result_string..indent.."["..pos.."] = "..tostring(t).." {"..CRLF
--                         result_string = result_string..indent.."["..pos.."] = " .. " {"..CRLF
--                         table_2_string_core(val,indent..string.rep(" ",string.len(pos)+8))
--                         result_string = result_string..indent..string.rep(" ",string.len(pos)+6).."}"..CRLF
--                     elseif (type(val)=="string") then
--                         result_string = result_string..indent.."["..pos..'] = "'..val..'"'..CRLF
--                     else
--                         result_string = result_string..indent.."["..pos.."] = "..tostring(val)..CRLF
--                     end
--                 end
--             else
--                 result_string = result_string..indent..tostring(t)..CRLF
--             end
--         end
--     end
--     if (type(t)=="table") then
--         -- result_string = result_string..tostring(t).." {"..CRLF
--         result_string = " {"..CRLF
--         table_2_string_core(t,"  ")
--         result_string = result_string.."}"..CRLF
--     else
--         table_2_string_core(t,"  ")
--     end
--     result_string = result_string..CRLF
--     return result_string
-- end

local m=require"math"
local math=require"math"


-- local sin1=require(math.sin)
-- local sin2=require('math.sin')
-- local sin3=require'math.sin'

print(m.sin(3.14))
-- print(sin1(3.14))
-- print(sin2(3.14))
-- print(sin3(3.14))
-- print(table_2_string(package.loaded))

local path=string.gsub( package.path,';','\n')
local cpath=string.gsub( package.cpath,';','\n')
print(path)
print()
print(cpath)
print()
print(table_2_string(package.searchers))
print(table_2_string(package.preload))
print(table_2_string({
    a=1,
    b=2
}))

local calc=require"calc"
print(calc.jia(1,2))
print(calc.cheng(2,3))
print(calc.VER)
