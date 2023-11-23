#!/usr/bin/lua

function func()
    return 12,"ab"
end
print(type({func()}))