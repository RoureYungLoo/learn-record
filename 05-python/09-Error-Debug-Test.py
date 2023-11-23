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
# bar()

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
    
# func2()


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
# main()

# print("END")

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

# bar2()

# 调试
# print

# 断言 assert Ture，否则报错
def foo3(s):
    n=int(s)
    assert n!=0,"n can not be zero!"
    return 10/n
# foo3(2)

# logging
import logging
# logging.basicConfig(level=logging.INFO)
logging.basicConfig(level=logging.INFO)
def foo4(s):
    n=int(s)
    logging.info("----------n=--------------%d"%n)
    print(10/n)
# foo4(0)

# pdb

# pdb.set_trace()
import pdb

def foo5(s):
    n=int(s)
    logging.info("----------n=--------------%d"%n)
    # pdb.set_trace()
    print(10/n)
# foo5(0)

#IDE [Visual Studio Code] [PyCharm]

# logging 日志 ，关键日志输出

#TDD Test-Driven Development 测试驱动开发
import unittest
from mydict import Dict
class TestDict(unittest.TestCase):
    def test_init(self):
        d = Dict(a=1, b='test')
        self.assertEqual(d.a, 1)
        self.assertEqual(d.b, 'test')
        self.assertTrue(isinstance(d, dict))
        
    def test_key(self):
        d = Dict()
        d['key'] = 'value'
        self.assertEqual(d.key, 'value')
        
    def test_attr(self):
        d = Dict()
        d.key = 'value'
        self.assertTrue('key' in d)
        self.assertEqual(d['key'], 'value')
        
    def test_keyerror(self):
        d = Dict()
        with self.assertRaises(KeyError):
            value = d['empty']
            
    def test_attrerror(self):
        d = Dict()
        with self.assertRaises(AttributeError):
            value = d.empty
    
    def setUp(self):
        print("set up...")
        
    def tearDown(self):
        print("tearDown...")
            
# if __name__=="__main__":
#     unittest.main()
    
# 文档测试
def abs(n):
    '''    
    Example:
    
    >>> abs(1)
    1
    >>> abs(-1)
    1
    >>> abs(0)
    0
    '''
    return n if n>=0 else (-n)

if __name__=="__main__":
    import doctest
    doctest.testmod()