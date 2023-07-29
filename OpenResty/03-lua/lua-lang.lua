#!/usr/bin/lua
-- #!/usr/local/openresty/bin/resty


interpreter = [[/usr/local/openresty/bin/resty]]
print("lua table、closure、coroutine")

-- print('单行注释')
print('单行注释')

--[[
    print('多行注释')
]]
---[[
print('外层多行注释')
---[=[
print('内层多行注释')
---[==[
print('==')
--]==]
-- ]=]
--]]

print('123456\t789')
print("123456\t789")
print([[
 123456\t789
    ]])

global_var = 123
local var = 456
do
    var_a = 789 --这里声明的变量没有使用"local"限定，所以是全局变量
    local var_b = 'abc'
end
print(global_var)
print(var)
print(var_a)
print(var_b)

--[[
    取模    %
    幂运算  ^
    不等于  ~=
    与      and 返回第一个不为真的变量的值
    或      or  返回第一个不为假的变量的值
    非      not
]]

--[[
    nil     假
    false   假
    数字0是 真
]]
print(1 and false and 3 and 4 and 5)
print(1 or 2 or 3 or 4 or 5)
print(nil and false and 3 and 4 and 5)
print(nil or false or 3 or 4 or 5)
print(1 and 2 and 3 and nil and 5)

