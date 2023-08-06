ngx.say("cosocket demo")

local sock = ngx.socket.tcp()
sock:settimeout(1000)

local ok, err = sock:connect("127.0.0.1", 900)

local mp = require "resty.msgpack"

local msg = {str = "hello", num = 3}
local body = mp.pack(msg)
local header = mp.pack(#body)
ngx.log(ngx.ERR, "body: ", body)
ngx.log(ngx.ERR, "header: ", header)

local _, err = sock:send(header .. body)

local data, err = sock:receive("*a")
local iter = mp.unpacker(data)

local _, len = iter()
local _, msg = iter()

ngx.say("len: ", len, " data: ", msg)

sock:setkeepalive()
