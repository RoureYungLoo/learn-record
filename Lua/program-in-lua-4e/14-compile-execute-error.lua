#!/usr/bin/lua

-- loadfile 从文件中加载lua代码

function dofile(filename)
    local func = assert(loadfile(filename))
    return func()
end

-- load 从字符串中加载lua代码
f = load("i=i+1") --lua5.3
i=0
f()
f()
print(i)

i=32
local i=0
f=load("i=i+1;print(i)") -- 总是在全局环境中编译代码段
g=function ()
    i=i+1;print(i)
end
f()
g()

print "enter your expression :" 
local line = io.read ()
local func = assert(load ("return " .. line)) 
print ("the value of your exp ession is " .. func()) 
for i = 1, 5 do
    
end