--字符串连接 ..
--字符串长度 #
print('1+2=' .. 3)
print(#'1+2=' .. 3) --【#】优先级高于【..】
print(#('1+2=' .. 3))

--给默认值 or ''

--语句块
do
    --一些语句
end

--赋值 多重赋值 多余的变量会被赋值为nil，多余的值会被丢弃
a, b, c = 1, 2       --c=nil
m, n, q = 1, 2, 3, 4 --4被丢弃

--删除变量
var = nil

--分支语句
if cond or 1 then
    print('if then end')
end

if cond or 1 then
    print('if then else end')
else
    --...
end

if cond or 1 then
    print('if then elseif then end')
elseif cond or 1 then
    --...
else
    --...
end

-- 循环语句
while cond do
    --...
end

start = 1; last = 10; step = 1
for i = start, last, step do
    print('for i')
end

t = { [1] = 1 }
for key, value in pairs(t) do
    print('key' .. key .. 'value' .. value)
end

for index, value in ipairs(t) do
    print('key' .. 'value' .. value)
end

i = 1
repeat
    print('repeat')
until i < 4 --cond  --cond条件为假则退出循环

--lua不支持continue语句
--openresty中的luajit支持goto语句，可以结合goto语句实现continue



-- goto exitt

--  ::exitt::
print('exitt')

--function  必须先定义，才能使用，不存在"前向声明"
func1 = function(param)
    print(param)
end
func1(1)

function func2(param)
    print(param)
end

func2(2)

--[[
local func1=function (param)
    print(param)
end
func1(1)

local function func2(param)
    print(param)
end
func2(2)
--]]

--参数和返回值 除了表，其余都是值传递
print '字符串'
print '表'

--表 key可以是任何非nil的值，value的类型无限制
tab = { one = 1, ['two'] = 2, [{ ni = 'you', ta = 'he' }] = 3, [4] = 4, [true] = 'true', [func1] = 'func1' }

--访问表 tab[key]  key为字符串时可以使用tab.key
--#tab  返回数组tab的元素个数   #dict会返回0 ！！！！
print(tab[true])

table_array = { 1, 2, 3 }
for i, v in ipairs(table_array) do
    print(i, v)
end

table_any = tab
for k, v in pairs(table_any) do
    print(type(k), type(v))
end

--table作为函数参数时是引用传参
function my_print_tab(tab)
    tab.name = 'bob'
    print(tab.name)
end

tab = { ['name'] = 'tom' }
my_print_tab { ['name'] = 'tom' }
--函数调用特殊形式
function func_name(args)
    print('函数调用特殊形式')
end

func_name ''
func_name ""
func_name [[f;dfja]]
func_name { 1, 2, 3, { 2, 3 } }

--模块
local csjon = require 'cjson'
local str = csjon.encode({ a = 1, b = 2 })
print(str)

calc = require 'calc'
print(calc.add(1, 3))

--面向对象
-- local obj = {}
-- obj.name = 'name'
-- obj.go = function()
--     print('go()')
-- end
-- print(obj.name)
-- obj.go()

--原型模式 prototype
local proto = {} --类似于基类、父类
proto.name = 'prototype go'
proto.go = function()
    print('proto.go(): go somewhere')
end

local metatable = {
    __index = proto
}

--{age = 21,f_gender = function()print('我是男生')end} 类似于添加的新属性、新方法
-- obj类似于派生类、子类
local obj = setmetatable({ age = 21, f_gender = function() print('我是男生') end }, metatable)
-- local obj=setmetatable({},metatable)
obj.go()
print(obj.name)
print(obj.age)
obj.f_gender()

--原型模式 继承简化
proto.new = function(attr)
    return setmetatable({ test = 'test', att = attr }, metatable) --{test='test',att=attr} 是新增属性和方法
end

local obj2 = proto.new('attr')
print(obj2.test)
print(obj2.att)

--self 语法糖
local obj = {
    name = 'obj',
    hi = function(self, args)
        print('hi ', self.name, args)
    end
}
obj.hi('nihao')
obj.hi(obj, 'args')
obj:hi('yufatang')

--lua 标准库
-- base
-- package
-- string
-- table
-- math
-- io
-- os
-- debug

--base
print(123)
print(type(123))
print(type(ipairs({ 1, 2, 3 })))
print(type(pairs({ 1, 2, 3 })))

assert(2 == 1 + 1, 'er ror')
-- error('错误')

collectgarbage("collect")
print(collectgarbage("count"))
local raw_f = [[
    local x =  123
    return x
]]
local f = loadstring(raw_f)
print(f())

--package
print(package.path)
print(package.cpath)
f1 = [[
    print('come ')
]]
f2 = [[
    print('COME ')
]]

package.loaded.come = loadstring(f1) --热装载
local come = require 'come'
come()

package.loaded.come = loadstring(f2)
local come = require 'come'
come()

package.loaded.shared = { --存一些进程共享数据
    COUNT = 1,
    SIZE = 1024
}
local sh = require 'shared'
print(sh.COUNT)
print(sh.SIZE)

--string
s = 'This IS a FiLe FoR TesT.'
print(string.upper(s))
print(string.lower(s))
print(string.sub(s, 4, 9))
print(string.byte(s, 5, 8))
print(string.char(96, 97, 98, 99, 100))
print(string.format('%04d %+08.3f', 12, 12.34))

--table
tb = { 1, 2 }
table.insert(tb, 2, 3)
table.insert(tb, 4) --默认尾插法插入
tb[#tb + 1] = 5     --更高效
table.remove(tb)    --默认尾删法
table.remove(tb, 1)
-- tb[2]=nil --会导致空洞
print(csjon.encode(tb))
table.sort(tb, function(a, b) return a > b end)
print(table.concat(tb, '-')) --遇到空洞会停止concatenate

--math
print(math.floor(4.5))
print(math.ceil(4.5))
print(math.max(1, 2, 3))
print(math.min(1, 2, 3))
print(math.randomseed(os.time()))
print(math.random(1, 100))

--io 阻塞操作
local filename = tostring(1690612218) .. '.txt'
local f = io.open(filename, 'w')
f:write(os.time())
f:close()
f = io.open(filename, 'r')
print(f:read("*a"))
f:close()

local f = io.popen("ps -ef |grep vscode | wc -l")
print(f:read())
f:close()

local tmp = io.tmpfile() --注意文件指针的位置
tmp:write(123)
tmp:flush()
tmp:seek("set")
print(tmp:read())
tmp:close()

--os
local file = os.time() .. '.txt'
local filenew = os.time() .. '.txt' .. '.new'

local SHELL = 'touch ' .. file
os.execute(SHELL)
os.rename(file, filenew)
os.remove(filenew)
print(os.date('%Y年%m月%d日 %H时%M分%S秒', os.time()))


function func4()
    local a = 6
    print(debug.traceback('调试信息'))
end

function func3()
    func4()
end

function func2()
    func3()
end

function func1()
    func2()
end

func1()
--闭包 【lamda表达式】
function couter()
    local value = 0
    return function ()
        value = value + 1
        print(value)
        return value
    end
end

local addor1 = couter()
local addor2 = couter()
addor1()    --> 1
addor1()    --> 2
addor1()    --> 3
addor2()    --> 1
addor2()    --> 2
addor2()    --> 3

--保护调用pcall xpcall
-- local ok,err=pcall(func,args,...)
-- local ok,err=xpcall(func,traceback,args,...)

print()
--可变参数  selcet(n,...)   select('#',...)
function test(...)
    local args={...}
    print(select(3,...))
    print(#args)
    for index, value in ipairs(args) do
        print(index,': ',value)
    end
end
test(1,2,3,4,{1,2})

-- print(table.pack(1,2,3,4,5)) --Lua version >=5.2
local x={1,2,3,4}
print(unpack(x))

