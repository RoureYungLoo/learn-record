local util = require "util"
ngx.say("hi")
-- 对称加密 DES AES TEA ChaCha
-- 非对称加密 RSA ECC DH
-- 数字签名
-- 数字证书 CA PEM  DER

--安全协议 SSL/TLS
-- TLS transport layer security
-- SSL secure sockets layer
-- HTTPS HTTP over SSL/TLS
-- SSL Handshake
-- SNI
-- OCSP
-- OCSP Stapling

local ssl = require "ngx.ssl"
ngx.say(type(ssl))
-- ngx.say(util.table_2_string(ssl))
if not ssl then
    ngx.say("require ssl failed")
end
local ver, err = ssl.get_tls1_version()
ngx.say(string.format("0x%x", ver))

local str, err = ssl.get_tls1_version_str()
ngx.say("ver: ", str)

local srv, err = ssl.server_name()
ngx.say("SNI: ", srv)

local byte = string.byte
local function addr_str(addr)
    return string.format("%d.%d.%d.%d", byte(addr, 1), byte(addr, 2), byte(addr, 3), byte(addr, 4))
end
local srv_addr, addr_type_srv, err = ssl.raw_server_addr()
local clt_addr, addr_type_clt, err = ssl.raw_client_addr()
ngx.say("srv: ", addr_str(srv_addr), " type: ", addr_type_srv)
ngx.say("clt: ", addr_str(clt_addr), " type: ", addr_type_clt)
