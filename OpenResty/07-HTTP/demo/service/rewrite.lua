local method=ngx.req.get_method()
if method~='GET' and method~='POST' then
    ngx.header['Allow']='GET,POST'
    ngx.exit(405)
end

local ver=ngx.req.http_version()
if ver<1.1 then
    ngx.exit(400)
end

-- 共享
ngx.log(ngx.ERR,'ngx.var.arg_need_encode: ',ngx.var.arg_need_encode)
ngx.ctx.encode=ngx.var.arg_need_encode

ngx.header.content_lenth=nil