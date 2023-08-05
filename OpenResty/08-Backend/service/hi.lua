local cjson=require 'cjson'
local ngx_resp=require'ngx.resp'
local util=require'util'

local ok, err = ngx.say('hi 08 backend')
local args, err = ngx.req.get_uri_args()
-- ngx.header.test='test'
-- ngx_resp.add_header('te-st','test')
-- ngx.header['Server']='ssssss'
-- ngx.say(util.table_2_string(args))
ngx.say(type(args)) --> table
if next(args) then
    for key, value in pairs(args) do
        ngx.say(key,': ',value)
    end
else
    ngx.say('没有传参')
end