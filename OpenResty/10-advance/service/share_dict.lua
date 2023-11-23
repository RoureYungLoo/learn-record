local util = require "util"
local table_to_string = util.table_2_string
local my_dict = ngx.shared.my_dict

ngx.say("hi shared_dict ", type(my_dict))
ngx.say("my_dict:  ", table_to_string(my_dict))

-- 增删改查
-- my_dict:set()
-- my_dict:safe_set()
-- my_dict:add() 新增
-- my_dict:safe_add() 新增
-- my_dict:replace() 修改
-- my_dict:get()
-- my_dict:get_stale()
-- my_dict:delete()
-- my_dict:incr()
-- my_dict:lpush()
-- my_dict:rpush()
-- my_dict:lpush()
-- my_dict:rpop()
-- my_dict:llen()
-- my_dict:ttl()
-- my_dict:expire()
-- my_dict:get_keys()
-- my_dict:flush_all()
-- my_dict:capacity()
-- my_dict:free_space()
my_dict:flush_all()

my_dict:set("k1", "v1")
my_dict:safe_set("k2", "v2")
my_dict:set("k3", "v3")
my_dict:add("k4", "v4", 0.2, 10)
my_dict:safe_add("k5", "v5")
my_dict:replace("k5", "v55")
ngx.sleep(0.3)
-- my_dict:delete('k4')
-- local value,flags=my_dict:get('k4')
local value, flags, stale = my_dict:get_stale("k4")
ngx.say("k4 value: ", value, " k4 flags: ", flags, " k4 stale: ", stale)
-- ngx.say(my_dict:get('k5'))

ngx.say("capacity: ", my_dict:capacity())
ngx.say("free space: ", my_dict:free_space())
ngx.say(util.table_2_string(my_dict:get_keys()))

-- 原子计数
local new_val, err, forcible = my_dict:incr("counter", 3, 1)
ngx.sleep(0.21)
-- my_dict:expire("counter", 6)

ngx.say("new_val: ", new_val)

ngx.say("new_val: ", my_dict:incr("counter", 2))
ngx.say("new_val: ", my_dict:incr("counter", 3))

ngx.say("counter ttl: ", my_dict:ttl("counter"))

for i = 1, 1500, 1 do
    my_dict:lpush("list", "bool = parse_native_resp(bid_result, tag_info, ads, ssp_params)")
    my_dict:lpush("list", "bool = parse_native_resp(bid_result, tag_info, ads, ssp_params)")
    my_dict:lpush("list", "bool = parse_native_resp(bid_result, tag_info, ads, ssp_params)")
end
ngx.say(my_dict:llen("list"))
ngx.say(my_dict:lpop("list"))
ngx.say(my_dict:rpop("list"))

ngx.say(util.table_2_string(my_dict:get_keys()))

local capacity = my_dict:capacity()
-- ngx.say("capacity: ", capacity/1024, " KB")
ngx.say("capacity: ", capacity / 1024 / 1024, " MB")
-- ngx.say(1024*1024==capacity)
ngx.say("free space: ", my_dict:free_space())

-- local function cycle(premuture, p1,p2,p3)
local function cycle(premuture, shm_name)
    -- ngx.log(ngx.ERR,p1,p2,p3)
    if premuture then
        return
    end
    -- ngx.log(ngx.ERR, 'shm_name: ',shm_name)
    local val = ngx.shared[shm_name]:incr("counter", 1)
    ngx.log(ngx.ERR," counter: ", val)
    -- ngx.log(ngx.ERR, "当前时间 ", ngx.time(), " counter: ", val)
    -- ngx.log(ngx.ERR,'当前timer running 个数： ',ngx.timer.running_count())
end

-- local ok, err = ngx.timer.every(0.1, cycle, "my_dict")
if not ok then
    ngx.say("timer 启动 error")
else
    ngx.say("timer 启动 成功")
end

ngx.say("counter ttl: ", my_dict:ttl("counter"))

-- ngx.say('当前counter值：',my_dict:incr('counter',1))

local process=require'ngx.process'
ngx.say(process.type())
local ok, err = ngx.say(ngx.worker.count())
ngx.say(ngx.worker.pid())
ngx.say(ngx.worker.id())
ngx.say(ngx.worker.exiting())

local params=ngx.req.get_uri_args()

local reload=params.reload

ngx.say(ngx.worker.pid())
if tonumber(reload)==1 then
    ngx.say('主动退出worker ')
    process.signal_graceful_exit()
end
ngx.say(ngx.worker.pid())

ngx.say(process.get_master_pid())