local resolver = require "resty.dns.resolver"
local util=require'util'

local r, err =
    resolver:new {
    nameservers = {"8.8.8.8", {"4.4.4.4", 53}, "4.2.2.2",'114.114.114.114','4.2.2.1'},
    timeout = 1000
}
if not r then
    ngx.say('failed to init resolver: ',err)
end

local ans,err=r:query('www.openresty.org')
if not ans then
    ngx.say('failed to query: ',err)
end
if ans.errcode then
    ngx.say('errcode: ',ans.errcode,' :',ans.errstr)
end
ngx.say(util.table_2_string(ans))

local lrucache=require'resty.lrucache'

local dns,err=lrucache.new(100)

local addr={}
for _, entry in ipairs(ans) do
    if entry.address then
        addr[#addr+1] = {entry.address,entry.ttl}
    end
end
ngx.say(util.table_2_string(addr))
dns:set('openresty.com',addr,30)

