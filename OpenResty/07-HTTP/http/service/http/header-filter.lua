if not ngx.header.etag then
    ngx.header.etag='etag'
end
ngx.header['Cache-Controll']='max-age=300'