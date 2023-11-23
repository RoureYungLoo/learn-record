#!/usr/bin/lua


-- 广告类型
-- 0：banner，1：插屏，2：开屏，3：原生
 local adt_dict = {
    [0]  = 3,
    [1]  = 2,
    [2]  = 1,
    [3]  = 4,
    [14] = 5,
 }
 
local function get_adt_type(tag_info)
      return tag_info.adt and adt_dict[tag_info.adt]
end

-- print(get_adt_type({adt='2'}))
print(adt_dict['2'])
