#!/usr/bin/env python3
# print("hello world")
print("hello"," world")
a = 100
if a>=0:
    print(a)
else:
    print(-a)

# 数据类型：整数 浮点数 字符串 布尔值 空值 变量 常量 
# Number（数字）        不可变
# String（字符串）      不可变
# Tuple（元组）         不可变
# bool（布尔类型）
# List（列表）      可变    [ ]
# Set（集合）       可变    { }
# Dictionary（字典）可变    { }
# 不可变数据（3 个）：Number（数字）、String（字符串）、Tuple（元组）；
# 可变数据（3 个）：List（列表）、Dictionary（字典）、Set（集合）。

str=r'\tbc'
str=r'''
1\n2
2\t3
34
'''
print(str)
print(1>=2)
print(None)
str1="ABC"
str2=str1
str1="XYZ"
print(str2)
print(10/3)
print(10//3)
print('\u4e2d\u6587')
str3="%d %s"%(23,"hi")
print(str3)
str4="{0} {1:.1f}".format('xm',12.23)
print(str4)
r=2.5
s=3.14*r**2
print(f"radius: {r}, area: {s:.2f}")
# list 列表
days=["1","2","3"]
print(len(days))
print(days[-1])
days.append("4")
days.append("5")
days.insert(3,"6")
days.append(["one","two"])
days.pop(1)
print(days)
# tuple 元组
month=("1","2","3","4","5")
one=("one",)
print(one)

# if 
cond=True
if cond:
    print(cond)

# if else
if not cond:
    print(cond)
else:
    print(cond)

# if  elif else
if not cond:
    print(1)
elif 1==2:
    print(2)
else:
    print(3)

# 循环 for in
#  while
n=[1,2,3]
for item in n:
    print(item)
sum=0
for num in range(101):
    sum=sum+num
    if num==45:
        continue # break
print(sum)
count=10
while count>=1:
    count=count-2
print(count)

# dict 字典
days={"Sun":1,"Mon":2,"Tue":3,"Wed":4,"Thu":5,"Fri":6,"Sat":7}
# days["Te"]=-1
days.pop("Sun")
print(days)
print(days.get("Tue"))

# set 集合
set1=set([1,2,"3","4",5,6,"One"])
set2=set(["4",5,6,7,8,"9"])
print(set1&set2)
print(set1|set2)
set3=set([1])
set3.add("2")
set3.add("3")
set3.remove(1)
print(set3)
str_a="abc"
str_b=str_a.replace("a","A")
print(str_a.replace('a',"A"))
print(str_a)
print(str_b)

# 函数
print(abs(-3))
f=abs
print(f(-5))
print(f)
def func(pa):
    print(pa)
func(123)
from util import add,multi
print(add(1,2))
print(multi(1,2))
# 空函数
def empty():
    pass
empty()

def func2():
    return "ret1",12  # 多返回值会返回 元组
print(func2())

def power(x,n=2):
    s=1
    while n>0:
        n=n-1
        s=s*x
    return s
    
print(power(2,3))

def enroll(name,gender,age=6,city="shanhai"):
    print("name: ",name)
    print("gender: ",gender)
    print("age: ",age)
    print("city: ",city)

enroll("xiaoming",12)    
enroll("zhangsan",23,city="bj")

# 永远记住 ：默认参数必须指向不变对象
# def add_len(L=[]):
#     L.append("END")
#     return L
# 升级：
def add_len(L=None):
    if not L:
        L=[]
    L.append("END")
    return L

print(add_len())
print(add_len())
print(add_len())
print(add_len([1,2,3]))

# 可变参数 使用*param
def calc(nums):
    sum=0
    for n in nums:
        sum=sum+n*n
    return sum
print(calc([1,2,3]))
print(calc((2,4,6)))

# *params 表示形参params是可变参数
def calc2(*nums):
    sum=0
    for n in nums:
        sum=sum+n*n
    return sum

print(calc2())
print(calc2(1,2))
list=[1,2,3,4,5]
print(calc2(*list))

# 关键字参数：自动组装为dict
def person(name,age,**kw):
    print("name: ",name,"age: ",age,"other: ",kw)

person("zhangsan",33)
person("zhangsan",33,city="bj")
person("zhangsan",33,city="bj",gender=2)
extra={"addr":"beijing","gender":2,"career":"teacher"}
person("zhangsan",33,city="bj",**extra)

# 命名关键字参数 用*分割
def person2(name,age,*,job,city):
    print("name: ",name,"age: ",age,"city: ",city,"job: ",job)

# extra={}
person2("zhangsan",22,city="shanghai",job="teacher")

extra3={"hobby1":"smoking","hobby2":"drinking"}
def person3(name,age,*extra3,job,city):
    print("name: ",name,"age: ",age,"city: ",city,"job: ",job,"by1:",extra3)
person3("zhangsan",22,extra3,city="shanghai",job="teacher")

# 参数组合顺序：必选参数、默认参数、可变参数、命名关键字参数和关键字参数
def func1(a,b,c=0,*args,d,e,**kw):
    print()

def func2(a,b,c=0,*,d,**kw):
    print()

# 递归函数
def fact(n):
    if n==1:
        return 1
    return n*fact(n-1)
# print(fact(1000))

# 尾递归优化
def fact2(n):
    return fact2_iter(n,1)
def fact2_iter(num,product):
    if num==1:
        return product
    return fact2_iter(num-1,num*product)
print(fact2(999))