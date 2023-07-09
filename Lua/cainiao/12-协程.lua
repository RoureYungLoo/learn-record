#!/usr/local/bin/lua

-- 协程与线程的区别
-- 一个具有多个线程的程序可以同时运行几个线程，而协同程序却需要彼此协作的运行。
-- 在任一指定时刻只有一个协同程序在运行，并且这个正在运行的协同程序只有在明确
-- 的被要求挂起的时候才会被挂起。

-- 基本方法
-- coroutine.create()	创建 coroutine，返回 coroutine， 参数是一个函数，当和 resume 配合使用的时候就唤醒函数调用
-- coroutine.resume()	重启 coroutine，和 create 配合使用
-- coroutine.yield()	挂起 coroutine，将 coroutine 设置为挂起状态，这个和 resume 配合使用能有很多有用的效果
-- coroutine.status()	查看 coroutine 的状态
-- 注：coroutine 的状态有三种：dead，suspended，running，具体什么时候有这样的状态请参考下面的程序
-- coroutine.wrap（）	创建 coroutine，返回一个函数，一旦你调用这个函数，就进入 coroutine，和 create 功能重复
-- coroutine.running()	返回正在跑的 coroutine，一个 coroutine 就是一个线程，当使用running的时候，就是返回一个 coroutine 的线程号

-- co=coroutine.create(
--     function(i)
--         print(i)
--     end
-- )

-- coroutine.resume(co,1)
-- status=coroutine.status(co)
-- print(status)

-- co2=coroutine.wrap(
--     function(i)
--         print(i)
--     end
-- )
-- co2(2)

-- co3=coroutine.create(
--     function()
--         for i=1,10 do
--             print(i)
--             if i==5 then
--                 print(coroutine.status(co3))
--                 print(coroutine.running())
--                 coroutine.yield()
--             end
            
--         end
--     end
-- )

-- coroutine.resume(co3)
-- print(coroutine.status(co3))
-- print(coroutine.running())


function foo(a)
    print("foo output: ",a)
    return coroutine.yield(2*a)
end

co=coroutine.create(
    function(a,b)
        print("output one: ",a,b)
        local r=foo(a+1)

        print("output two: ",r)
        local r,s=coroutine.yield(a+b,a-b)

        print("output three: ",r,s)
        return b,"结束协程"
    end
)

print("main",coroutine.resume(co,1,10))
print("-------")
print("main",coroutine.resume(co,"r"))
print("-------")
print("main",coroutine.resume(co,"x","y"))
print("-------")
print("main",coroutine.resume(co,"x","y"))
print("-------")


