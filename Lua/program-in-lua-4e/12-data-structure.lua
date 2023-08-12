#!/usr/bin/lua
-- 字符缓冲区
local buf=""
for line in io.lines() do
    buf=buf .. line .. "\n" --非常低效
end

local buff={}
for line in io.lines() do
    buff[#buff+1] = line .. "\n"
end
local str=table.concat(buff)

local buff2={}
for line in io.lines() do
    buff2[#buff2+1] = line
end
buff2[#buff2+1] = ""
local str2=table.concat(buff,"\n")

-- 图结构