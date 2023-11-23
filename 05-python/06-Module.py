#!/usr/bin/env python3
# 模块 Module : 一个py文件就是一个Module
# 包 Package : 一个含有__init__.py文件的目录就是一个包, __init__.py的模块名就是包名(即目录名)
# 在Python中，一个.py文件就称之为一个模块(Module)
# 注意模块中的函数名不推荐和内置函数名相同.(https://docs.python.org/3.8/library/functions.html)
# 注意模块名不推荐和系统模块名相同

# 创建一个hello.py,写入以下内容
code='''
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"hello module"

__author__="Your Name"

import sys

def test():
    args=sys.argv
    if len(args)==1:
        print("hello world")
    elif len(args)==2:
        print("hello %s"% args[1])
    else:
        print("too many argument")      
        
if __name__=="__main__":
    test()
'''
# import hello
from hi import hello
print(hello._var)
hello._func()
print(hello.greeting("hell"))