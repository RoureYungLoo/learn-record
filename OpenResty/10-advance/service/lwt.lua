local spawn = ngx.thread.spawn
local wait = ngx.thread.wait
local kill = ngx.thread.kill
local ok, err = ngx.say("lwt")

-- function func1(params)
--     ngx.say("query redis: ", params)
-- end

-- function func2(params)
--     ngx.say("query mysql: ", params)
-- end

-- spawn(func1, "params 1")
-- spawn(func2, "params 2")

function func3(time)
    ngx.sleep(time)
    ngx.say("job fin in ", time)
    return time
end

local threads={
    spawn(func3,0.25),
    spawn(func3,0.15),
    spawn(func3,0.35),
}
-- local ok ,ret=wait(unpack(threads))
-- ngx.say('===========')
-- ngx.say('ok: ',ok,', ret: ',ret)

for _, th in ipairs(threads) do
    -- local ok,ret=wait(th)
    -- ngx.say('ok: ',ok,', ret: ',ret)
    
    local ok,err=kill(th)
    ngx.say('ok: ',ok, ' err: ',err)
end

function f()
    local co=coroutine.running()
    ngx.print(1)
    coroutine.yield(co)
    ngx.print(2)
end
function g()
    local co=coroutine.running()
    ngx.print('a')
    coroutine.yield(co)
    ngx.print('b')
end
spawn(f)
spawn(g)
-- 1a2b