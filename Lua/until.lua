#!/usr/bin/lua
    local i = 1
    repeat
        print('callback')
        i = i + 1
    until ok or i >= 3
