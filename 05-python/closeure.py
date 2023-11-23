#!/usr/bin/env python3
# def func2():
#     print("func1")
# def func1():
#     print("func2")
#     func2()

# func1()

# def func():
#     def func1():
#         print("func1")
#     func1()
# func()

# def outer():
#     print("outer")
#     def inner():
#         print("inner")
#     inner()
# outer()

def outer():
    a=1
    print("outer")
    def inner():
        nonlocal a
        a+=1
        print("inner, a = ",a)
    return inner
f=outer();g=outer()
print(f)
f()
f()
f()
# g()
# g()
# 闭包的一大用处就是装饰器
# 闭包函数需要有三个条件，缺一不可：
# 1.必须有一个内嵌函数
# 2.内部函数引用外部函数变量
# 3.外部函数必须返回内嵌函数