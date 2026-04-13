#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# ACSII 编码 1B

# GB2312 编码 2B

# Unicode 编码 2B/4B

# UTF-8 编码 1B-6B, 中文3B

# Python字符串是Unicode编码
print(ord('A'))
print(ord('中'))
print(chr(64))
print(chr(25991))

# Unicode
print('\u4e2d\u6587')
# Byte 数组
byte = b'ABC'
print(byte)
print(type(byte))

raw = 'ABC'
zhCN = '中文'
ascii = 'ascii'
utf8 = 'utf-8'
ABCBytes = b'ABC'
zhCNBytes = b'\xe4\xb8\xad\xe6\x96\x87'
print(raw.encode(ascii))
print(zhCN.encode(utf8))
print(ABCBytes.decode(ascii))
print(zhCNBytes.decode(utf8))

bytesWithInvalid = b'\xe4\xb8\xad\xe6\x96\x87\xff\xad'
print(bytesWithInvalid.decode(utf8, 'ignore'))

# len() 计算字符串的字符数, bytes的字节数
print(len(raw))
print(len(ABCBytes))
print(len(bytesWithInvalid))
print(len(zhCN.encode(utf8)))
# 以utf-8编码格式读取
print('# -*- coding: utf-8 -*-')

# 字符串格式化之 %
print("hello %s" % 'lisi')
print('Hi, %s, you have $%d' % ('zhangsan', 6879))
print('%2d-%02d' % (3, 1))
print(('%.2f' % 3.1415926))
print('age: %s, gender: %s' % (36, True))
print('rate: %.3f%%' % 12.3453453)

# 字符串格式化之 format()
msg = 'hello, {0}, 成绩提升了{1:.2f}%'
print(msg.format('xiaoming', 12.234))

# 字符串格式化之 f-string
r = 2.5
s = 3.14 * r ** 2
print(f'radis is {r}, area is {s:.3f}')


def getRatio(oldScore, newScore):
    return (newScore - oldScore) / oldScore


s1 = 50
s2 = 75
print('小明成绩从%d到%d提升了%.1f%%' % (s1, s2, 100 * getRatio(s1, s2)))
print(f'小明成绩从{s1}到{s2}提升了{100 * getRatio(s1, s2):.1f}%')
xiaoMingProgress = '小明成绩从{0}到{1}提升了{2:.1f}%'
print(xiaoMingProgress.format(s1, s2, 100 * getRatio(s1, s2)))
