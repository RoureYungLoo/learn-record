#!/usr/bin/env python3
# 切片 [start:end]
L=list(range(100)) # [0,1,2,3,...,98,99]
T=tuple(range(100)) # (0,1,2,3,...,98,99)
print(L[:])
print(L[0:3])
print(L[:3])
print(L[10:20:2])
print(L[::13])
print(L[-5:])
print(L[-5:-2])

print(T[:])
print(T[0:3])
print(T[:3])
print(T[10:20:2])
print(T[::13])
print(T[-5:])
print(T[-5:-2])

S="ABCDEFGHIGKLMNOPQRSTUVWXYZ"
print(S[:])
print(S[0:3])
print(S[:3])
print(S[10:20:2])
print(S[::4])
print(S[-5:])
print(S[-5:-2])

# 迭代, 可迭代对象，无论有无下标，都可以迭代
dictt={"name":"zhangsan","age":22,"addr":"shanghai"}
def key_iter(dict):
    for key in dict.keys():
        print(key)

def value_iter(dict):
    for value in dict.values():
        print(value)

def key_value_iter(dict):
    for key,value in dict.items():
        print(key,value)

key_iter(dictt)
value_iter(dictt)
key_value_iter(dictt)

# 判断是否是可迭代对象
from collections.abc import Iterable
def iterable(obj):
    if isinstance(obj,Iterable):
        print(obj,"是可迭代对象")
    else:
        print(obj,"不是可迭代对象")

iterable("abcde")
iterable((1,2,3,))
iterable([1,2,3])
iterable(dictt)
# 把可迭代对象变为枚举对象：enumerate(可迭代对象)
def en_enumerate(iterable_obj):
    for index,value in enumerate(iterable_obj):
        print(index,value)
en_enumerate("dictt")

# 列表生成式 
print([x*x for x in range(1,11)])
print([x*x for x in range(1,11) if x%2==0])
print([m+n for m in "ABC" for n in "XYZ"])
import os
print([d for d in os.listdir('.')])
d={"x":"A","y":"B","z":"C"}
print([k+" = "+v for k,v in d.items()])
L=["Hello","World","IBM","Apple"]
print([s.upper() for s in L])

# 列表生成式 [for if过滤条件(不能带else)] [ if else表达式(必须带else) for]
print([x if x&2==0 else -x for x in range(1,11)])
print([x for x in range(1,11) if x%2==0])
# 生成100万个数据 --> Killed
# L=[x for x in range(1000000000)]

# 生成器 在循环的过程中不断推算出后续的元素, 一边循环一边计算的机制，称为生成器：generator
g=(x for x in range(100))
print(g)
def print_generator(g,nums):
    for i in range(nums):
        print(next(g)) # next 或for 都可以迭代生成器对象
print_generator(g,5)
next(g)
print(next(g))
for n in g:
    if n<=10:
        print(n)
# 斐波那契
def fib(max):
    n,a,b=0,0,1
    while n<max:
        # print(b)
        yield b
        a,b=b,a+b
        n=n+1
    return "done"
# fib(8) 
g=fib(8)
print(next(g))
print(next(g))
print(next(g))
print(next(g))
print(next(g))

def odd():
    print("step1")
    yield 1
    print("step2")
    yield 3
    print("step3")
    yield 5
g=odd()
print(next(g))
print(next(g))
print(next(g))
# print(next(g)) # -->报错 StopIteration

# 迭代器，可以迭代可迭代对象的东西
# Ⅰ.集合数据类型，如list、tuple、dict、set、str等；
# Ⅱ.generator，包括生成器和带yield的generator function。
from collections.abc import Iterable,Iterator
def is_iterator(obj):
    # return isinstance(obj,Iterator)
    return isinstance(obj,Iterable)
print(is_iterator("abc"))
print(is_iterator({}))
print(is_iterator([]))
print(is_iterator(g))

it=iter([1,2,3,4,5]) # 获得一个iterator迭代器对象
while True:
    try:
        x=next(it)
        print(x)
    except StopIteration:
        break
