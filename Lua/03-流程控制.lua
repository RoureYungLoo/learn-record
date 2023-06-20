#!/usr/local/bin/lua

--[[ 流程控制
真：true、非nil、0
假：false、nil

if语句          由一个布尔表达式作为条件判断，其后紧跟其他语句组成。
if...else语句   if语句可以与else语句搭配使用, 在 if 条件表达式为 false 时执行 else 语句代码。
if 嵌套语句	    可以在if 或 else if中使用一个或多个 if 或 else if 语句 。
--]] --  if (0) then
--     print("0 为true")
-- end
--[[ if语句
if condition 
then
    statements
end
 a = 10
if (a < 20) then
    print("a<20")
end
print("a:", a)
]] --[[ if else 语句
-- if condition
-- then
--     statements
-- else
--     statements    
-- end
a = 100
if (a < 20) then
    print("a小于20")
else
    print("a大于20")
end
print("a:", a)
-- ]] --[[ if...elseif...else语句
if cond1
then 
    statements1
elseif cond2 
then 
    statements2
elseif cond3
then 
    statements3
else 
    statements4
end
--]] --[[
a = 100
if (a == 10) then
    print("a value is ", a)
elseif (a == 20) then
    print("a value is ", a)
elseif (a == 30) then
    print("a value is ", a)
else
    print("non a match")
end
print("a value is " .. a)
-- ]] --[[ if 嵌套
if cond1 
then
    statements
    if cond2 
    then
        statements
    end
end
--]] ---[[
a = 100
b = 200
if (a == 100) then
    if (b == 200) then
        print("a 的值为 100 ,b 的值为 200")
    end
end
print("the value of variable a is " .. a)
print("the value of variable b is " .. b)
-- ]]
