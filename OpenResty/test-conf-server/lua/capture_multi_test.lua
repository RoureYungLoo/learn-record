local util = require "util"
local table_2_string = util.table_2_string

ngx.say("capture_multi_test ok")
local reqs = {}
table.insert(reqs, {"/api_1"})
table.insert(reqs, {"/api_2"})
table.insert(reqs, {"/api_3"})
local resps = {ngx.location.capture_multi(reqs)}
-- ngx.log(ngx.ERR, table_2_string(resps))
ngx.say("table_2_string(resps): ")
ngx.say(table_2_string(resps))
-- 循环返回表
for i, resp in ipairs(resps) do
end
