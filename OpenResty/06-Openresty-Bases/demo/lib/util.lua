
local _M={}

function _M.TableToStr(t)
    if t == nil then return "" end
    local retstr= "{"

    local i = 1
    for key,value in pairs(t) do
        local signal = ","
        if i==1 then
          signal = ""
        end

        if key == i then
            retstr = retstr..signal..ToStringEx(value)
        else
            if type(key)=='number' or type(key) == 'string' then
                retstr = retstr..signal..'['..ToStringEx(key).."]="..ToStringEx(value)
            else
                if type(key)=='userdata' then
                    retstr = retstr..signal.."*s"..TableToStr(getmetatable(key)).."*e".."="..ToStringEx(value)
                else
                    retstr = retstr..signal..key.."="..ToStringEx(value)
                end
            end
        end

        i = i+1
    end

     retstr = retstr.."}"
     return retstr
end

function _M.table_2_string(t)
	local printed_table_cache = {}
	local result_string = ""
	local CRLF = '\n'
	local function table_2_string_core(t, indent) 
		if (printed_table_cache[tostring(t)]) then
            result_string = result_string..indent.."*"..tostring(t)..CRLF
        else
            printed_table_cache[tostring(t)]=true
            if (type(t)=="table") then
                for pos,val in pairs(t) do
                    if (type(val)=="table") then
                        result_string = result_string..indent.."["..pos.."] => "..tostring(t).." {"..CRLF
                        table_2_string_core(val,indent..string.rep(" ",string.len(pos)+8))
                        result_string = result_string..indent..string.rep(" ",string.len(pos)+6).."}"..CRLF
                    elseif (type(val)=="string") then
                        result_string = result_string..indent.."["..pos..'] => "'..val..'"'..CRLF
                    else
                        result_string = result_string..indent.."["..pos.."] => "..tostring(val)..CRLF
                    end
                end
            else
                result_string = result_string..indent..tostring(t)..CRLF
            end
        end
    end
    if (type(t)=="table") then
        result_string = result_string..tostring(t).." {"..CRLF
        table_2_string_core(t,"  ")
        result_string = result_string.."}"..CRLF
    else
        table_2_string_core(t,"  ")
    end
    result_string = result_string..CRLF
    return result_string
end

return _M