local Util=require 'util'

-- 系统信息




ngx.say('hi')
ngx.say(ngx.config.debug)
ngx.say(ngx.config.prefix())
ngx.say(ngx.config.nginx_version)
ngx.say(ngx.config.nginx_configure())
ngx.say(ngx.config.subsystem)
ngx.say(ngx.config.ngx_lua_version)

-- 运行日志
ngx.log(ngx.STDERR, "日志级别 STDERR") -- ??
ngx.log(ngx.EMERG, "日志级别 EMERG")
ngx.log(ngx.ALERT, "日志级别 ALERT")
ngx.log(ngx.CRIT, "日志级别 CRIT")
ngx.log(ngx.ERR, "日志级别 ERR")
ngx.log(ngx.WARN, "日志级别 WARN")
ngx.log(ngx.NOTICE, "日志级别 NOTICE")
ngx.log(ngx.INFO, "日志级别 INFO")

-- 时间日期
ngx.say(ngx.today())
ngx.say(ngx.localtime())
ngx.say(ngx.utctime())

-- 时间戳
ngx.say('时间戳：' .. ngx.time())
ngx.update_time() -- 更新时间
ngx.say('时间戳毫秒：' .. ngx.now() * 1000)

local ts = ngx.now()
ngx.say('http_time: ' .. ngx.http_time(ts))
ngx.say('cookie_time: ' .. ngx.cookie_time(ts))
ngx.say(ngx.parse_http_time('Sat, 29 Jul 2023 10:29:59 GMT'))

-- ngx.sleep(1.2)
-- ngx.sleep(0.3)
-- ngx.sleep(0.03)

--[[ 数据编码
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
    -- ngx.say(enc) --> ��b�x�star�a
    ngx.say(type(mp.unpack(enc)))

    for k,v in pairs(mp.unpack(enc)) do
        -- ngx.say(k .. ': '..v)
    end

    local a='hello'
    local b={1,2,3}
    local c=2.718

    ngx.say('==================================')
    local data=mp.pack(a)..mp.pack(b)..mp.pack(c)
    -- ngx.say(data) -->

    for i,v in mp.unpacker(data) do
        ngx.say('offset ',i,' is ', v)
    end
--]]
-- 正则表达式 【pcre】
-- -jo 编译并缓存
-- 正则单次匹配  ngx.re.match
local str = 'abcd-123'
local m = ngx.re.match(str, [[\d{3}]], "jo")
local cjson = require("cjson");
local encode = cjson.encode
ngx.say(cjson.encode(m)) -- > {"0":"123"}
ngx.say(cjson.encode(ngx.re.match(str, "(.*)123$", "jo"))) -- > {"0":"abcd-123","1":"abcd-"}
ngx.say(cjson.encode(ngx.re.match(str, "[a-z]+", "jo"))) -- > {"0":"abcd"}

local ctx = {
    pos = 7 --> 从位置7开始查找
}
ngx.say(encode(ngx.re.match(str,"[0-9]","",ctx)))
ngx.say(ctx.pos)
--> 复用查找结果表
local tab_clear=require "table.clear"
tab_clear(m)
ctx.pos=1

ngx.re.match(str,"(.*)-(.*)$","",ctx,m)
ngx.say(encode(m))

-- 正则多次匹配  ngx.re.gmatch
local str="127.0.0.1,123,456,789"
local iter,err=ngx.re.gmatch(str,[[([0-9\.]+),?]],"ijo")
if iter then
    while true do
        local m,err=iter()
        if not m or err  then
            break
        end
        ngx.say(encode(m))
    end
else
    ngx.say("iter is nil")
end

--正则查找 ngx.re.find
local str = 'abcd-123'
local str="127.0.0.1,123,456,123,789"
-- local found,last,err=ngx.re.find(str,"123","jo")
local found,last,err=ngx.re.find(str,[[(\d)(\d+)()]],"",nil,3) 
-- local found,last,err=ngx.re.find(str,"123","",nil,1)
ngx.say(found,', ',last,', ',err)
-- 指定返回第几个子模式串的起始位置和结束位置的索引值，默认值是0，此时将会返回匹配的整个字串；如果nth等于1，那么将返回第一个子模式串的始末位置的索引值；如果nth等于2，那么将返回第二个子模式串的始末位置的索引值，依次类推。如果nth指定的子模式没有匹配成功，那么将会返回两个nil。

--正则替换 ngx.re.sub  ngx.re.gsub 
local str="abcd-123"
local newstr=ngx.re.sub(str,'ab','AB')
ngx.say(newstr)

local rules=[[(\w+)-(\d+)]] -- 子模式$1 $2
newstr=ngx.re.sub(str,rules,"($1)($2)($1)")
-- newstr=ngx.re.sub(str,rules,"($1)($2)($1)($$)")
ngx.say(newstr)

local function func( m )
    return '**' .. m[0] .. '**'
end
local newstr3=ngx.re.sub(str,[[\d+]],func)
ngx.say(newstr3)

local str4=ngx.re.gsub(str,"[a-z]{2}",'xyz')
local str5=ngx.re.gsub(str,[[\w+]],function(m) return '('..m[0]..')'end)
ngx.say(str4)
ngx.say(str5)

-- 正则切分
local ngx_re=require("ngx.re")
local ngx_re_split=ngx_re.split
local str='a,b,c,d'
local res=ngx_re_split(str,',')
local res2=ngx_re_split(str,',',nil,nil,2)
ngx.say(Util.table_2_string(res))
ngx.say(Util.table_2_string(res2))

-- 高速缓存 LRU cache
local lrucache=require'resty.lrucache'
local urls, err = lrucache.new(100)
package.loaded.urls=urls

urls:set("baidu","https://www.baidu.com",0.1)
urls:set("google","https://www.google.com",5)
urls:set('table',{a=1,b=2},3)

local s1=urls:get('baidu')
local s2=urls:get('google')
ngx.say(s1,',',s2)
ngx.sleep(0.15)
local s3,stale=urls:get('baidu')
ngx.say(s3,',',stale)

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
--]]
