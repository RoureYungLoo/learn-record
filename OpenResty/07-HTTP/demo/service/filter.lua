if ngx.status~=ngx.HTTP_OK then
    return
end

if ngx.ctx.encode then
    ngx.arg[1]=ngx.encode_base64(ngx.arg[1])
end