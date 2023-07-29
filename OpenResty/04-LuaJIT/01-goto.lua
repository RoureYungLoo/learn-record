#!/usr/local/openresty/luajit/bin/luajit
-- #!/usr/local/openresty/bin/resty

print('ok')

--goto
for i = 1, 10, 1 do
    if i % 2 == 0 then
        goto continue
    end
    print('i= ', i)
    ::continue::
end

--jit

print(jit.version)
print(jit.version_num)
print(jit.os)
print(jit.arch)
print(jit.status)

--table
local table_new = require 'table.new'
local table_clear = require 'table.clear'
local table_clone = require 'table.clone'
local tb = table_new(10,0)
table_clear(tb)
tb2 = table_clone(tb) --浅拷贝

--bit
local bit = require 'bit'
local band, bor = bit.band, bit.bor
local bxor, bnot = bit.bxor, bit.bnot
local blshift = bit.lshift
local tohex = bit.tohex

local x,y=1,4
print(band(x,y))
print(bor(x,y))
print(bxor(x,y))
print(tohex(bnot(x)))
print(blshift(y,1))
print(bit.rol(x,3)) --按位左旋 '11'011011 ->  011011'11'
print(bit.ror(y,2)) --按位右旋
