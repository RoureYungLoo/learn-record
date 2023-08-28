#!/usr/bin/env python3
# 函数式编程就是一种抽象程度很高的编程范式
# 函数式编程的一个特点就是，允许把函数本身作为参数传入另一个函数，还允许返回一个函数！

# 高阶函数: 形参中有其他函数的函数
# 变量可以指向函数
f=abs
print(f(-10))

# 函数名也是变量
# abs=10

# 传入函数
def add(x,y,f):
    return f(x)+f(y)
print(add(-2,-3,abs))
# 把函数作为参数传入，这样的函数称为高阶函数，函数式编程就是指这种高度抽象的编程范式。

# map/reduce
def func(x):
    return x*x
L=[9,8,7,6,5,4]
it=map(func,L)
print(next(it))
print(next(it))
print(next(it))
print(next(it))
print(next(it))
print(next(it))

# reduce
def add(x,y):
    return x+y
from functools import reduce
print(reduce(add,L))

def func2(x,y):
    return x*10+y
def tonumber(s):
    digits = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
    return digits[s]
print(reduce(func2,L))
print(reduce(func2,map(tonumber,"201314")))

DIGITS = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
def str2int(s):
    def fn(x,y):
        return x*10+y
    def tonumber(s):
        return DIGITS[s]
    # return reduce(fn,map(tonumber,s))
    return reduce(lambda x,y:x*10+y,map(tonumber,s))

print(str2int("4961134"))

# lamda表达式
# lambda [arg1 [,arg2,.....argn]]:expression

# filter
def is_odd(n):
    return n%2==1
L=filter(is_odd,list(range(11)))
print(list(L))

def not_empty(s):
    return s and s.strip()
L=["A","B","  ","C",None]
print(list(filter(not_empty,L)))

def _odd_iter():
    n=1
    while True:
        n=n+2
        yield n
def _not_divisible(n):
    return lambda x:x %n>0
def primes():
    yield 2
    it=_odd_iter()
    while True:
        n=next(it)
        yield n
        it=filter(_not_divisible(n),it)
for n in primes():
    if n<1000:
        print(n)
    else:
        break
    
# 排序算法
L=[1,-54,12,-24,41,-18,23]
# L=[1,54,12,24,41,18,23]
print(sorted(L,key=abs))
N=["zhan","San","li","si","wang","wu"]
print(sorted(N))
print(sorted(N,key=str.lower))
print(sorted(N,key=str.upper,reverse=True))

# 返回函数
def calc_sum(*args):
    ax=0
    for n in args:
        ax=ax+n
    return ax
def lazy_sum(*args):
    def sum():
        ax=0
        for n in args:
            ax=ax+n
        return ax
    return sum
f=lazy_sum(1,3,5,7,9)
f1=lazy_sum(1,3,5,7,9)
f2=lazy_sum(1,3,5,7,9)
print(f)
print(f())
print(f1==f2)

# 闭包 closure
def count():
    fs=[]
    for i in range(1,4):
        def f():
            return i*i
        fs.append(f)
    return fs
f1,f2,f3=count()
print(count())
print(f1())
print(f2())
print(f3())

def count2():
    def f(j):
        def g():
            return j*j
        return g
    fs=[]
    for i in range(1,4):
        fs.append(f(i))
    return fs
f1,f2,f3=count2()
print(count())
print(f1())
print(f2())
print(f3())

# nonloca 
def inc():
    x=0
    def fn():
        nonlocal x
        x=x+1
        return x
    return fn
h=inc();m=inc()
print(h())
print(h())
print(h())
print(m())
print(m())
print(m())

# 匿名函数 (即lamda表达式)
print(list(map(lambda x:x*x,[1,3,5,7,9])))
f=lambda x:print(x*x*x)
f(5)
def build(x,y):
    return lambda: x*x+y*y
print(build(2,3)())

# 装饰器 (最好去看一下设计模式之装饰器模式)
# 在代码运行期间动态增加功能的方式,称之为"装饰器"
# 装饰器的本质就是一个返回函数的高阶函数
def log(func):
    def wrapper(*args,**kw):
        print("call %s(): " % func.__name__)
        return func(*args,**kw)
    return wrapper

@log
def now():
    print("2023/8/25")
f=now
f()
print(f.__name__)
print(now.__name__)

def log2(text):
    def decorator(func):
        def wrapper(*args,**kw):
            print("%s %s()" % (text,func.__name__))
            return func(*args,**kw)
        return wrapper
    return decorator

@log2("execute")
def now2():
    print("2023/8/25")

now2()
# 偏函数(非数学领域的偏函数)
print(int("1234",base=16))
print(int("10011010",base=2))
def int2(x):
    return int(x,base=2)
print(int2('1010'))

import functools
int8=functools.partial(int,base=8) # 创建偏函数
print(int8("2347201"))
