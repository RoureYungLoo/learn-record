local util = require "util"
local upstream = require "ngx.upstream"
ngx.say("hi proxy")

local params = ngx.req.get_uri_args()
local action = params.action
local index = params.index
local role = params.role
local is_backup = nil
if role == "1" then
    is_backup = false
elseif role == "2" then
    is_backup = true
end

ngx.say(action .. " " .. "service " .. tostring(index))

local ACTION = {
    up = false, -- 下线
    down = true -- 上线
}

local ok, err = upstream.set_peer_down("backend4", is_backup, index - 1, ACTION[action])
-- local ok, err = upstream.set_peer_down("backend4", true, 3, true)
if not ok then
    ngx.say("动态" .. action .. "服务失败 ", err)
else
    ngx.say("动态" .. action .. "服务器成功")
end

-- if action == "up" then
--     local ok, err = upstream.set_peer_down("backend4", is_backup, index - 1, true) --上线
--     if not ok then
--         ngx.say("动态上线服务器失败 ", err)
--     else
--         ngx.say("动态上线服务器成功")
--     end
-- end

-- if action == "down" then
--     local ok, err = upstream.set_peer_down("backend4", is_backup, index - 1, false) --下线
--     if not ok then
--         ngx.say("动态下线服务器失败 ", err)
--     else
--         ngx.say("动态下线服务器成功")
--     end
-- end
