#!/usr/bin/lua
--[[ 局部变量、代码块
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

--[[ break return goto

-- ]]