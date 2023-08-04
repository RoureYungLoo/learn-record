local white_list = {
    ["10.0.0.1"]=1,
    ["127.0.0.1"]=1,
}
local ip = ngx.var.remote_addr
ngx.log(ngx.ERR, ip)
if not white_list[ip] then
    ngx.log(ngx.ERR,ip,' is blocked')
    ngx.exit(403)
end