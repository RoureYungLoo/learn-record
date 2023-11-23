#!/usr/local/bin/lua
-- 需要lua 5.3+
print(string.format ("%x",0xff & 0xabcd ))
print(string.format("%x", 0xff|0xabcd))
print(string.format('%x',0xaaaa ~ -1))
print(string.format('%x',~0))
print(string.format("%x",0xff <<12))
print(string.format("%x",0xff >>-12))
print(8>>3)
local x= 13835058055282163712
print(string.format("%u",x))
print(string.format("%X",x))

print(string.format("%u",x+1))
print(string.format("%u",x+2))

print(math.ult(0x7fffffffffffffff ,0x8000000000000000) )

s=string.pack('iii',3,-27,450)
print(s)
print(#s)
a,b,c=string.unpack('iii',s)
print(a,b,c)

s2='hello\0lua\0world'
local i=1
while i<=#s2 do
    local res
    res,i=string.unpack('z',s2,i)
    print(res)
end