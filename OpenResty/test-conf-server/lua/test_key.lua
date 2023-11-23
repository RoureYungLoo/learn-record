local pkcs7 = require "resty.nettle.padding.pkcs7"
local pycrypto_aes = require "pycrypto_aes"
-- aes加密
local function c_aes_encrypt(key, plain, safe)
    if not key or not plain then
        return
    end

    local aes = pycrypto_aes.new(key, pycrypto_aes.MODE_ECB)
    local cipher = aes:encrypt(plain)
    if safe then
        return util.url_safe_base64_encode(cipher)
    else
        return ngx_encode_base64(cipher)
    end
end

ngx.say("test key")
local KEY = "a6RwLkAp0dsQtUl6o8F4Gw"

local key = ngx.decode_base64(KEY)
ngx.say(key)

local ultimate_price = pkcs7.pad(tostring(10.5))
ngx.say(ultimate_price)
local en_price = c_aes_encrypt(key, ultimate_price)
ngx.say(en_price)
