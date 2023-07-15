#!/usr/bin/lua
---[[ 局部变量、代码块
x=10
local i=1

while i<=x do
    local x=i*x
    print(x)
    i=i+1
end

if i>20 then 
    local x
    x=20
    print(x+20)
else
    print(x)
end

print(x)
local x1,x2
do
    -- local a2=2*a
    -- local d=(b^2-4*a*c)^(1/2)
    -- x1=(-b+d)/a2
    -- x2=(-b-d)/a2
end
print(x1,x2)
local a,b=1,10
if a<b then 
    print(a)
    local a
    print(a)    -->  nil
end
print(a,b)
-- ]]

---[[ 控制结构
-- if then else end
-- while do end
-- for do end
-- repeat until
-- ]]
---[[ if condition then body end
--if
if 1<=2 then
    print("1<=2")
end

if 1>=2 then
    print("1>=2")
elseif 1<=2 then
    print("1<=2")
end

io.output():setvbuf("line")
local i=1
-- while
while i<15 do
    io.output():write('.')  
    i=i+1
end
print()
io.output():flush()
--repeat
local line
repeat 
    line=io.read()
until line~=""
print(line)
--数值for
local found={}
for ii=1,10,1 do -->[start][end][step]表达式只会运行一次
    print(math.huge)
    if ii%2==0 then
        table.insert(found,ii)
    end
end
print(found)
for index, value in ipairs(found) do
    print(index,' '..value)
end
--泛型for
--ipairs : 按照索引从1开始升序遍历，索引中断停止遍历
for index, value in ipairs({1}) do
    --
end
--pairs : 能遍历集合的所有元素
for key, value in pairs({1}) do
    --
end
print()
local tab1={
    [1]="test1",
    [2]="test2",
    [4]="test4",
    [5]="test5",

}
for index, value in ipairs(tab1) do
    print(index,value)
end
print("---")
for index, value in pairs(tab1) do
    print(index,value)
end
local tab2={}

-- ]]

---[[ break return goto
-- 局部变量的作用域终止于声明变量的代码块中的最后一个有效（non-void）语句处
-- 标签被认为是无效（void）语句
::s1:: do
    local c =io.read(1)
    if c=='0' then goto s2
    elseif c==nil then print('输入了偶数个"0"');return
    else goto s1
    end
end
::s2:: do
    local c=io.read(1)
    if c=='0'then goto s1
    elseif c==nil then print('输入了奇数个"0"');return
    else goto s2
    end
end
goto s1
-- ]]
---[[ 简单迷宫
--|￣￣￣|￣￣￣|
--|______|_____|
--|      |     |
--|______|_____|
::room1:: do
    local move=io.read()
    if move=="south" then goto room3
    elseif move=="east" then goto room2
    else goto room1
    end
end

::room2:: do
    local move=io.read()
    if move=="south" then goto room4
    elseif move=="west" then goto room1
    else goto room2
    end
end

::room3:: do
    local move=io.read()
    if move=="north" then goto room1
    elseif move=="east" then goto room4
    else goto room1
    end
end

::room4:: do
print("恭喜走出迷宫")
end

-- ]]