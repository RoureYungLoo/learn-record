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

-- POSIX模式匹配
-- Perl模式匹配
-- PCRE 正则库

--模式
local str="dead li%?ne is 30/0?5_/2023,firm"
date="%d%d/%d%d/%d%d%d%d"
-- print(string.match(str,"%w_"))
-- local newstr, novw=string.gsub(str,"[AEIOUaeiou]","")
-- print(novw)
-- print(str)
-- print(newstr)
local str="dead li%?ne is 30/0?5_/2023,firm"
print(string.match(str,"[0-9]+"))

print((string.gsub("one, and two; and three","%a+","word")))
local iter=string.gmatch("dead li%?ne is 30456/0?5_/2023,firm","%d+")
print(iter())
print(iter())
print(iter())
print(iter())
local str="this is a ( ) test."
print(string.match(str,"%(%s*%)"))--'(' 需要转义 ')'需要转义
local str="var_a _M __VERSION"
local iter=string.gmatch(str,"[_%a][_%w]*")
print(iter())
print(iter())
print(iter())

local s="a (enclosed (in) pare[nth]eses) line"
-- subs=string.match(s,"%b()")
-- print(subs)
-- print(string.match(subs,"%b()"))

print((string.gsub(s,"%b[]","")))
local pair="name = Anna"
local key,value=string.match(pair,"(%a+)%s*=%s*(%a+)")
print(key,value)
local date="Today is 23/7/2023"
local d,m,y=string.match(date,"(%d+)/(%d+)/(%d+)")
print(d,m,y)