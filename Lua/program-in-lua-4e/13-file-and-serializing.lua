#!/usr/bin/lua
-- 数据文件


local count = 0
function Entry()
    count = count + 1
end
dofile("data")
print("count : ", count)

local authors = {}
function Entry(b)
    authors[b[1]] = true
end
dofile("data")
for name, _ in pairs(authors) do
    print(name)
end
--序列化 串行化 字节流 字符流

function serialize(o)
    if type(o) == "number" then
        io.write(tostring(o))
    end
end

local fmt = {
    interget = "%d",
    float = "%a"
}
function serialize2(o)
    if type(o) == "number" then
        io.write(string.format(fmt[math.type(o)], o))
    end
end

str = 'a "problematic" \\string'
print(string.format("%q", str))

function serialize3(o)
    if type(o) == "number" then
        io.write(string.format(fmt[math.type(o)], o))
    elseif type(o) == "string" then
        io.write(string.format("%q", o))
    end
end

function serialize4(o)
    local t = type(o)
    if t == "number" or t == "string" or t == "boolean" or t == "nil" then
        io.write(string.format("%q", o))
    end
end

function quote(s)
    local n = -1
    for w in string.gmatch(s, "]=*") do
        n = math.max(n, #w - 1)
    end

    local eq = string.rep("=", n + 1)
    return string.format(" [%s[\n%s]%s]", eq, s, eq)
end

print(quote([===[
    11111111111111111
    33333333333333
]===]))

--不使用循环序列化表
function serializetb(o)
    local t = type(o)
    if t == "number" or t == "string" or t == "boolean" or t == "nil" then
        -- io.write(string.format("%q", o))
        return string.format("%q", o)
    elseif t == "table" then
        io.write("{\n")
        for k, v in pairs(o) do
            -- io.write(" ",k," = ")
            io.write(string.format(" [%s] =", serializetb(k)))
            io.write(string.format(" %s", serializetb(v)))
            -- serializetb(v)
            io.write(",\n")
        end
        io.write("}\n")
    else
        error("cannot serialize a " .. type(o))
    end
end

-- serializetb(
--     {
--         a = 11,
--         b = 2
--     }
-- )
-- serializetb("key")

--保存带有循环的表
function basic_serilaize(o)
    return string.format( "%q",o )    
end

function save(name, value, saved)
    saved = saved or {}
    io.write(name, " = ")
    if type(value) == "number" or type(o) == "string" then
        io.write(basic_serilaize(value), "\n")
    elseif type(value) == "table" then
        if saved[value] then
            io.write(saved[value], "\n")
        else
            saved[value] = name
            io.write("{}\n")
            for k, v in pairs(value) do
                k = basic_serilaize(k)
                local fname = string.format("%s[%s]", name, k)
                save(fname, v, saved)
            end
        end
    else
        error("cannot save a " .. type(value))
    end
end
