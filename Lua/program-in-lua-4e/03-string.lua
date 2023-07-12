#!/usr/bin/lua
---[[ 字符串
-- 自动内存管理
-- 不可变值
a="one string"
b=string.gsub(a,"one","another")
c=string.gsub(b,"n","N")
print(a)
print(c)
print(#c)
print(#"Hello world!")
print("Hello world!"..99)
print(88 .. "Hello world!")
d="hello"
e=d.."world"
print(d)
-- ]]

---[[ 字符串常量
--[=[ 转义字符
\a  响铃
\b  退格
\f  换页
\n  换行
\r  回车
\t  制表（水平）
\v  制表（垂直）
\z  跳过其后空白字符
\\  反斜杠
\"  双引号
\'  单引号
-- ]=]
print("\097\098\099")   -- \ddd
print("\x41\x42\x43\x44")   -- \xhh
-- ]]

---[[ 长字符串、多行字符串
-- 使用双方括号，不会被转义
page=[===[
<html>
<head>
    <title>
        一个页面
    </title>
</head>
<body>
    <a href="https://www.baidu.com">百度</a>
</body>
</html>
]===]
print(page)
-- ]]

---[[ 强制类型转换
print(10 .. 20)
print("10"+1)
print(tonumber("123"))
print(tonumber("12e3"))
print(tonumber("12e"))
print(tonumber("0x1.3p-4"))
print(tonumber("10010",2))
print(tonumber("adf",16))
print(tonumber("-zz",36))
print(tonumber("-478",8))
print(tostring(463914)=="463914")
print(0=='0')
print('2'<'15')
-- print('2'<15) --> attempt to compare string with number
-- ]]

---[[ 字符串标准库
str="Hello World."
print(string.len(str))
print(#str)
print(string.rep(str,3))
print(string.reverse( str ))
print(string.lower(str))
print(string.upper(str))

print(string.sub(str,4,-2))
print(string.sub(str,2,-2))

print(string.char( 97,98,99 ))
print(string.byte( 'abc' ))
print(string.byte( 'abc' ,2))
print(string.byte( 'abc' ,3))
print(string.byte( 'abcdef' ,2,4))
tb={string.byte('abcde',1,-1)}
for key, value in ipairs(tb) do
    print(key..": "..value)
end

print(string.format("%d %x %f %s ",12,2000,12.34,'nihao'))
print(string.format("%8.2f",math.pi))
print(string.format("%+8.2f",math.pi))
print(string.format("%-8.2f",math.pi))
print(string.format("%08.2f",math.pi))

s="Ni Hao"
print(s:upper())    --> 语法糖
print(string.find(str,'llo'))  --str="Hello World."
print(string.gsub(str,'o','.'))
print(string.gsub(str,'o','..'))
print(string.gsub(str,'l','L'))
-- ]]

--[[ unicode编码
ASCII
Unicode
UTF8 
UTF16 
UTF32
建议搜索一下Unicode
-- ]]