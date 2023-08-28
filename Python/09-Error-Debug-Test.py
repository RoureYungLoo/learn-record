#!/usr/bin/env python3
# 错误处理
def some_func():
    return -1
def foo():
    r=some_func()
    if r==-1:
        return (-1)
    return r
def bar():
    r=foo()
    if r==-1:
        print("Error")
    else:
        pass
bar()

def func2():
    try:
        print("try...")
        r=10/2
        # r=10/int('a')
        print("result: ",r)
    except ZeroDivisionError as e:
        print("execpt: ",e)
    except ValueError as e:
        print("ValueError: ",e)
    else:
        print("No Error")
    finally:
        print("finally...")
    print("END")
    
func2()


def func11(s):
    return 10/int(s)
def func22(s):
    return func11(s)*2
def func33(s):
    return 8+func22(s)

# 记录错误
import logging
def main():
    try:
        func33("0")
    except Exception as e:
        logging.exception(e)
main()

print("END")

# 抛出错误
class FooError(ValueError):
    pass

def test_foo(s):
    n=int(s)
    if n==0:
        raise FooError("无效的值: %s" % s)
    return 10 / n
# test_foo("0")

def foo2(s):
    n = int(s)
    if n==0:
        raise ValueError('invalid value----: %s' % s)
    return 10 / n

def bar2():
    try:
        foo2('0')
    except ValueError as e:
        # 捕获错误
        print('ValueError!!!')
        # 原样抛出
        raise

bar2()
