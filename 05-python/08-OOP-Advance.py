#!/usr/bin/env python3
# 多重继承  定制类  元类  

# __slots__  限制class实例能添加的属性
class Student(object):
    # 动态绑定slots之外的属性会报错: AttributeError: 'Student' object has no attribute 'score'
    __slots__=("name","func","score") 
    pass
s=Student()
def f(self):
    print("func student: %s"%self.name)
s.func=f
s.name="zhangsan"
# s.func(self)
from types import MethodType
from typing import Any
s.func=MethodType(f,s) # 给实例绑定一个方法
# s.func()

def set_score(self,score): #给class绑定一个方法
    self.score=score
Student.set_score=set_score
s.set_score(79)
# print(s.score)

class JuniorStudent(Student):
    __slots__=("age","gender","addr")
    pass
js=JuniorStudent()
js.age=7
# print(js.age)
js.name="xiaoming"
# print(js.name)

# 父类      子类        子类动态属性
# 有slots   有slots     父类子类slots并集
# 有slots   无slots     任意
# 无slots   有slots     任意
# 无slots   无slots     任意

# 装饰器
class Student2(object):

    @property
    def score(self):
         return self._score
     
    @score.setter
    def score(self, value):
        if not isinstance(value, int):
            raise ValueError('score must be an integer!')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        self._score = value
        
    @property
    def birth(self):
        return self._birth
    @property
    def age(self):
        return 2023-self._birth
    
    @birth.setter
    def birth(self,value):
        self._birth=value
        
    @property
    def name(self):
        return self._name
    @name.setter
    def name(self,n):
        self._name=n
        
    @property
    def attr(self):
        return self._attr
        # return self.attr # 会导致栈溢出 
    
    @attr.setter
    def attr(self,v):
        self._attr=v
    
    def print(self):
        print("name %s age %s birth %s score %s "%(self.name, self.age, self.birth, self.score))
        
stu2=Student2()
stu2.score=60
stu2.birth=1998
stu2.name="lisi"
stu2.attr=123 # RecursionError: maximum recursion depth exceeded
# stu2.age=23 # AttributeError: can't set attribute
stu2.print()

# 多重继承
class Animal(object):
    pass
class Mammal(Animal):
    pass
class Bird(Animal):
    pass
class Dog(Mammal):
    pass
class Bat(Mammal):
    pass
class Parrot(Bird):
    pass
class Ostrich(Bird):
    pass

class Runnable(object):
    def run(self):
        print("Running ... ")
        
class Flyable(object):
    def fly(self):
        print("Flying ... ")
        
class Dog2(Mammal,Runnable):
    pass
class Bat2(Mammal,Flyable):
    pass

# Mixln
class RunnableMixIn(object):
    def run(self):
        print("Running ... ")
        
class FlyableMixIn(object):
    def fly(self):
        print("Flying ... ")
        
class Dog(Mammal,RunnableMixIn,FlyableMixIn):
    pass

from socketserver import TCPServer,UDPServer
class ForkingMixIn (object):
    pass

class ThreadingMixIn (object):
    pass

class CoroutineMixIn (object):
    pass

class MyTCPServer(TCPServer,ForkingMixIn):
    pass
class MyUDPServer(UDPServer,ThreadingMixIn):
    pass
class MyTCPServer2(TCPServer,CoroutineMixIn):
    pass

# 定制类 __str__
class Student(object):
    def __init__(self,name) -> None:
        self.name=name
    def __str__(self) -> str:
        return "Student object (name: %s)" % self.name
    __repr__=__str__
    
stu1=Student("xiaoming")
print(stu1)

# 定制类 __iter__
class Fibnacci(object):
    def __init__(self):
        self.a,self.b=0,1
        
    def __iter__(self):
        return self
    
    def __next__(self):
        self.a,self.b=self.b,self.a+self.b
        if self.a>1000:
            raise StopIteration()
        return self.a
    def __getitem__(self,n):
        if isinstance(n,int):
            a,b=1,1
            for x in range(n):
                a,b=b,a+b
            return a
        if isinstance(n,slice):
            start=n.start
            stop=n.stop
            if start is None:
                start=0
            a,b=1,1
            L=[]
            for x in range(stop):
                if x>=start:
                    L.append(a)
                a,b=b,a+b
            return L
    def __setitem__(self):
        pass
    def __delitem__(self):
        pass
    
    def __getattr__(self,attr):
        if attr=="score":
            return 99
    
