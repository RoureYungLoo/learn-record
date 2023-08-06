ngx.say("hi websocket")

local client = require "resty.websocket.client"

local wb, err =
    client.new(
    {
        timeout = 5000,
        max_payload_len = 1024 * 64
    }
)

if not wb then
    ngx.say('wb new failed')
end

-- wb:set_timeout(1000)

local ok,err=wb:connect('ws://10.0.0.8:8013/srv')
if not ok then
    ngx.say('failed to connect: ',err)
end

-- wb:set_keepalive(1000,100)

-- 发送数据 send_ping send_text send_binary

local bytes,err
bytes,err=wb:send_ping() --发送ping
if not bytes then
    ngx.say('failed to ping: ',err)
end

--接收数据 recv_frame()
local data,type,err
data,type,err=wb:recv_frame()
if not data then
    ngx.log(ngx.ERR,'failed to recv',err)
end

if type=="pong" then
    ngx.say('recv pong')
end

bytes,err=wb:send_text('hello wb') --发送text
if not bytes then
    ngx.say('failed to send_test: ',err)
end

--接收数据 recv_frame()
local data,type,err
data,type,err=wb:recv_frame()
if not data then
    ngx.log(ngx.ERR,'failed to recv',err)
end

if type=="pong" then
    ngx.say('recv pong')
end

if type=="text" then
    ngx.say('recv: ',data)
end