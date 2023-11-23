#!/usr/bin/lua

-- redis

function split(s, sep, n)
    if type(s) ~= 'string' then return {} end

    local len_sep = #sep
    if stringy and len_sep == 1 then
        return stringy.split(s, sep)
    end

    if sep == '' then
        return {s}
    end
    n = n or huge
    local t, c, p1, p2 = {}, 1, 1, nil
    while true do
        p2 = s:find(sep, p1, true)
        if p2 and c <= n then 
            t[#t+1] = s:sub(p1, p2-1)
            p1 = p2 + len_sep
            c = c + 1
        else
            t[#t+1] = s:sub(p1)
            return t
        end
    end  
end

str="1234|2143"

print(split(str,"|"))