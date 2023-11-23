#!/usr/bin/lua

-- http://xxx.com/track/click?
-- response_validate=false&imei=__IMEI__&oaid=__OAID__&click_time=__TS__&app_id=__APPID__&adid=__ADID__
-- &campaign_id=__CAMPAIGNID__&callback=__CALLBACK__&sign=__SIGN__&ua=__UA__&ip=__IP__&adName=__ADNAME__
-- 亿米请求参数

local secret_key = 'DktzASwZOnzjBmqV'
local xiaomi_req_param_tab={
    response_validate=false,
    imei='',
    oaid='',
    click_time='',
    app_id='',
    adid='',
    campaign_id='',
    callback='',
    sign='',
    ua='',
    ip='',
    adName='',
}
local function gen_sign()
    
end

-- urlencode
-- response_validate=false&imei=000004e0ef192bf1e709490ebeed6202&click_time=1527596459822&app_id=2&adid=100183020&callback=FtivxV8WpgIYJDM4MTE1NjYzLTgyMWItNDI3Ni1hNmM4LWYyNjQ1NzVlODczYxggMDAwMDA0ZTBlZjE5MmJmMWU3MDk0OTBlYmVlZDYyMDJIEDAzYTk4ZGNmZTVhODQ2NzYYBUNMSUNLAA%3D%3D&ua=Dalvik%2F2.1.0%2B%28Linux%3B%2BU%3B%2BAndroid%2B9%3B%2BRedmi%2BNote%2B8%2BPro%2BMIUI%2FV11.0.6.0.PGGCNXM%29&ip=127.0.0.1
-- secret_key = 'DktzASwZOnzjBmqV'
local sign=ngx.md5(urlencode .. secret_key);


-- =====================================================
-- http://trail.e.mi.com/api/callback?callback={callback_param}&imei={imei}&oaid={oaid}&convType={convType}&conv_time={conv_time}&sign={sign}

-- 回调参数,发给亿米
tb={
    callback='',
    imei='',
    oaid='',
    convType='',
    conv_time='',
    sign='',
}
local function gen_sign()
    
end

    -- local extdata={
    --     oaid            = "12a7f9dec57adda4",
    --     callback        = "FqK3xF8WvgkYJGU4NDJkNjQwLWI2MzMtNDMxYS1hNTA0LTcyNDVhNWEyMDE2YlgQMTJhN2Y5ZGVjNTdhZGRhNBgFQ0xJQ0sA",
    --     conv_time       = "1635335972760",
    -- }

    local raw_sign= "0813f3cbb7f549b21ab7a7607d66b2c6"
    local sign = ngx.md5(ngx.encode_args(extdata)..secret_key)
    -- local sign = ngx.md5("callback=FqK3xF8WvgkYJGU4NDJkNjQwLWI2MzMtNDMxYS1hNTA0LTcyNDVhNWEyMDE2YlgQMTJhN2Y5ZGVjNTdhZGRhNBgFQ0xJQ0sA&oaid=12a7f9dec57adda4&conv_time=1635335972760oSLAkvLAAmeebUdi")
    ngx.log(ngx.ERR,"sign: ",sign)




































local tb={
    key1=1,
    key2=2,
    key3=3,
    key4=4
}

for key, value in pairs(tb) do
    if key=='key3' then
        tb[key] =nil
    end
end

for key, value in pairs(tb) do
    print(key .. ':' .. value)
end