#!/usr/bin/lua

function table_2_string(t)
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

-- print(table_2_string(os))
print(
    os.time(
        {
            year = 2019,
            month = 12,
            day = 1,
            hour = 12,
            min = 34,
            sec = 20
        }
    )
)
print(os.date('%Y/%M/%D %h%m%s',1575174860))
