#!/usr/local/bin/lua
-- finalizer

o = {x = "hi"}
setmetatable(
    o,
    {
        __gc = function(o)
            print(o.x)
        end
    }
)
o = nil
collectgarbage()

o = {x = "hi"}
mt = {__gc = true}
setmetatable(o, mt)
mt.__gc = function(o)
    print(o.x)
end
o=nil
collectgarbage()

mt={__gc=function (o)
    print(o[1])
end}
list=nil
for i=1,3 do
    list=setmetatable({i,link=list},mt)
end
list=nil
collectgarbage()

A={x="this is A"}
B={f=A}
setmetatable(B,{__gc=function (o)
    print(o.f.x)
end})
A,B=nil,nil --B的析构器访问了A，因此A在B析构前不能被回收
collectgarbage()

do
    local mt={__gc=function (o)
        print("new cycle")
        setmetatable({},getmetatable(o))
    end}
    setmetatable({},mt)
    collectgarbage()
    collectgarbage()
    collectgarbage()
end
print(collectgarbage("count"))