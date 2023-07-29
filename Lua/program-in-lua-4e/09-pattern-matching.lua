#!/usr/bin/lua
-- 模式匹配函数 find、sub、match、gmatch
---[[ string.find
local str="Hello World!"
local start,final=string.find( str,"llo" )
print(start,final)
local sub_str=string.sub( str, 7,11 )
print (sub_str)
print(string.match( str,"ello" ))
day="today is 17/7/2023"
print(string.match( day,"%d+/%d+/%d+"))
print(string.gsub( str,"o","O",1 ))
print(string.gsub( str,"o","O",2 ))
print(string.gsub( str,"o",function() return "00" end,1 ))
-- print(string.gsub( str,"o",{000},1 )) ???
s="some string"
words={}
for w in string.gmatch( s,"%a+" )do
    words[#words+1]=w
end
print(words)

-- ]]
