#!/usr/bin/lua
function sort_score(_sort_list, item)  
    local function IsNeedFront(_l_item, _r_item)  
        if _l_item[item] < _r_item[item] then  
            return true  
        end  
        if _l_item[item] == _r_item[item] then  
            if util.randint(0, 1) == 0 then
            --if _l_item[other_item] >= _r_item[other_item] then  
                return true  
            end  
            return false  
        end  
        return false  
    end  
    local function DoSortScore(_t_item, _l, _r)  
        if _l < _r then  
            local mid_val = _t_item[_l]
            local i = _l  
            local j = _r  
            while i < j do  
                while i < j and IsNeedFront(_t_item[j], mid_val) do  
                    j = j - 1   
                end  
                if i < j then  
                    _t_item[i] = _t_item[j]  
                end  
  
                while i < j and IsNeedFront(mid_val, _t_item[i]) do  
                    i = i + 1   
                end  
                if i < j then  
                    _t_item[j] = _t_item[i]  
                end  
            end  
            _t_item[i] = mid_val  
            DoSortScore(_t_item, _l, i-1)  
            DoSortScore(_t_item, i+1, _r)  
        end  
    end  
    DoSortScore(_sort_list, 1, #_sort_list)  
end


        local second_price
	local resp={
		[1] = {price=20},
		[2] = {price=12},
		[3] = {price=36},
		[4] = {price=9},
		[5] = {price=22},
		[6] = {price=25}
	}
	sort_score(resp,'price')
	for i=1,#resp,1 do
		print(i,resp[i].price)	
	end
---[[
        for i=1,#resp-1,1 do
            local p1 = resp[i] and resp[i].price
            local p2 = resp[i+1] and resp[i+1].price

            if p1 > p2 then
                print("次高价：" .. p2)
                break
            end
        end
--]]
