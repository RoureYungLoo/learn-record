#!/usr/bin/env python3
# 把100MB的数据写入磁盘
# 同步IO：CPU等着，也就是程序暂停执行后续代码，等100M的数据在10秒后写入磁盘，再接着往下执行
# 异步IO：CPU不等待，只是告诉磁盘，“您老慢慢写，不着急，我接着干别的事去了”，于是，后续代码可以立刻接着执行
# 区别：是否等待IO执行结果

# 文件读写
# 读
filename="file1.txt"
# try:
#     file=open(filename,"r")
#     str=file.read()
#     # print(str)
# finally:
#     if file:
#         file.close()

# with open(filename,"r") as file:
#     # print(file.read())
#     for line in file.readlines():
#         print(line.strip())
        
# file-like object: 含有read()方法的对象, 可以是字节流、网络流、自定义流等等等

# 二进制文件
# file=open("test.png","rb")
# print(file.read())
# file.close()

# file=open(filename,"r",encoding="gbk",errors="ignore")
# print(file.read())
# file.close()

content='''this is a file for test1.
this is a file for test2.
this is a file for test3.
this is a file for test4.
this is a file for test5.
this is a file for test6.'''
# file=open(filename,"w")
# # print(file.write(content))
# file.close()

with open(filename,"a") as file:
    # file.write(content)
    pass
    
with open(filename,"r") as f:
    # print(f.read())
    pass
    
# StringIO
from io import StringIO
f=StringIO()
print(f.write("hello"))
print(f.write(", "))
print(f.write("world"))
print(f.getvalue())

fr=StringIO("Hello!\nHi\nBye!")
while True:
    s=fr.readline()
    if s=="":
        break
    print(s.strip())

# ByteIO
from io import BytesIO
str="中文汉字"
f=BytesIO()
f.write(str.encode("utf-8"))
print(f.getvalue())
print(f.getbuffer())

bin=b'\xe4\xb8\xad\xe6\x96\x87\xe6\xb1\x89\xe5\xad\x97'
f=BytesIO(bin)
print(f.read())

import os
print(os.name)
print(os.uname())
# print(os.environ)
print(os.environ.get("PATH"))
print(os.path.abspath("."))
dir=os.path.join(".","testdir")
print(dir)
# os.mkdir(dir)
# os.rmdir(dir)

filename="/root/02-notes/05-python/10-IO.py"
print(os.path.split(filename))
print(os.path.splitext(filename))

oldname="test.py"
newname="new_test.py"
# print(os.rename( oldname,newname))
# os.remove(newname)

cur_dir="."
print([x for x in os.listdir(cur_dir) if os.path.isdir(x)])
print([x for x in os.listdir(cur_dir) if os.path.isfile(x) and os.path.splitext(x)[1]==".py"])

# 序列化，python叫做picking，其他语言中叫serialization，marshaling，flattening
# 变量从内存中变成可存储或传输的过程称之为序列化，反之称为反序列化

# pickle
import pickle
d=dict(name="lisi",age=22,score=88)
print(pickle.dumps(d))
filename="tmp.data"
file=open(filename,"wb")
pickle.dump(d,file)
file.close()

f=open(filename,"rb")
dd=pickle.load(f)
f.close
print(dd)

# JSON
# JSON类型      Python类型
# {}            dict
# []            list
# "string"      str
# 123.45        int/float
# true/false    True/False
# null          None
import json
print(json.dumps(d))
json_str='{"age":20,"score":99,"name":"zhangsan"}'
print(json.loads(json_str))
json_file=open("obj.json","r")
print(json.load((json_file)))

# JSON进阶
class Person(object):
    def __init__(self,name,age,score):
        self.name=name
        self.age=age
        self.score=score
    def __str__(self):
        return "%s %d %d" %(self.name,self.age,self.score)
    
s=Person("wangwu",20,88)
print(s)
# print(json.dumps(s))

def person2dict(psn):
    return {
        "name":psn.name,
        "age": psn.age,
        "score":psn.score
    }
    
def dict2person(psn):
    return Person(psn["name"],psn["age"],psn["score"])

print(json.dumps(s,default=person2dict))
print(json.dumps(s,default=lambda obj:obj.__dict__))
print(json.loads(json_str,object_hook=dict2person))