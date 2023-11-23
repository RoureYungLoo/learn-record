#!/usr/bin/lua
-- 字符缓冲区
local buf=""
for line in io.lines() do
    buf=buf .. line .. "\n" --非常低效
end

local buff={}
for line in io.lines() do
    buff[#buff+1] = line .. "\n"
end
local str=table.concat(buff)

local buff2={}
for line in io.lines() do
    buff2[#buff2+1] = line
end
buff2[#buff2+1] = ""
local str2=table.concat(buff,"\n")

-- 图结构
#!/usr/local/bin/lua
local function table_2_string(t)
    local printed_table_cache = {}
    local result_string = ""
    local CRLF = "\n"
    local function table_2_string_core(t, indent)
        if (printed_table_cache[tostring(t)]) then
            -- result_string = result_string..indent.."*"..tostring(t)..CRLF
            result_string = result_string .. "*" .. tostring(t) .. CRLF
        else
            printed_table_cache[tostring(t)] = true
            if (type(t) == "table") then
                for pos, val in pairs(t) do
                    if (type(val) == "table") then
                        -- result_string = result_string..indent.."["..pos.."] = "..tostring(t).." {"..CRLF
                        result_string = result_string .. indent .. "[" .. pos .. "] = " .. " {" .. CRLF
                        table_2_string_core(val, indent .. string.rep(" ", string.len(pos) + 8))
                        result_string = result_string .. indent .. string.rep(" ", string.len(pos) + 6) .. "}" .. CRLF
                    elseif (type(val) == "string") then
                        result_string = result_string .. indent .. "[" .. pos .. '] = "' .. val .. '"' .. CRLF
                    else
                        result_string = result_string .. indent .. "[" .. pos .. "] = " .. tostring(val) .. CRLF
                    end
                end
            else
                result_string = result_string .. indent .. tostring(t) .. CRLF
            end
        end
    end
    if (type(t) == "table") then
        -- result_string = result_string..tostring(t).." {"..CRLF
        result_string = " {" .. CRLF
        table_2_string_core(t, "  ")
        result_string = result_string .. "}" .. CRLF
    else
        table_2_string_core(t, "  ")
    end
    result_string = result_string .. CRLF
    return result_string
end
local arr = {}
for i = -100, 100, 1 do
    arr[i] = 0
end
print(#arr)

local squares = {1, 4, 9, 16, 25, 36, 49, 64, 81}

local function gen_matrix(m, n)
    local metrix = {}
    for i = 1, m do
        local row = {}
        metrix[i] = row
        for j = 1, n do
            row[j] = 0
        end
    end
    return metrix
end

print(table_2_string(gen_matrix(3, 3)))

local list = {}

list = {next = list, value = "one"}
list = {next = list, value = "two"}
list = {next = list, value = "three"}
list = {next = list, value = "four"}
list = {next = list, value = "five"}

print(table_2_string(list))

while list do
    print(list.value)
    list = list.next
end

function list_new()
    return {first = 0, last = -1}
end

function push_first(list, value)
    local first = list.first - 1
    list.first = first
    list[first] = value
end

function push_last(list, value)
    local last = list.last + 1
    list.last = last
    list[last] = value
end

function pop_first(list)
    local first = list.first
    if first > list.last then
        error("list is empty")
    end
    local value = list[first]
    list[first] = nil
    list.first = first + 1
    return value
end

function pop_last(list)
    local last = list.last
    if list.first > last then
        error("list is empty")
    end
    local value = list[last]
    list[last] = nil
    list.last = last - 1
    return value
end

local alist = list_new()
push_first(alist, "1")
push_first(alist, "2")
push_first(alist, "3")
push_last(alist, "4")
push_last(alist, "5")
push_last(alist, "6")

print(table_2_string(alist))

days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
revDay = {
    Sunday = 1,
    Monday = 2,
    Tuesday = 3,
    Wednesday = 4,
    Thursday = 5,
    Friday = 6,
    Saturday = 7
}

revDay2 = {}

for key, value in pairs(days) do
    revDay2[value] = key
end
print(table_2_string(revDay2))
print(revDay["Tuesday"])

-- 生成一个保留字table
function set(list)
    local set = {}
    for _, l in ipairs(list) do
        set[l] = true
    end
    return set
end
reserved = {
    ["while"] = true,
    ["if"] = true,
    ["else"] = true,
    ["do"] = true
}
reserved2 = set({"end", "goto", "local", "function", "until","do","else"})
    local keys_reserved={}
s = "whle si do else fro tes "
for w in string.gmatch(s, "[%a_][%w_]*") do
    if not reserved2[w] then
        print(w, " 不是保留字")
    else
        print(w," 是关键字")
        keys_reserved[w]=true
    end
end

print(table_2_string(reserved2))
print(table_2_string(keys_reserved))
