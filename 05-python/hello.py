#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"hello module,这是文档注释"

__author__="Your Name"

import sys

# 作用域
# 非公开变量或函数(不应该直接访问)
_var='not public var'

def _func():
    print("not public function")
    
def test():
    args=sys.argv
    if len(args)==1:
        print("hello world")
    elif len(args)==2:
        print("hello %s"% args[1])
    else:
        print("too many argument")      
        
def __private_1(name):
    return "hello ,%s" %name

def __private_2(name):
    return "Hi ,%s" %name

def greeting(name) -> None:
    if len(name)>3:
        return __private_1(name)
    else:
        return __private_2(name)

class HelloClass(object):    
    def hello(self, name='world'):
        print('Hello, %s.' % name)

if __name__=="__main__":
    test()