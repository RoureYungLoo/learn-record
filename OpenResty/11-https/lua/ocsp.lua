local OCSP = require "ngx.ocsp"
local ssl = require "ngx.ssl"
local http = require "ngx.http"

local function get_pem(file)
    local f = io.open(file, "r")
    if not f then
        return
    end

    local str = f:read("*a")
    f:close()

    return str
end
local prefix = ngx.config.prefix() .. "conf/ssl/"
local cert = get_pem(prefix .. "chrono.crt")

local der_cert, err = ssl.cert_perm_to_der(cert)
local ocsp_url, err = ocsp.get_ocsp_responder_from_der_chain()
local ocsp_req, err = ocsp.create_ocsp_request(der_cert)
local httpc = http.new()
local res, err =
    httpc:request_uri(
    ocsp_url,
    {
        method = "POST",
        body = ocsp_req,
        headers = {
            ["Content-Type"] = "application/ocsp-request"
        }
    }
)
local ocsp_resp = res.body
if ocsp_resp and #ocsp_resp > 0 then
    local ok, err = ocsp.validate_ocsp_response(ocsp_resp, der_cert)
    if not ok then
        ngx.log(ngx.ERR,"failed to validate ", err)
    end
end

local ok, err = ocsp.set_ocsp_status_resp(ocsp_resp)
if not ok then
    ngx.log(ngx.ERR, "failed to set ocsp status resp: ", err)
end
ngx.say("hi OCSP")
