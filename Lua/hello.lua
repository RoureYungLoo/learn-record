#!/usr/local/bin/lua

---[[ table

local tbl1={}
local tbl2={"apple","pear","orange","grape"}
for k,v in pairs(tbl2) do
print("key",k)
--print(k .. ":" .. v)
end

taba={}
taba["key1"]="val1"
taba["key2"]="val2"

key=10
taba[key]=22
taba[key]=taba[key]+11
for k,v in pairs(taba) do
	print(k .. ":" .. v)
end



--]]

--[[ string
string1 = "this is string1"
string2 = 'this is string2'
html=[[
	<html>
<head></head>
<body>
    <a href="https://www.baidu.com/">百度</a>
</body>
</html>

print(string1)
print(string2)
print(html)
print(2+6)
print("2"+6)
print(2+"6")
print("2+6")

print("a"..'b')
print(157 .. 345)
print(#string1)
print(#html)
--]]

--[[ number 
print(type(2))
print(type(2.22))
print(type(0.2))
print(type(2e+1))
print(type(0.2e-1))
print(type(7.2343423e-06))
--]]



--[[ boolean
print(type(true))
print(type(false))
print(type(nil))

if false or nil then
	print("至少有一个是true")
else
	print("false 和nil都是 false")
end

if 0 then
	print("数字0是true")
else
	print("数字0是false")
end
--]]
--[[
print(type(X)==nil)
print(type(X)=="nil")
print(type(type(X))=="string") --true

--]]
--[[
tab1={key1="val1",key2="val2","val3"}
for k,v in pairs(tab1) do
	print(k .. "-" ..v)
end

tab1.key1=nil
for k,v in pairs(tab1) do
	print(k .. "-" ..v)
end
--]]

--[[
print("hello")
print("world")
--]]
-- 单行
-- 注释

--[[
多行
注释
--]]

--[[
print(type("hello"))
print(type(10.4*3))
print(type(print))
print(type(type))
print(type(true))
print(type(nil))
print(type(type(X)))

print(type(a))
--]]
