#!/usr/local/bin/lua
local util=require'util'

---[==[
local fun=function (pa,pb,pc)
    
end
-- print(util.table_2_string(debug.getinfo(fun)))
-- print(util.table_2_string(debug.getinfo(fun,'u')))
function traceback()
    for level=1,math.huge do
        local info= debug.getinfo(level,"Sl")
        if not info then
            break
        end
        if info.what=="C" then
            print(string.format("%d\tC function",level))
        else
            print(string.format("%d\t[%s]:%d",level,info.short_src,info.currentline))
        end
    end
end
-- traceback()
-- print(debug.traceback())
function foo(a,b)
    local x
    do local c=a-b end    
    local a=1
    while true do
        local name,value=debug.getlocal(1,a)
        if not name then break end
        print(name,value)
        a=a+1
    end
end
-- foo(10,20)

function getvarvalue(name,level,isenv)
    local value
    local found=false
    level=(level or 1)+1
    -- 局部变量
    for i=1,math.huge do
        local n,v =debug.getlocal(level,i)
        if not n then break end
        if n==name then
            value= v
            found =true
        end
    end
    if found then
        return "lcoal ",value
    end
    -- 非局部变量
    local func=debug.getinfo(level,"f").func
    for i=1,math.huge do
        local n,v=debug.getupvalue(func,i)
        if not n then
            break
        end
        if n==name then
            return "value ",v
        end
    end
    if isenv then return "noenv" end

    -- 没找到，从环境中获取值
    local _,env=getvarvalue("_ENV",level,true)
    if env then
        return "global",env[name]
    else
        return "noenv"
    end
end
local a=4
-- print(getvarvalue("a"))
a="xx"
-- print(getvarvalue("a"))

co=coroutine.create(function ()
    local x=10
    coroutine.yield()
    error("some error")
end)
coroutine.resume(co)
-- print(debug.traceback(co))
-- print(coroutine.resume(co))
-- print(debug.getlocal(co,1,1))

-- print(util.table_2_string(debug))

-- debug.sethook(print,"l")
function trace(event,line)
    local s=debug.getinfo(2).short_src
    print(s .. ":" .. line)
end
-- debug.sethook(trace,"l")
local a=1
local b=2
-- debug.debug()
--]==]

---[[
local Counters={}
local Names={}
local function hook()
    local f=debug.getinfo(2,"f").func
    local count=Counters[f]
    if count==nil then
        Counters[f]=1
        Names[f]=debug.getinfo(2,"Sn")
    else
        Counters[f]=count+1
    end
end
local f=assert(loadfile(arg[1]))
debug.sethook(hook,"c")
f()
debug.sethook()

function getname(func)
    local n=Names[func]
    if n.what=="C" then
        return n.name
    end
    local lc=string.format("[%s]:%d",n.short_src,n.linedefined)
    if n.what~="main" and n.namewhat~="" then
        return string.format("%s (%s)",lc,n.name)
    else
        return lc
    end
end
for func,count in pairs(Counters) do
    print(getname(func),count)
end
--]]
---[[ 沙盒 指令
local debug = require "debug"
local steplimit = 1000
local count = 0
local function step()
    count = count + 1
    if count > steplimit then
        error("use too much CPU")
    end
end
local f = assert(loadfile(arg[1], "t", {}))
debug.sethook(step, "", 100)
f()
-- ]]


---[[ 指令和内存
local memlimit = 1000 --1000KB
local steplimit = 100000
local function checkmem()
    print(tostring(collectgarbage("count")/1024).." MB")
    if collectgarbage("count") > memlimit then
        error("use too many memory")
    end
end
local count = 0
local function step()
    checkmem()
    count = count + 1
    if count > steplimit then
        error("use too much CPU")
    end
end
local f = assert(loadfile(arg[1], "t", {}))
debug.sethook(step, "", 100)
f()
-- ]]
---[[
local debug = require "debug"
local steplimit = 1000
local count = 0
local valid_func = {
    [string.upper] = true,
    [string.lower] = true,
    [string.sub] = true,
    [string.gsub] = true,
    [string.len]=false,
    [string.format]=false
}
local function hook(event)
    if event == "call" then
        local info = debug.getinfo(2, "fn")
        if not valid_func[info.func] then
            error("calling bad function: " .. (info.name or "?"))
        end
    end
    count = count + 1
    if count > steplimit then
        error("use too much CPU")
    end
end
local f = assert(loadfile(arg[1], "t", {}))
debug.sethook(hook, "", 100)
f()
-- ]]