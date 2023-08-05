local util = require "util"
local cjson = require "cjson"

local uri = "/hi"
local options = {
    method = ngx.HTTP_GET,
    args = {
        pa = "param_a",
        pb = "param_b"
    },
    body = "request body"
}
local res = ngx.location.capture(uri, options)
ngx.say(cjson.encode(res.status))
ngx.say(cjson.encode(res.header))
ngx.say(util.table_2_string(res.body))

local res1, res2 =
    ngx.location.capture_multi(
    {
        {"/s1"},
        {"/s2"}
    }
)
ngx.say(cjson.encode(res1.status))
ngx.say(cjson.encode(res1.header))
ngx.say(cjson.encode(res1.body))

ngx.say(cjson.encode(res2.status))
ngx.say(cjson.encode(res2.header))
ngx.say(cjson.encode(res2.body))
