local redis = require "resty.redis"

local rds, err = redis:new()
-- rds:set_timeout(10000)

local REDIS_HOST = "10.0.0.8"
local REDIS_PORT = 6379
local ok, err = rds:connect(REDIS_HOST, REDIS_PORT)
if not ok then
    ngx.say("failed to connetc: ", err)
    rds:close()
else
    ngx.say("connect redis success")
end

-- rds:set_keepalive(10000, 100)
local times = rds:get_reused_times()
ngx.say("复用次数 ", times)
ngx.say("hi redis")

local ok, err, res
ok, err = rds:set("key", "value1")
ngx.log(ngx.ERR, "redis:set() ", ok)
res, err = rds:get("key")
ngx.say(res)

ok, err = rds:hset("key2", "filed", 2017)
ngx.log(ngx.ERR, "hset: ", ok, " ", err)
res, err = rds:hget("key2", "filed")
ngx.say(res)

ok, err = rds:del("list")
ok, err = rds:lpush("list", 1, 2, 3, 4)
res, err = rds:lpop("list")
ngx.say(res)

--初始化redis管道
rds:init_pipeline()

for i = 1, 10, 1 do
    ok, err = rds:rpush("nums", i)
    -- ngx.say(ok)

    if not ok then
        --取消redis管道
        rds:cancel_pipeline()
    end
end

--提交redis管道操作
local results, err = rds:commit_pipeline()
ngx.say(results)


--在redis中使用lua脚本
local srcipts=[[
    local key=KEYS[1]
    local limit=ARGV[1] or 100
    local time=ARGV[2] or 60

    local count= redis.call('incr',key)

    if count==1 then
        redis.call('expire',key,time)
    end
    return count>=limit and 'deny' or 'allow'
]]

res,err=rds:eval(srcipts,1,'client_addr')

if res=='allow' then
    ngx.say('allow access')
end