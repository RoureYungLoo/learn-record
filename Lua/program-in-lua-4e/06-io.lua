#!/usr/bin/lua
--[[ 简单IO模型 
-- io.input()
-- io.output()

local filename='test.txt'
local filename2='test2.txt'
io.input(filename)
-- io.output(filename2)
-- print(io.read(3))
-- print(io.read(3))
-- print(io.read("l"))
-- print(io.read("L"))
-- print(io.read("a"))
-- io.write(1,2,3,3,32,'hreih,\n')
-- io.flush()

-- for counter = 1, math.huge do
--     local line=io.read("L")
--     if line==nil then
--         break
--     end
--     io.write(string.format("%3d: ",counter),line)
-- end

local count=0
-- print(type(io.lines()))
-- for line in io.lines() do
--     count=count+1
--     io.write(string.format("%6d ",count),line,'\n')
-- end
-- ]]

--[[ 文件内容按照行排序
local lines={}
for line in io.lines() do
    lines[#lines+1] = line
end
table.sort(lines)
for _, l in ipairs(lines) do
    io.write(l,"\n")
end

io.input('num.txt')
print(io.read("n"))
print(io.read("n"))
print(io.read("n"))
-- ]]
--[[
while true do
    io.write('输入：')
    io.flush()
    local block=io.read(2^13)
    if not block then
        if 'exit'==block then
            os.exit(0)
        else
            break
        end
    end
    io.write('输出：',block)
    io.flush()
end
-- ]]
--[[
io.input("num.txt")
while true do
    local n1,n2,n3=io.read("n","n","n")
    if not n1 then
        break
    end
    print(math.max(n1,n2,n3))
end
-- ]]
---[[ 完整IO模型
-- io.open()
-- print(io.open("/etc/passwd","r+"))
-- local file,err,errno=io.open("/12.txt","r")
-- print(file)
-- print(err)
-- print(errno)
-- assert(io.open("/12.txt","r"))

-- local f=assert(io.open("/etc/passwd","r"))
-- local t=f:read("L")
-- f:close()
-- print(t)
-- io.stderr:write(t)

local temp=io.input()
io.input("/etc/passwd")
print(io.read("L"))
io.input():close()
io.input(temp)
-- ]]

---[[

-- ]]