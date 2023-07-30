
-- 指令 、 常量 、 变量
local say=ngx.say
say('hi http')
say(ngx.var.age)
say(ngx.var.test_var)
say(ngx.var.addr)
say(ngx.var.phone)
-- say(ngx.var.name)
say(ngx.var.uri)
say(ngx.var.is_args)
say(ngx.var.http_host)
say(ngx.var.http_user_agent)
say(ngx.var.request_length)
-- say(ngx.var.ddd) 
ngx.var.new_var=12345
say(ngx.var.new_var)

-- 基本信息
say(ngx.req.is_internal())
ngx.sleep(0.2)
say(ngx.var.request_time)
say(ngx.now()-ngx.req.start_time()) -- 开销更少

--[[ 报文结构：开始行+首部行+实体主体【又称报文主体】
请求：
    请求行
    首部行
    请求体

响应：
    状态行
    首部行
    响应体
-- ]]
--请求头原始文本
say(ngx.req.raw_header())
-- GET / HTTP/1.1
-- User-Agent: curl/7.29.0
-- Host: 127.0.0.1:82
-- Accept: */*  

--请求行