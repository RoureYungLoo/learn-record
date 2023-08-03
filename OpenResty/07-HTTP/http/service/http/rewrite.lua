ngx.ctx.tmp_data='ngx_ctx_tmp_data'
local say=ngx.say

--请求行： 请求方法  URI  HTTP版本
ngx.log(ngx.ERR,'------- ngx.var.xxx -------')
local ok, err = ngx.log(ngx.ERR,'ngx.var.request: ',ngx.var.request)
local ok, err = ngx.log(ngx.ERR,'ngx.var.schema: ',ngx.var.schema)
local ok, err = ngx.log(ngx.ERR,'ngx.var.request_method: ',ngx.var.request_method)
local ok, err = ngx.log(ngx.ERR,'ngx.var.request_uri: ',ngx.var.request_uri)
local ok, err = ngx.log(ngx.ERR,'ngx.var.uri: ',ngx.var.uri)
local ok, err = ngx.log(ngx.ERR,'ngx.var.document_uri: ',ngx.var.document_uri)
local ok, err = ngx.log(ngx.ERR,'ngx.var.args: ',ngx.var.args)
local ok, err = ngx.log(ngx.ERR,'ngx.var.arg_a: ',ngx.var.arg_a)
local ok, err = ngx.log(ngx.ERR,'ngx.var.arg_b: ',ngx.var.arg_b)
ngx.log(ngx.ERR,'------- ngx.var.xxx -------')

-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:5: ------- ngx.var.xxx -------, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:6: ngx.var.request: GET /test?a=1&b=2 HTTP/1.1, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:7: ngx.var.schema: nil, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:8: ngx.var.request_method: GET, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:9: ngx.var.request_uri: /test?a=1&b=2, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:10: ngx.var.uri: /test, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:11: ngx.var.document_uri: /test, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:12: ngx.var.args: a=1&b=2, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:13: ngx.var.arg_a: 1, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:14: ngx.var.arg_b: 2, 
-- 2023/08/03 08:41:56 [error] 3494#0: *8 [lua] rewrite.lua:15: ------- ngx.var.xxx -------, 

ngx.log(ngx.ERR, "ngx.escape_uri('`')",ngx.escape_uri('`'))
ngx.log(ngx.ERR, "ngx.escape_uri('!')",ngx.escape_uri('!'))
ngx.log(ngx.ERR, "ngx.escape_uri('@')",ngx.escape_uri('@'))
ngx.log(ngx.ERR, "ngx.escape_uri('#')",ngx.escape_uri('#'))
ngx.log(ngx.ERR, "ngx.escape_uri('$')",ngx.escape_uri('$'))
ngx.log(ngx.ERR, "ngx.escape_uri('%')",ngx.escape_uri('%'))
ngx.log(ngx.ERR, "ngx.escape_uri('^')",ngx.escape_uri('^'))
ngx.log(ngx.ERR, "ngx.escape_uri('&')",ngx.escape_uri('&'))
ngx.log(ngx.ERR, "ngx.escape_uri('*')",ngx.escape_uri('*'))
ngx.log(ngx.ERR, "ngx.escape_uri('(')",ngx.escape_uri('('))
ngx.log(ngx.ERR, "ngx.escape_uri(')')",ngx.escape_uri(')'))
ngx.log(ngx.ERR, "ngx.escape_uri('-')",ngx.escape_uri('-'))
ngx.log(ngx.ERR, "ngx.escape_uri('_')",ngx.escape_uri('_'))
ngx.log(ngx.ERR, "ngx.escape_uri('+')",ngx.escape_uri('+'))
ngx.log(ngx.ERR, "ngx.escape_uri('=')",ngx.escape_uri('='))
ngx.log(ngx.ERR, "ngx.escape_uri('<')",ngx.escape_uri('<'))
ngx.log(ngx.ERR, "ngx.escape_uri('>')",ngx.escape_uri('>'))
ngx.log(ngx.ERR, "ngx.escape_uri('/')",ngx.escape_uri('/'))


local new_req_uri='/new_req_uri'
ngx.req.set_uri(new_req_uri,false)
ngx.log(ngx.ERR,'ngx.var.uri: ',ngx.var.uri)
-- ngx.req.set_uri(new_req_uri,true)
