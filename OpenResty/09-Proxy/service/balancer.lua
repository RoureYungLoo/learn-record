local balancer = require "ngx.balancer"

local servers = {
    {"10.0.0.8", 7006},
    {"10.0.0.8", 7005},
    {"10.0.0.8", 7004}
}

balancer.set_timeouts(1, 0.5, 0.5)
balancer.set_more_tries(3)

math.randomseed(ngx.time())
local n = math.random(#servers) --n=3
ngx.log(ngx.ERR,'生成的随机数：',n)
local ok, err = balancer.set_current_peer(servers[n][1], servers[n][2])
ngx.log(ngx.ERR, "servers[n][1]: " .. servers[n][1] .. " servers[n][2]： ", servers[n][2])
if not ok then
    ngx.log(ngx.ERR, "failed to set peer: ", err)
    return ngx.exit(500)
end
