local say=ngx.say
local util=require'util'

--检测断连

local function cleanup()
    ngx.log(ngx.ERR,"客户端连接断开")
end
ngx.on_abort(cleanup)
ngx.sleep(10)


--流程控制
-- ngx.redirect('https://www.baidu.com', ngx.HTTP_MOVED_TEMPORARILY)
-- ngx.exec('/hi-control',{a='hi1',b='hi2'})
-- ngx.exit(ngx.HTTP_BAD_REQUEST)

-- -- 手动收发数据
-- local sock,err= ngx.req.socket() --> nil
-- assert(sock)
-- local len=tonumber(ngx.var.http_content_length)
-- local data=sock:receive(len)
-- -- ngx.log(ngx.ERR,'手动读取len的数据',data)
-- ngx.log(ngx.ERR,'len: ',len)

-- ngx.header.content_lenth=len
-- ngx.send_headers()
-- ngx.flush(true)
-- local sock,err= ngx.req.socket(true)
-- sock:send(data)
-- -- ngx.flush()



-- --响应体
-- --发送响应体
-- local data={'one','two','three'}
-- for i, v in ipairs(data) do
--     ngx.print(v)
--     ngx.flush(true)
-- end
-- -- 过滤数据 body_filter_by_lua* 



-- --响应头
-- ngx.status=ngx.HTTP_ACCEPTED
-- ngx.header['Server']='test server'
-- ngx.header.new_field='new value'
-- ngx.header.data_size=1025
-- ngx.header['You-Can']='you up'

-- local ngx_resp=require'ngx.resp'
-- ngx_resp.add_header('Add-Attr','add value')
-- ngx.send_headers() --会在ngx.say ngx.print之前自动调用
--[==[
say('response header: ',util.table_2_string(ngx.resp.get_headers()))
ngx.say('响应头是否已经发送到客户端: ',ngx.headers_sent)



--请求体
-- 丢弃请求体
-- ngx.req.discard_body()
-- 读取请求体
ngx.req.read_body() --同步非阻塞
local data=ngx.req.get_body_data()
say('ngx.req.get_body_data() \n',data)
local filename=ngx.req.get_body_file()
say('ngx.req.get_body_file() \n',filename)
-- ngx.req.get_body_file() 
-- /root/learn-record/OpenResty/07-HTTP/http/client_body_temp/0000000001
-- 改写请求体
ngx.req.set_body_data('yyyy')
say('改写请求体',ngx.req.get_body_data())
--新建请求体
ngx.req.init_body()
ngx.req.append_body('aaa')
ngx.req.append_body('bbb')
ngx.req.append_body('ccc')
ngx.req.finish_body()
say('新建请求体：',ngx.req.get_body_data())


--请求头
--改写请求头
ngx.req.set_header('Accept','Firefox')
ngx.req.set_header('TeST','test-header')
ngx.req.set_header('TeST-2','test-header')
ngx.req.clear_header('tEst')
local headers=ngx.req.get_headers()
say('ngx.req.getheaders():\n',util.table_2_string(headers))
say('headers.host:',headers.host)
say("headers['User-Agent']: ",headers['User-Agent'])


--参数编码
local args={
    name='lu&ruo#yang',
    age='25',
    addr='+/',
}
local args_enc=ngx.encode_args(args)
local args_dec=ngx.decode_args(args_enc)
say('args_enc: ',args_enc)
say('args_dec: ',util.table_2_string(args_dec))

--改写URI参数
local args={
    a1='a1#%',
    b1='b1#%',
}
-- ngx.req.set_uri_args(args)
say(util.table_2_string(ngx.var.args))

--获取POST 参数 
ngx.req.read_body()
say('ngx.req.get_post_args() ',util.table_2_string(ngx.req.get_post_args()))



--获取GET 参数 
say('ngx.req.get_uri_args() ',util.table_2_string(ngx.req.get_uri_args()))


-- 指令 、 常量 、 变量
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
    请求行 : 请求方法 URI HTTP版本
    首部行
    请求体

响应：
    状态行
    首部行
    响应体
-- ]]
--请求头原始文本
say('------- ngx.req.raw_header() -------')
say(ngx.req.raw_header())
say('------- ngx.req.raw_header() -------')

-- GET / HTTP/1.1
-- User-Agent: curl/7.29.0
-- Host: 127.0.0.1:82
-- Accept: */*  

--暂存数据
-- ngx.ctx.tmp_data='ngx_ctx_tmp_data'  rewrite_by_lua_file service/http/rewrite.lua;
say(ngx.ctx.tmp_data)


--请求行 见rewrite.lua

--版本
say('ngx.req.http_version(): ',ngx.req.http_version())

--方法
local method={
    GET=ngx.HTTP_GET,
    POST=ngx.HTTP_POST,
    PUT=ngx.HTTP_PUT,
    DELETE=ngx.HTTP_DELETE,
    HEAD=ngx.HTTP_HEAD,
}
say('ngx.req.get_method(): ',ngx.req.get_method())
ngx.req.set_method(ngx.HTTP_POST)
ngx.req.set_method(ngx.HTTP_PUT)
ngx.req.set_method(method.GET)
say('ngx.req.get_method(): ',ngx.req.get_method())

--参数 ↑
-- ]==]


