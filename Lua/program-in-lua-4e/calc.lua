-- local _M = {}
-- add = function(a, b)
--     return a + b
-- end

-- div = function(a, b)
--     return a / b
-- end
-- mul = function(a, b)
--     return a * b
-- end
-- sub = function(a, b)
--     return a - b
-- end

-- _M.VER=1.0
-- _M.add = add
-- _M.div = div
-- _M.mul = mul
-- _M.sub = sub

-- return _M

-- =========================
local add = function(a, b)
    return a + b
end

local div = function(a, b)
    return a / b
end
local mul = function(a, b)
    return a * b
end
local sub = function(a, b)
    return a - b
end

return {
    jia = add,
    jian = sub,
    cheng = mul,
    chu = div,

    VER=1.1
}
