#!/usr/local/bin/lua

-- 类型
-- 命令行调试 RemDebug、clidebugger、ctrace、xdbLua、LuaInterface - Debugger、Rldb、ModDebug
-- 图形界面调试 SciTE、Decoda、ZeroBrane Studio、akdebugger、luaedit

-- lua debug库
-- debug():
-- getfenv(object): 返回对象的环境变量。
-- gethook(optional thread):
-- getinfo ([thread,] f [, what]):
-- debug.getlocal ([thread,] f, local):
-- getmetatable(value):
-- getregistry():
-- getupvalue (f, up)
-- sethook ([thread,] hook, mask [, count]):
-- setlocal ([thread,] level, local, value):
-- setmetatable (value, table):
-- setupvalue (f, up, value):
-- traceback ([thread,] [message [, level]]):

-- function myfunc()
-- print(debug.traceback("Stack trace"))
-- print(debug.getinfo(1))
-- print("Stack trace end")
-- return 10
-- end

-- myfunc()
-- print(debug.getinfo(1))

function newCounter()
    local n=0
    local k=0
    return function()
        k=n
        n=n+1
        return n
    end
end
counter=newCounter()
print(counter())
print(counter())

local i=1


repeat
    name ,val=debug.getupvalue(counter,i)
    print(name,val)
    if name then
        print("index",i,name,"=",val)
        if (name=="n") then
            debug.setupvalue(counter,2,10)
        end
        i=i+1
    end

until not name

print(counter())