#!/usr/bin/lua
print("hi")
local creative={}
local function test(creative)
    creative.id=1
    creative.name="test"
    return creative
end
test(creative)
for k,v in pairs(creative) do
    print(k,": ",v)
end

conf={}
conf.SEND_LEVEL = {}
for i = 1, 10, 1 do
    -- _1, _2, _3
         table.insert(conf.SEND_LEVEL, '_' .. i)
       end

for k,v in pairs(conf.SEND_LEVEL)do
    print(k,": ",v)
end
