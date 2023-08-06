local upstream=require'ngx.upstream'

local name=upstream.current_upstream_name()
local addr=ngx.var.upstream_addr

ngx.log(ngx.ERR, 'upstream name: ',name)
ngx.log(ngx.ERR, 'upstream server addr: ',addr)
local srvs,err=upstream.get_primary_peers(name)
for _, srv in ipairs(srvs) do
    ngx.log(ngx.ERR,'use srv id: ',srv.id,' name: ',srv.name)
end