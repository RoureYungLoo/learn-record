#!/usr/local/bin/lua
local util=require'util'
-- print(util.table_2_string(coroutine))
--[=[ {
--     [create] = function: 0x41abc0
--     [wrap] = function: 0x41ac10
--     [running] = function: 0x41aba0
--     [status] = function: 0x41ad20
--     [isyieldable] = function: 0x41aa50
--     [resume] = function: 0x41ae10
--     [yield] = function: 0x41aa70
-- }
local f_hi=function ()
    print('hi')
end
local co=coroutine.create(f_hi)
print(type(co)) --thread
-- suspend running normal dead
print(coroutine.status(co))
coroutine.resume(co)

co=coroutine.create(function ()
    for i=1,10 do
        print("co ",i)
        coroutine.yield()
    end
end)
coroutine.resume(co)
coroutine.resume(co)
coroutine.resume(co)
coroutine.resume(co)
coroutine.resume(co)
coroutine.resume(co)
coroutine.resume(co)
coroutine.resume(co)
coroutine.resume(co)
coroutine.resume(co)
coroutine.resume(co)
print(coroutine.resume(co)) --false   cannot resume dead coroutine

local f2=function (a,b,c)
    print("co ",a,b,c+2)
end
co=coroutine.create(f2)
print(coroutine.resume(co,1,2,3))

co=coroutine.create(function (a,b)
    coroutine.yield(a+b,a-b)
end)
print(coroutine.resume(co,20,10))

co=coroutine.create(function (x)
    print("co1",x)
    print("co2",coroutine.yield())
end)
coroutine.resume(co,"hi")
coroutine.resume(co,4,5)

co=coroutine.create(function ()
    return 6,7
end )
print(coroutine.resume(co))
--]=]

--[[function producer()
    while true do
        local x=io.read()
        send(x)
    end
end
function consumer()
    while true do
        local x=receive()
        io.write(x,"\n")
    end
end
function receive( )
    local statu,value=coroutine.resume(producer)
    return value
end
function send(x)
    coroutine.yield(x)
end
producer=coroutine.create(producer)
--]]

--[[function receive(prod)
    local status,value=coroutine.resume(prod)
    return value
end
function send(x)
    coroutine.yield(x)
end
function producer()
    return coroutine.create(function ()
        while true do
            local x=io.read()
            send(x)
        end
    end)
end
function filter(prod)
    return coroutine.create(function ()
        for line=1,math.huge do
            local x=receive(prod)
            x=string.format("%5d %s",line,x)
            send(x)
        end
    end) 
end
function consumer(prod)
    while true do
        local x=receive(prod)
        io.write(x,"\n")
    end
end

consumer(filter(producer()))
-- ]]

--[=[function permgen(a,n)
    n=n or #a
    if n<=1 then
        -- printResult(a)
        coroutine.yield(a)
    else
        for i=1,n do
            a[n],a[i]=a[i],a[n]
            permgen(a,n-1)
            a[n],a[i]=a[i],a[n]
        end
    end
end

function printResult(a)
    for i=1,#a do io.write(a[i]," ") 
    end 
    io.write("\n")
end
function permutations(a)
    local co=coroutine.create(function ()
        permgen(a)
    end)
    return function ()
        local code,res=coroutine.resume(co)
        return res
    end
end

for p in permutations({'a','b','c'}) do
    printResult(p)
end
-- permgen({1,2,3})
--]=]

function f3()
    print('f3')
end
coroutine.wrap(f3)()

-- local cmdQueue={}
-- local lib={}
-- function lib.readline(stream,callback)
--     local nextCmd=function ()
--         callback(stream:read())
--     end
--     table.insert(cmdQueue,nextCmd)
-- end

-- function lib.writeline(stream,line,callback)
--     local nextCmd=function ()
--         callback(stream:write(line))
--     end
--     table.insert(cmdQueue,nextCmd)
-- end

-- function lib.stop(  )
--     table.insert(cmdQueue,"stop")
-- end

-- function lib.runloop()
--     while true do
--         local nextCmd=table.remove(cmdQueue,1)
--         if nextCmd=="stop" then
--             break
--         else
--             nextCmd()
--         end
--     end
-- end
-- -- return lib

--[[local t={}
local inp=io.input()
local out=io.output()

for line in inp:lines() do
    t[#t+1] = line
end

for i=#t,1,-1 do
    out:write(t[i],"\n")
end
local lib=require'async-lib'
local t={}
local inp=io.input()
local out=io.output()
local i
local function putline()
    i=i-1
    if i==0 then
        lib.stop()
    else
        lib.writeline(out,t[i] .. "\n" ,putline)
    end
end
local function getline(line)
    if line then
        t[#t+1]=line
        lib.readline(inp,getline)
    else
        i=#t+1
        putline()
    end
end

lib.readline(inp,getline)
lib.runloop()
--]]

---[[
local lib = require 'async-lib'
local function run(code)
    local co = coroutine.wrap(function()
        code()
        lib.stop()
    end)
    co()
    lib.runloop()
end

function putline(stream, line)
    local co = coroutine.running()
    local callback = (function()
        coroutine.resume(co)
    end)
    lib.writeline(stream, line, callback)
    coroutine.yield()
end

function getline(stream, line)
    local co = coroutine.running()
    local callback = (function(l)
        coroutine.resume(co, l)
    end)
    lib.readline(stream, callback)
    local line = coroutine.yield()
    return line
end
local reverse_io = function()
    local t = {}
    local inp = io.input()
    local out = io.output()

    while true do
        local line = getline(inp)
        if not line then break end
        t[#t + 1] = line
    end

    for i = #t, 1, -1 do
        putline(out, t[i] .. "\n")
    end
end
-- run(reverse_io)
-- ]]
print(util.table_2_string(debug.getinfo(run)))
print(util.table_2_string(debug.getinfo(run,'u')))
