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

-- #!/usr/bin/lua

-- error 抛出异常
-- pcall xpcall 捕获异常

local function error_test()
    -- error("error 信息测试")
    -- print("error 信息测试")
    error(
        {
            msg = "error_test msg",
            code = 500,
            status = 200
        }
    )
end
local function traceback()
    print(debug.traceback())
    -- print(debug.debug())
end
local ret = print(xpcall(error_test, traceback))
assert(1, "xpcall调用失败")

-- local file, msg
-- repeat
--     print "enter a file name: "
--     local name = io.read()
--     if not name then
--         return
--     end
--     -- file, msg = io.open(name, "r")
--     -- if not file then
--     --     print(msg)
--     -- end
--     -- file=assert(io.open("r"))
-- until file

-- print(pcall(error_test))
