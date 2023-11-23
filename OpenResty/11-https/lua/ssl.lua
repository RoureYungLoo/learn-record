local ssl = require "ngx.ssl"
local util=require 'util'
ngx.log(ngx.ERR, "ssl_certificate_by_lua_file")

local certs = {
    ["www.chrono.com"] = {
        name = "chrono"
    },
    ["www.metroid.net"] = {
        name = "metroid"
    }
}

local function get_pem(file)
    local f = io.open(file, "r")
    if not f then
        return
    end
    local str = f:read("*a")
    f:close()
    return str
end

local function init_certs()
    local prefix = ngx.config.prefix() .. "conf/ssl/"
    for k, _ in pairs(certs) do
        local name = certs[k].name
        certs[k].cert = get_pem(prefix .. name .. ".crt")
        certs[k].key = get_pem(prefix .. name .. ".key")
    end
end
init_certs()
local name, err = ssl.server_name()
if not name then
    ngx.log(ngx.ERR, "no SNI found: ", err)
end
if not certs[name] then
    ngx.log(ngx.ERR, "not supported SNI")
end

local ok, err = ssl.clear_certs()
if ok then
    ngx.log(ngx.ERR, "证书清除")
end

ngx.log(ngx.ERR,util.table_2_string(certs))
local cert, err = ssl.parse_pem_cert(certs[name].cert)
if not cert then
    ngx.log(ngx.ERR, "failed: ", err)
end
local ok, err = ssl.set_cert(cert)
if not ok then
    ngx.log(ngx.ERR, "failed: ", err)
end

local key, err = ssl.parse_pem_priv_key(certs[name].key)
if not key then
    ngx.log(ngx.ERR, "failed to parse key: ", err)
end

local ok, err = ssl.set_priv_key(key)
if not ok then
    ngx.log(ngx.ERR, "failed to set key: ", err)
end
