local util = require "util"

ngx.say("dynamic")

local upstream =require'ngx.upstream'   `

local peers=upstream.get_primary_peers('backend4')
local bk_peers=upstream.get_backup_peers('backend4')

for _, peer in ipairs(peers) do
    ngx.say('primary peers: \n'..util.table_2_string(peer),'\n')
end

for _, peer in ipairs(bk_peers) do
    ngx.say('bk_peers: \n'..util.table_2_string(peer),'\n')
end