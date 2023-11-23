#!/usr/bin/lua
tab = {}
if next(tab) then
    print('not {}')
else
    print('{}')
end

print(next(tab))