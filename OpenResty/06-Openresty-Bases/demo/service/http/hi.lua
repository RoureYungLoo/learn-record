
-- 系统信息
ngx.say('hi')
ngx.say(ngx.config.debug)
ngx.say(ngx.config.prefix())
ngx.say(ngx.config.nginx_version)
ngx.say(ngx.config.nginx_configure())
ngx.say(ngx.config.subsystem)
ngx.say(ngx.config.ngx_lua_version)

-- 运行日志
ngx.log(ngx.STDERR,"日志级别 STDERR") --??
ngx.log(ngx.EMERG,"日志级别 EMERG")
ngx.log(ngx.ALERT,"日志级别 ALERT")
ngx.log(ngx.CRIT,"日志级别 CRIT")
ngx.log(ngx.ERR,"日志级别 ERR")
ngx.log(ngx.WARN,"日志级别 WARN")
ngx.log(ngx.NOTICE,"日志级别 NOTICE")
ngx.log(ngx.INFO,"日志级别 INFO")

-- 时间日期
ngx.say(ngx.today())
ngx.say(ngx.localtime())
ngx.say(ngx.utctime())

-- 时间戳
ngx.say('时间戳：'.. ngx.time())
ngx.update_time() --更新时间
ngx.say('时间戳毫秒：' .. ngx.now()*1000)

local ts=ngx.now()
ngx.say('http_time: '..ngx.http_time(ts))
ngx.say('cookie_time: '..ngx.cookie_time(ts))
ngx.say(ngx.parse_http_time('Sat, 29 Jul 2023 10:29:59 GMT'))

-- ngx.sleep(1.2)
-- ngx.sleep(0.3)
-- ngx.sleep(0.03)

-- 数据编码
    -- base64
    local url='https://www.luruoyang.com?name=luruoyang&age=26&phone=18336362709&addr=上海市松江区中山茸惠苑三期6号楼201室南次卧&type=apartmentt'
    -- local url_enc=ngx.encode_base64(url)
    local url_enc=ngx.encode_base64(url,false) -- 编码过程中使用"+" "/"，会导致url编码损坏，不适合http 
    ngx.say(url_enc) -->                            aHR0cHM6Ly93d3cubHVydW95YW5nLmNvbT9uYW1lPWx1cnVveWFuZyZhZ2U9MjYmcGhvbmU9MTgzMzYzNjI3MDkmYWRkcj3kuIrmtbfluILmnb7msZ/ljLrkuK3lsbHojLjmg6Doi5HkuInmnJ825Y+35qW8MjAx5a6k5Y2X5qyh5Y2n
    ngx.say(ngx.encode_args({url=url_enc})) --> url=aHR0cHM6Ly93d3cubHVydW95YW5nLmNvbT9uYW1lPWx1cnVveWFuZyZhZ2U9MjYmcGhvbmU9MTgzMzYzNjI3MDkmYWRkcj3kuIrmtbfluILmnb7msZ%2FljLrkuK3lsbHojLjmg6Doi5HkuInmnJ825Y%2B35qW8MjAx5a6k5Y2X5qyh5Y2n
    local tb=ngx.decode_args('url=aHR0cHM6Ly93d3cubHVydW95YW5nLmNvbT9uYW1lPWx1cnVveWFuZyZhZ2U9MjYmcGhvbmU9MTgzMzYzNjI3MDkmYWRkcj3kuIrmtbfluILmnb7msZ%2FljLrkuK3lsbHojLjmg6Doi5HkuInmnJ825Y%2B35qW8MjAx5a6k5Y2X5qyh5Y2n')
    ngx.say(tb.url) -->           aHR0cHM6Ly93d3cubHVydW95YW5nLmNvbT9uYW1lPWx1cnVveWFuZyZhZ2U9MjYmcGhvbmU9MTgzMzYzNjI3MDkmYWRkcj3kuIrmtbfluILmnb7msZ/ljLrkuK3lsbHojLjmg6Doi5HkuInmnJ825Y+35qW8MjAx5a6k5Y2X5qyh5Y2n

    local url_dec=ngx.decode_base64(url_enc)
    ngx.say(url_dec) --> https://www.luruoyang.com?name=luruoyang&age=26&phone=18336362709&addr=上海市松江区中山茸惠苑三期6号楼201室南次卧

    local b64=require 'ngx.base64'
    local ngx_encode64url=b64.encode_base64url
    local ngx_decode64url=b64.decode_base64url
    url_enc=ngx_encode64url(url,false)
    ngx.say(url_enc) --> aHR0cHM6Ly93d3cubHVydW95YW5nLmNvbT9uYW1lPWx1cnVveWFuZyZhZ2U9MjYmcGhvbmU9MTgzMzYzNjI3MDkmYWRkcj3kuIrmtbfluILmnb7msZ_ljLrkuK3lsbHojLjmg6Doi5HkuInmnJ825Y-35qW8MjAx5a6k5Y2X5qyh5Y2n
    url_dec=ngx_decode64url(url_enc)
    ngx.say(url_dec) --> https://www.luruoyang.com?name=luruoyang&age=26&phone=18336362709&addr=上海市松江区中山茸惠苑三期6号楼201室南次卧


    -- json
    local cjson=require 'cjson'
    local tbl={
        name='luruoyang',
        age=26,
        phone='18336362709',
        addr='上海市松江区中山茸惠苑三期6号楼201室南次卧',
    }
    local str=cjson.encode(tbl)
    ngx.say(str)

    ngx.say(type(cjson.decode(str)))
    for k,v in pairs(cjson.decode(str)) do
        ngx.say(k,': ',v)
    end

    -- 空对象将编码为数组
    cjson.encode_empty_table_as_object(false)
    ngx.say(cjson.encode({}))    --> []

    -- 空对象将编码为对象
    cjson.encode_empty_table_as_object(true)
    ngx.say(cjson.encode({a={},b=cjson.empty_array})) --> {"a":{},"b":[]}

    -- 精度设置为小数点后2位
    cjson.encode_number_precision(3)
    ngx.say(cjson.encode({x=math.pi}))


    -- MessagePack Protobuf thrift
    local mp=require 'resty.msgpack'
    local obj={a=1,b=2,x='star'}
    local enc=mp.pack(obj)
    ngx.say(enc) --> ��b�x�star�a
    ngx.say(type(mp.unpack(enc)))

    for k,v in pairs(mp.unpack(enc)) do
        ngx.say(k .. ': '..v)
    end

    local a='hello'
    local b={1,2,3}
    local c=2.718

    ngx.say('==================================')
    local data=mp.pack(a)..mp.pack(b)..mp.pack(c)
    ngx.say(data) -->

    for i,v in mp.unpacker(data) do
        ngx.say('offset ',i,' is ', v)
    end

-- 正则
-- 高速缓存 LRU cache
-- 


--[[ 
-- initing
-- running
-- exiting

initing
    configuration
    master-initing
    worker-initing

for every request:
    ssl
    preread
    rewrite
    access
    content
    filter
    log
]]
