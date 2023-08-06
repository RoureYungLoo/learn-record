local util = require "util"
local cjson = require "cjson"
local params=util.table_2_string(ngx.req.get_uri_args())
ngx.log(ngx.ERR,'uri参数是：',params)
ngx.say(params)