#!/usr/local/bin/lua

--[[ 循环

while 循环      在条件为 true 时，让程序重复地执行某些语句。执行语句前会先检查条件是否为 true。
for 循环	    重复执行指定语句，重复次数可在 for 语句中控制。
repeat...until  重复执行循环，直到 指定的条件为真时为止
循环嵌套        可以在循环内嵌套一个或多个循环语句（while do ... end;for ... do ... end;repeat ... until;）

循环控制语句
break 语句	退出当前循环或语句，并开始脚本执行紧接着的语句。
goto 语句	将程序的控制点转移到一个标签处。

无限循环（死循环）

]] -- while condition do
--     statements
-- end
-- a = 1
-- while (a < 10) do
--     print(a)
--     a = a + 1
-- end
-- 数值for循环 初始值，最终值，增量,for循环的这三个表达式在循环开始前一次性求值，以后不再进行求值。
-- for i = init_val, end_val, delta_val  do
--     statements
-- end
-- for i = 1, 10, 3 do
--     print(i)
-- end
-- function func(x)
--     print("function")
--     return x * 2
-- end
-- for i = 1, func(8), 1 do
--     print(i)
-- end
--[[    泛型for循环
    通过迭代器遍历
a = {"one", "two", "three"}
for i, v in ipairs(a) do
    print(i, v)
end

--]] --[[a = {"one", "two", "three"}
for i, v in ipairs(a) do
    print(i, v)
end
days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
for i, v in ipairs(days) do
    print(v)
end
]] --[[    repeat...until
repeat
   statements
until( condition )
--]] --[[ a = 10
repeat
    print(a)
    a = a + 1
until (a > 15) -- 直到条件判断语句（condition）为 true 才会停止执行。
--]] --[[ 嵌套循环
for init,max/min value, increment
do
   for init,max/min value, increment
   do
      statements
   end
   statements
end

while(condition)
do
   while(condition)
   do
      statements
   end
   statements
end

repeat
   statements
   repeat
      statements
   until( condition )
until( condition )

 j = 2
for i = 2, 10 do
    for j = 2, (i / j), 2 do
        if (not (i % j)) then
            break
        end
        if (j > (i / j)) then
            print("i的值为：", i)
        end
    end
end
--]] --[[ break
    退出本层循环，执行接下来的语句
 a = 10

while (a < 20) do
    print("a的值为", a)
    a = a + 1
    if (a > 16) then
        break
    end
end
print("执行代码")
--]] --[[ goto
::label::
goto label
-- ]] --  local a = 1
-- ::label::
-- print("--- goto label ---")
-- a = a + 1
-- if (a < 5) then
--     goto label
-- end
-- i = 0
-- ::s1::
-- do
--     print(i)
--     i = i + 1
-- end
-- if (i > 3) then
--     os.exit()
-- end
-- goto s1
-- 利用goto实现continue
for b = 1, 3 do
    if (b <= 2) then
        print(b, "yes continue")
        goto continue
    end
    print(b, "no continue")
    ::continue::
    print([[I'm end]])

end
