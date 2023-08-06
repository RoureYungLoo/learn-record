ngx.req.set_header('Accept',"Firefox")
ngx.req.set_header('TESt',"test req header")
ngx.status=ngx.HTTP_NOT_FOUND

ngx.header['Server']='my openresty server'
ngx.header.new_field='xxx1'
-- ngx.header['new-field']='xxx2'
local ngx_resp=require'ngx.resp'
ngx_resp.add_header('New-Length',#'1323434')

ngx.send_headers()
-- ngx.say('test response')