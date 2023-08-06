local util = require "util"

ngx.say("static")

local upstream = require "ngx.upstream"

local names = upstream.get_upstreams()

local names_=util.table_2_string(names)

ngx.say(names_)

for _, back in ipairs(names) do
    local servers=upstream.get_servers(back)
    ngx.say('backend: ',back,'\n',util.table_2_string(servers))
end