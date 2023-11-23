#!/usr/bin/lua

function test_next()
    local tbl={nil,nil,nil,30,40,nil,nil,70,80}
    print(next(tbl,5))

end


test_next()
