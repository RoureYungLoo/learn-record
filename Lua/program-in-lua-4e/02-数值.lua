#!/usr/bin/lua
-- integer  64bit
-- float    双精度

-- 精简模式：
-- integer  32bit
-- float    单精度

---[[ 数值常量
print(type(12345))
print(type(123.45))
print(math.type(12345))
print(math.type(123.45))
print(0xa.bp3)
print(-0x1p1)
print(0Xfff)
print(string.format("%a",43.5)) --> 0x1.5cp+5
print(string.format("%a",.235)) --> 0x1.e147ae147ae14p-3
-- ]]

---[[ 算术运算
 +、-、*、/、-、//、%、^
 // floor 除法，向负无穷取整
 a % b : a - ( ( a // b )*b )
 需要注意操作数分整数和浮点数，以及结果是不是浮点数
-- ]]

---[[ 关系运算符 < <= == ~= > >=
print(5.0==5)
-- ]]

---[[ 数学库
-- 三角函数、指数函数、取整函数、最大和最小函数、伪随机数函数
-- pi
-- huge

-- 随机数
math.randomseed(os.time())
print(math.random())    --> [0,1)之间的随机数
print(math.random(10))  --> [1,10]之间的随机数
print(math.random(20,50))   -->[20,50]之间的随机数
-- ]]

---[[ 取整函数 floor ceil modf
-- floor 向下取整
print(math.floor(23.45))
-- ceil 向上取整
print(math.ceil(23.45))
-- modf 向零取整
print(math.modf(1.5))
print(math.modf(-1.5))
-- 向最近的整数取整
function round(x)
    local f=math.floor(x)
    if (x==f) or (x%2.0==0.5) then
        return f
    else
        return math.floor(x+0.5)
    end    
end
print(round(2.3))
print(round(1.8))
print(round(-2.3))
print(round(-1.8))
-- ]]

---[[ 表示范围
-- 标准Lua integer:  2^63-1
-- 精简Lua interger: 2^32-1

print(math.maxinteger+5)
print(math.mininteger)
-- ]]

---[[ 惯例
-- 整数+0.0=浮点数
-- 浮点数转整数：按位或、调用math.tointeger(整数.0)
-- ]]

---[[ 运算符优先级 （从高到低）
^
一元运算符 -    #   ~   not
*   /   //  %
+   -   
..
<<  >>
&
~
|
<   >   <=  >=  ~=  ==
and
or

除 ^  ..  是右结合外，其余都是左结合
-- ]]

---[[ 兼容性
    Lua5.1  Lua5.2  Lua5.3 整数兼容性
-- ]]
print(.0e12)
-- print(.e12)
-- print(0.0e)
print(0x12)
-- print(0xABFG)
print(0xA)
-- print(FFFF)
print(0xFFFFFFFF)
-- print(0x)
print(0x1P10)
print(0.1e1)
print(0x0.1p1)

print(math.maxinteger+math.maxinteger)
print(math.mininteger+math.mininteger)
print(math.maxinteger*math.maxinteger)
print(math.mininteger*math.mininteger)

for i = -10, 10, 1 do
    print(i,i%3)
end

print(2^3^4)    -->从右向左结合
print(2^81)
print(2^-3^4)
print(2^-81)