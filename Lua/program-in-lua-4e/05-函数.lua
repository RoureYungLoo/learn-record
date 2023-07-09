#!/usr/bin/lua
---[[
print "hi"
print [[nihao]]
print (type [[123]])

function add(a)
    local sum=0
    for i=1,#a do
        sum=sum+a[i]
    end
    return sum
end
print(add({1,3,5,7,9}))

function inc(n)
    n=n or 1
    print("参数n的值：".. n)
end
inc()   --> 1
inc(3)  --> 3
-- ]]

---[[ 多返回值  多重赋值
tb={8,10,23,12,5}
function max(t)
    local mi=1
    local m=t[mi]
    for i = 1, #t do
        if t[i]>m then
            mi=i;
            m=t[i]
        end
    end
    return '最大值'..m,'下标为'..mi
end
print(max(tb))
-- ]]