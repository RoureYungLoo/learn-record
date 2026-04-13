#!/usr/bin/env python3

print("hello world")
print(100 + 200 + 300 + 400)
print("hello", " world", 1, 2, 3)
name = input("输入名字: ")
print('you are ' + name)
print('1024 * 768 =', 1024 * 786)

# Python 大小写敏感, 严格缩进, 粘贴复制务必检查缩进层级, 禁止Tab和空格混用
a = 100
if a >= 0:
    print(a)
else:
    print(-a)

# 数据类型：整数 浮点数 字符串 布尔值 空值 变量 常量
print('I\'am \"OK\"')
print('Hello\nWorld')
# 原始字符串
print(r'I\'am \"OK\"')
print(r'Hello\nWorld')
# 多行字符串
print(r'''
      1 2 3 \'
      ''')
print(1 == 1)
print(1 != 1)
age = int(input('input your age: '))
if age >= 18:
    print('adult')
else:
    print('teenager')

print(None)

# 动态类型语言
addr = 1
print(addr)
addr = 'addr'
print(addr)
addr = True
print(addr)

x = 'abc'
y = x
x = 'xyz'
print(x, y)

PI = 3.141592
print(PI)

print(10 / 3)
print(10 // 3)
print(10 % 3)
# print(1/0) ZeroDivisionError: division by zero
print(1 / 0.00000000000000000001)