# for n in Fibnacci():
        # print(n)
        
f=Fibnacci()
print(f[15])
print(f[3:10:2])
print(f.scor)
print(f.score)

class Chain(object):
    def __init__(self,path="") :
        self._path=path
    def __getattr__(self,path):
        return Chain("%s/%s"%(self._path,path))
    def __str__(self) -> str:
        return self._path
    def __call__(self,args) -> Any:
        print("Chain: %s"%args)
    __repr__=__str__
    
c=Chain()
print(c.stauts.user.timeline.list)
c("/path1/path2")


if callable(c("/home/cate")):
    c("/home/cate")
    
print(callable(max))
print(callable(None))

# 枚举类
from enum import Enum,unique
Month=Enum("Month",("Jan", 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'))
print(Month.Aug)

for name,member in Month.__members__.items():
    print(name,"=>",member,",",member.value)
    
@unique
class Weekday(Enum):
    Sun=0
    Mon = 1
    Tue = 2
    Wed = 3
    Thu = 4
    Fri = 5
    Sat = 6
    
for name,member in Weekday.__members__.items():
    print(name,"=>",member,",",member.value)
print(Weekday.Wed.value)
print(Weekday(4))

# 元类
from hello import HelloClass
h=HelloClass()
h.hello("WORLD")
print(type(HelloClass))
print(type(h))

def fn(self,name="world"):
    print("Hello, %s."%name)
    
HelloClass2=type("Hello",(object,),dict(hello2=fn))
print(type(HelloClass2))
hi=HelloClass2()
hi.hello2("123")
print(hi.hello2)
print(hi)

# metaclass 元类 基本上不会遇到
# 先定义metaclass，就可以创建类，最后创建实例
class ListMetaclass(type):
    def __new__(cls,name,bases,attrs):
        attrs["add"]=lambda self,value: self.append(value)
        return type.__new__(cls,name,bases,attrs)
class MyList(list,metaclass=ListMetaclass):
    pass
L=MyList()
L.add(1)
L.add(12)
L.add(3)
print(L)

# ORM Object Relational Mapping
class Field(object):
    def __init__(self,name,column_type):
        self.name=name
        self.column_type=column_type
    def __str__(self) -> str:
        return "<%s:%s>" %(self.__class__.__name__,self.name)
    
class StringField(Field):
    def __init__(self,name):
        super(StringField,self).__init__(name,"varcha(100)")
        
class IntegerField(Field):
    def __init__(self,name):
        super(IntegerField,self).__init__(name,"bigint")
        
class ModelMetaclass(type):
    def __new__(cls,name,bases,attrs):
        if name=='Model':
            return type.__new__(cls, name, bases, attrs)
        print('Found model: %s' % name)
        mappings = dict()
        for k, v in attrs.items():
            if isinstance(v, Field):
                print('Found mapping: %s ==> %s' % (k, v))
                mappings[k] = v
        for k in mappings.keys():
            attrs.pop(k)
        attrs['__mappings__'] = mappings # 保存属性和列的映射关系
        attrs['__table__'] = name # 假设表名和类名一致
        return type.__new__(cls, name, bases, attrs)

class Model(dict,metaclas=ModelMetaclass):
    def __init__(self, **kw):
        super(Model, self).__init__(**kw)

    def __getattr__(self, key):
        try:
            return self[key]
        except KeyError:
            raise AttributeError(r"'Model' object has no attribute '%s'" % key)

    def __setattr__(self, key, value):
        self[key] = value

    def save(self):
        fields = []
        params = []
        args = []
        for k, v in self.__mappings__.items():
            fields.append(v.name)
            params.append('?')
            args.append(getattr(self, k, None))
        sql = 'insert into %s (%s) values (%s)' % (self.__table__, ','.join(fields), ','.join(params))
        print('SQL: %s' % sql)
        print('ARGS: %s' % str(args))
        

class User(Model):
    # 定义类的属性到列的映射：
    id = IntegerField('id')
    name = StringField('username')
    email = StringField('email')
    password = StringField('password')
    
# 创建一个实例：
u = User(id=12345, name='Michael', email='test@orm.org', password='my-pwd')
# 保存到数据库：
u.save()