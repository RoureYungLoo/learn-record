#!/usr/local/bin/lua
-- 语法错误
-- a==2
-- for a=1,10 
--     print(a)
-- end
-- 运行错误
-- function add(a,b)
--     return a+b
-- end

-- add(10)

-- 错误处理
-- assert() 
-- error()

-- local function add(a,b)

--     assert(type(a)=="number","错误，a不是数字类型")
--     assert(type(b)=="number","错误，b不是数字类型")
--     return a+b
-- end
-- add(10)

-- error("error永不返回",0)

-- pcall() protected call, pcall返回时，它已经销毁了调用桟的部分内容。
-- xpcall(),xpcall接收第二个参数——一个错误处理函数，当错误发生时，Lua会在调用桟展
-- 开（unwind）前调用错误处理函数，于是就可以在这个函数中使用debug库来获取关于错误
-- 的额外信息了。debug库提供了两个通用的错误处理函数:debug:.debug()和debug.traceback()
-- debug()

-- if pcall(func_name,...) then
--     没有错误
-- else
--     一些错误
-- end

-- sum={}
-- function add(a,b,sum)
--     sum["sum"]=a+b
-- end

-- if pcall(add,2,3,sum) then
--     print("pcall返回值true")
--     print(sum["sum"])
-- else
--     print("pcall返回值false")
--     print(sum["sum"])
-- end
s={}
function myfunc(a,b)
    s["sum"]=a+b
    n=b/nil
end

function handler(msg)
    print(">>>>>" .. msg .. "<<<<<<<")
    -- print(debug.debug())
    print(debug.traceback())
end

xpcall(myfunc,handler,4,5)
print(s["sum"])