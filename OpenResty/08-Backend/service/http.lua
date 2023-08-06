local util = require "util"
local cjson = require "cjson"
ngx.say('http hi')

local http=require'resty.http'

local httpc=http:new()

httpc:set_timeouts(1000,1000,1000)

local res,err=httpc:request_uri('http://127.0.0.1:8081',{
    path='/echo',
    query={
        name='httpc',
        age=1,
        addr='test addr'
    }
})

if not res then
    ngx.say('请求发送失败 ',err)
end

ngx.say(util.table_2_string(res.status))
ngx.say(util.table_2_string(res.headers))
ngx.say(util.table_2_string(res.body))