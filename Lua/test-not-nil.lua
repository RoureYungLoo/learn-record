#!/usr/bin/lua

function test_func()
	local ads = {
		images = {
			-- {url = "https://www.test.com"},
			-- {url = "https://www.test.com"}
		}
	}
	if not ads.images or not ads.images[1] or not ads.images[1].url then
		return 'true'
	else
		return 'false'
	end
end

print(test_func())
