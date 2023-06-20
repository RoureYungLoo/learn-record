#!/usr/local/bin/lua

--[[
算术运算符
关系运算符
逻辑运算符
其他运算符
--]] --[[ 算术运算符
+	加法	A + B 输出结果 30
-	减法	A - B 输出结果 -10
*	乘法	A * B 输出结果 200
/	除法	B / A 输出结果 2
%	取余	B % A 输出结果 0
^	乘幂	A^2 输出结果 100
-	负号	-A 输出结果 -10
//	整除运算符(>=lua5.3)	5//2 输出结果 2
]] --[[
a = 21
b = 12
print("a=" .. a .. ", b=" .. b)

print("a + b=" .. a + b)
print("a - b=" .. a - b)
print("a * b=" .. a * b)
print("a / b=" .. a / b)
print("a % b=" .. a % b)
print("a ^ b=" .. a ^ b)
print("-a=" .. -a)
print("a // b=" .. a // b)
-- ]] --[[ 关系运算符
==  等于
~=  不等于
>   大于
<   小于
>=  大于或等于
<=  小于或等于
--]] --[[
a = 21
b = 10

if (a == b) then
    print("a等于b")
else
    print("a不等于b")
end

if (a >= b) then
    print("a大于等于b")
else
    print("a小于b")
end

if (a <= b) then
    print("a小于等于b")
else
    print("a大于b")
end

if (a ~= b) then
    print("a不等于b")
else
    print("a等于b")
end
-- ]] --[[ 逻辑运算符
and 逻辑与操作符
or  逻辑或操作符
not 逻辑非操作符
-- ]] --[[
-- a = true
a = false
-- b = true
b = false

if (a and b) then
    print("a and b is true")
else
    print("a and b is false")
end

if (a or b) then
    print("a or b is true")
else
    print("a or b is false")
end

if (not (a)) then
    print("not(a) is true")
else
    print("not(a)a is false")
end
-- ]] --[[    其他运算符
#   一元运算符，返回字符串或表的长度。
..  连接两个字符串
--]] --[[
a = "Hello "
b = "World"

print("连接字符串a和b：", a .. b)
print("字符串b的长度：", #b)
print("字符串test的长度：", #"test")
print("字符串的长度：", #'www.baidu.com')
-- ]] --[[    运算符优先级
从高到低：
^
not    - (unary)
*      /       %
+      -
..
<      >      <=     >=     ~=     ==
and
or
除了 ^ 和 .. 外所有的二元运算符都是左连接的。
a+i < b/2+1          <-->       (a+i) < ((b/2)+1)
5+x^2*8              <-->       5+((x^2)*8)
a < y and y <= z     <-->       (a < y) and (y <= z)
-x^2                 <-->       -(x^2)
x^y^z                <-->       x^(y^z)
--]] 
