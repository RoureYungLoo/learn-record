local ok, err = ngx.say('sem')

local semaphore = require 'ngx.semaphore'
local spawn=ngx.thread.spawn

local sema = semaphore.new(0)
local shmem = ngx.shared[shmem]
local function producer(n)
    for i = l, n do
        shmem:rpush('logs', 'xxx')
        sema:post()
        ngx.sleep(0.1)
        ngx.say(sema:count())
    end
end

local function consumer(n)
    for i = l, n do
        local ok, err = sema:wait(0.2)
        if not ok then
            ngx.say('failed :', err)
            return
        end
        local v = shmem:lpop('logs')
    end
end

local threads = {
    spawn(producer, 3),
    spawn(consumer, 3)
}
