local process = require "ngx.process"

local ok, er = process.enable_privileged_agent()
if not ok then
    ngx.log(ngx.ERR, "failed: ", err)
else
    ngx.log(ngx.ERR, "启用特权进程success")
end
