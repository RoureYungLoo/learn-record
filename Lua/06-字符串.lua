#!/usr/local/bin/lua

--[[    字符串
单引号间的一串字符。
双引号间的一串字符。
双方括号间的一串字符。
--]] --[[string1 = "Lua"
string2 = "www.baidu.com"
string3 = [[luazifc]] -- print("\"字符串1是\"", string1)
-- print("\'字符串2是\'", string2)
-- print("字符串3是", string3)
-- ]]
--[[    转义字符
\a      响铃(BEL)                          007
\b      退格(BS) ，将当前位置移到前一列      008
\f      换页(FF)，将当前位置移到下页开头     012
\n      换行(LF) ，将当前位置移到下一行开头     010
\r      回车(CR) ，将当前位置移到本行开头       013
\t      水平制表(HT) （跳到下一个TAB位置）      009
\v      垂直制表(VT)        011
\\      代表一个反斜线字符''\'      092
\'      代表一个单引号（撇号）字符      039
\"      代表一个双引号字符      034
\0      空字符(NULL)        000     
\ddd    1到3位八进制数所代表的任意字符      三位八进制
\xhh    1到2位十六进制所代表的任意字符      二位十六进制    

字符串操作
upper()
lower()
gsub(src,objsub,rep,times) 用rep替换src字符串中的objsub times次
find()
reverse()
format()
char()
byte()
len()
rep()
..
gmatch()
match()

--]] --[[
str = "heLLo WoRLd"
print(string.upper(str))
print(string.lower(str))
print(string.gsub(str, 'o', 'q'))
print(string.find(str, "LLo", 1))
print(string.reverse(str))
print(string.format("%d ", 4))
print(string.char(97, 98, 99, 100))
print(string.byte("abcd", 4))
print(string.len(str))
print(string.rep(str, 3))
print("hello" .. "world")
-- ]] --[[
-- 返回一个迭代器函数，每一次调用这个函数，返回一个在字符串 str 找到的下一个符合
-- pattern 描述的子串。如果参数 pattern 描述的字符串没有找到，迭代函数返回nil。
-- %a+，a表示接受一个字母，+表示可以接受多个字母，就是接受单词的意思
str = "Hello 1 Lua User"
for word in string.gmatch(str, "%a+") do
    print(word)
end

print(string.match(str, "%d+ %a+"))
-- ]] --[[    字符串截取
string.sub()
--]] --[[
local str = "gitrepos-programming-exercise-record-Lua"
local sub1 = string.sub(str, 4, 15)
local sub2 = string.sub(str, 1, 8)
local sub3 = string.sub(str, -12)
local sub4 = string.sub(str, -100) ---- 索引越界，输出原始字符串
print(sub1)
print(sub2)
print(sub3)
print(sub4)
-- ]] -- 大小写转换 略
-- 查找和反转
--[[
str = "gitrepos-programming-exercise-record-Lua"
print(string.find(str, "pro"))
print(string.reverse(str))
-- ]] --[[   字符串格式化
string.format()
转义码
%c - 接受一个数字, 并将其转化为ASCII码表中对应的字符
%d, %i - 接受一个数字并将其转化为有符号的整数格式
%o - 接受一个数字并将其转化为八进制数格式
%u - 接受一个数字并将其转化为无符号整数格式
%x - 接受一个数字并将其转化为十六进制数格式, 使用小写字母
%X - 接受一个数字并将其转化为十六进制数格式, 使用大写字母
%e - 接受一个数字并将其转化为科学记数法格式, 使用小写字母e
%E - 接受一个数字并将其转化为科学记数法格式, 使用大写字母E
%f - 接受一个数字并将其转化为浮点数格式
%g(%G) - 接受一个数字并将其转化为%e(%E, 对应%G)及%f中较短的一种格式
%q - 接受一个字符串并将其转化为可安全被Lua编译器读入的格式
%s - 接受一个字符串并按照给定的参数格式化该字符串

可以在%号后添加参数. 参数将以如下的顺序读入:

(1) 符号: 一个+号表示其后的数字转义符将让正数显示正号. 默认情况下只有负数显示符号.
(2) 占位符: 一个0, 在后面指定了字串宽度时占位用. 不填时的默认占位符是空格.
(3) 对齐标识: 在指定了字串宽度时, 默认为右对齐, 增加-号可以改为左对齐.
(4) 宽度数值
(5) 小数位数/字串裁切: 在宽度数值后增加的小数部分n, 
    若后接f(浮点数转义符, 如%6.3f)则设定该浮点数的小数只保留n位, 
    若后接s(字符串转义符, 如%5.3s)则设定该字符串只显示前n位.
-- ]] --[[
str1 = "Lua"
str2 = "Tutorial"
num1 = 10
num2 = 20
date = 6;
month = 6;
year = 2014

print(string.format("%s %s", str1, str2))
print(string.format("%03d/%02d/%05d", date, month, year))
print(string.format("%+8.4f", 1 / 3))

print(string.format("%c", 97))
print(string.format("%+d", 17.0))
print(string.format("%05d", 17))
print(string.format("%o", 17))
-- print(string.format("--%u", 3.14)) -- 报错 bad argument #2 to 'format' (number has no integer representation
print(string.format("%X", 13))
print(string.format("%e", 1000))
print(string.format("%E", 1000))
print(string.format("%6.3f", 13))
print(string.format("%q", "One\nTwo"))
print(string.format("%s", "monkey"))
print(string.format("%10s", "monkey"))
print(string.format("%5.3s", "monkey"))

-- ]] --[[ 字符与整数相互转换
string.char() 获得字符
string.byte() 获得整数
-- ]] --[[
print(string.byte("Lua", 1))
print(string.byte("Lua", 2))
print(string.byte("Lua", 3))
print(string.byte("Lua", -3))
print(string.byte("Lua", -2))
print(string.byte("Lua", -1))

print(string.char(76))
print(string.char(117))
print(string.char(97))
-- 拼接
str1 = "Hel"
str2 = "lo "
str3 = "Wor"
str4 = "ld"
final_str = str1 .. str2 .. str3 .. str4
print(final_str)
-- 获取长度
print(#final_str)
-- 复制
print(string.rep(final_str, 3))
-- ]] --[[匹配模式
单个字符(除 ^$()%.[]*+-? 外): 与该字符自身配对

.(点): 与任何字符配对
%a: 与任何字母配对
%c: 与任何控制符配对(例如\n)
%d: 与任何数字配对
%l: 与任何小写字母配对
%p: 与任何标点(punctuation)配对
%s: 与空白字符配对
%u: 与任何大写字母配对
%w: 与任何字母/数字配对
%x: 与任何十六进制数配对
%z: 与任何代表0的字符配对
%x(此处x是非字母非数字字符): 与字符x配对. 主要用来处理表达式中有功能的字符(^$()%.[]*+-?)的配对问题, 例如%%与%配对
[数个字符类]: 与任何[]中包含的字符类配对. 例如[%w_]与任何字母/数字, 或下划线符号(_)配对
[^数个字符类]: 与任何不包含在[]中的字符类配对. 例如[^%s]与任何非空白字符配对

( ) . % + - * ? [ ^ $

-- ]] ---[[
str = "this is a stRing fOR test 20230620"
print(string.sub(str, string.find(str, "%d+")))
-- ]]
