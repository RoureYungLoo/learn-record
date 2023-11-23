-- 集合
local Set = {}
local mt = {} --元表

function Set.new(list)
    local set = {}
    setmetatable(set, mt) --设置元表
    for _, v in ipairs(list) do
        set[v] = true
    end
    return set
end
-- 并集
function Set.union(a, b)
    local res = Set.new({})
    for k in pairs(a) do
        res[k] = true
    end
    for k in pairs(b) do
        res[k] = true
    end
    return res
end

--交集
function Set.intersection(a, b)
    local res = Set.new({})
    for k in pairs(a) do
        res[k] = b[k]
    end
    return res
end

--tostring
function Set.tostring(set)
    local list = {}
    for e in pairs(set) do
        list[#list + 1] = tostring(e)
    end
    return "{ " .. table.concat(list, ", ") .. " }"
end

-- 添加元方法

mt.__add = Set.union -- 并集
mt.__mul = Set.intersection --交集
mt.__le = function(a, b) --小于等于
    for k in pairs(a) do
        if not b[k] then
            return false
        end
    end
    return true
end

mt.__lt = function(a, b) -- 小于
    return a <= b and not (b <= a)
end

mt.__eq = function(a, b) --等于
    return a <= b and b <= a
end

mt.__tostring = Set.tostring

-- mt.__metatable="not your business"

-- mt.__pairs=function ()
--     -- 遍历
-- end
return Set
