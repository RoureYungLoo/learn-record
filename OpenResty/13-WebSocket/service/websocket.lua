-- ngx.say('hi')

local server=require'resty.websocket.server'

local wb,err=server.new{
    timeout=5000,
    max_payload_len=1024*64,
}
if not wb then
    ngx.log(ngx.ERR,'failed to init: ',err)
    ngx.exit(444)
end

local data,type,bytes,err
while true do
    data,type,err=wb:recv_frame()

    if not data then
        if not string.find(err,'timeout',1,true) then --忽略超时错误
            ngx.log(ngx.ERR,'failed to recv: ',err)
            ngx.exit(444)
        end
    end

    if type=="close" then
        bytes,err=wb:send_close()
        ngx.exit(0)
    end

    if type=="text" then
        bytes,err=wb:send_text('response data')
        ngx.log(ngx.ERR,'server recv text: ')
    end

    if type=="ping" then
        bytes,err=wb:send_pong()
    end
    ngx.log(ngx.ERR,'recv_frame()--data: ',data)
    ngx.log(ngx.ERR,'recv_frame()--type: ',type)
    ngx.log(ngx.ERR,'recv_frame()--err: ',err)

end