#!/usr/bin/lua
-- Lua中唯一的数据结构
-- 浅拷贝
-- 关联数组
---[[
a={}
key="x"
a[key]=10
a[20]="great"
b=a
a=nil
print(b[20])
print(b["x"])
--]]

---[[ 表索引
-- 当键为string类型时，a.key <--> a["key"]
tba={}
tba["key1"]="val1"
tba.key2=12
-- tba[{1,2,3}]="val3"
tba[4]="v4"
tba[4.0]="v4.0"

for key, value in pairs(tba) do
    print("key: "..key ..", type: " ..type(key))
end
print(tba[4])
print(tba[4.0])
-- ]]

---[[ 表构造器  i.记录式  ii.列表式 iii.方括号
-- 空构造器
days={}

-- 初始化记录式表
a={x=10,y=20}

-- 列表式
b={10,20,30}

-- 混合式
pl={
    color="blue",
    thick=2,
    points=4,
    {x=0,y=0},
    {x=10,y=0},
    {x=-10,y=1},
}

-- 嵌套表
c={
    v=10,
    {
        c=30,
        {10,20},
    },
    {a=2},
}

-- 方括号
tl={['+']="add",['-']="sub",['*']="mul",["/"]="div",}
i=10;s='-'
d={[i+1]=s,[i+2]=s..s,[i+3]=s..s..s,}
-- ]]

---[[ 数组、列表和序列
-- 数组/列表：索引都为整数的表
-- 序列：所有元素都不为nil的数组。即不存在空洞的数组
-- # ：获取序列（无空洞）的长度
-- 注意值为nil的元素
-- ]]

---[[ 遍历表
t={10,print,x=12,k="hi"}
for key, value in pairs(t) do
    print(key,value)
end
print()
t1={10,print,12,"hi"}
for i=1,#t1 do 
    print(i,t1[i])
end
print()
for index, value in ipairs(t1) do
    print(index,value)
end
-- ]]

---[[ 安全访问  模拟安全访问操作符
b=a or {}
print(type(b))

E={}
zip=(((company or E).director or E).address or E).zipcode --访问3次表
-- ]]

---[[ 表标准库
-- table.insert 默认插入尾部
tb={}
for line in io.lines() do --> Ctrl+D EOF
    table.insert(tb,line)
end
print(#tb)  
-- table.remove() 默认删除尾部
tb2={1,2,3,4,5}
print(table.remove(tb2))
print(table.remove(tb2))
-- table.move()
tb3={1,2,3,4,5}
newtb={}
table.move(tb3,1,3,2)
print()
for index, value in ipairs(tb3) do
    print(value)
end
table.move(tb3,3,4,1,newtb)
print()
for index, value in ipairs(newtb) do
    print(value)
end
print(table.concat(tb3,'*'))
-- ]]