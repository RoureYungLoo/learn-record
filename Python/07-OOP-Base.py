#!/usr/bin/env python3


# 面向对象三大特性: 封装, 继承, 多态
class Student(object):
    def __init__(self, name, score):
        self.name = name
        self.score = score

    def print_score(self):
        print("%s %s" % (self.name, self.score))

    def get_grade(self):
        if self.score >= 90:
            return "A"
        elif self.score >= 60:
            return "B"
        else:
            return "C"


stu1 = Student("zhangsan", 59)
stu2 = Student("lisi", 87)
# stu1.print_score()
# stu2.print_score()
# print(stu1.get_grade())
# print(stu2.get_grade())


# 类和实例
class MyClass(object):
    def __init__(self, attr1, attr2):
        self.a1 = attr1
        self.a2 = attr2
        self.VERSION = "1.0.0"

    # 数据封装
    def tostring(self):
        print("%s %s %s " % (self.a1, self.a2, self.VERSION))


# obj1=MyClass("value1","value2")
# obj1.tostring()


# 访问限制
class Student2(object):
    def __init__(self, name, score):
        self.__name = name
        self.__score = score

    def print_score(self):
        print("%s %s" % (self.__name, self.__score))

    def get_grade(self):
        if self.__score >= 90:
            return "A"
        elif self.__score >= 60:
            return "B"
        else:
            return "C"

    def __func(self):
        print(self.__score)


stu21 = Student2("sut21", 89)
stu21.print_score()
print(stu21.get_grade())
# print(stu21.__name) # AttributeError: 'Student2' object has no attribute '__name'
# print(stu21.__score) # AttributeError: 'Student2' object has no attribute '__score'
# stu21.__func() #AttributeError: 'Student2' object has no attribute '__func'

# 强烈不建议下面的做法 obj._ClassName_Attr/Func()
print(stu21._Student2__name)
print(stu21._Student2__score)
stu21._Student2__func()


# 继承和多态 基类和派生类 父类和子类
class Animal(object):
    def run(self):
        print("running")


class Dog(Animal):
    def run(self):
        print("Dog running")


class Cat(Animal):
    def run(self):
        print("Cat running")


# 子类run()方法覆盖了父类的run()方法 --> 引出概念: 多态
# 多态: 基类的同一个接口, 不同子类去调用, 有不同的行为
# 多态性是 : 一个接口,多种实现
# 多态前提: 1.继承(inherit) 2.重写(override)

dog = Dog()
dog.run()  # Dog running
cat = Cat()
cat.run()  # Cat running

print(isinstance(dog, Dog))  # True
print(isinstance(dog, Animal))  # True


# 多态，如果传进去的对象自身没有定义run()，就会调用基类的run()，
# 如果子对象有run()，就会调用自身的run()，也就实现了[多态]
def run_three_times(animal):
    for i in range(3):
        animal.run()


class Pig(Animal):
    def run(self):
        print("Pig running")

    pass


pig = Pig()
run_three_times(dog)
run_three_times(cat)
run_three_times(pig)


# 只需要保证传入的对象有一个run()方法就可以了
class C(object):
    def run(self):
        print("run anything")


c = C()
run_three_times(c)

# 鸭子类型: "当看到一只鸟走起来像鸭子、游泳起来像鸭子、叫起来也像鸭子，那么这只鸟就可以被称为鸭子 "

# 获取对象信息: type()  isinstance(obj,class70)
# 要注意的是，只有在不知道对象信息的时候，我们才会去获取对象信息
print(type(123.456))
print(type(123_456))
print(type("123.456"))
print(type((1,)))
print(type(True))
print(type([1, 2]))
print(type({1, 2, 3, "3", "One", "9"}))
print(type({"addr": "beijing", "age": 22}))
print(type(None))
print(type(object))
print(type(Dog))
print(type(dog))
print(type(cat))
print(type(c))
print(type(abs))

import types


def f():
    pass


print(type(f))
print(types.FunctionType)
print(types.BuiltinFunctionType)
print(types.LambdaType)
print(types.GeneratorType)

# print(dir(dog))
# print(dir(c))
print(dir(object))


class Pen(object):
    def __init__(self, color, brand) -> None:
        self.color = color
        self.brand = brand

    def write(self):
        print("use pen writing")


pen = Pen("blue", "changuang")
print(hasattr(pen, "color"))
print(setattr(pen, "color", "red"))
print(getattr(pen, "color"))  # AttributeError: 'Pen' object has no attribute 'colorr'
print(hasattr(pen, "write"))
pen_f = getattr(pen, "write")
print(pen_f)  # <bound method Pen.write of <__main__.Pen object at 0x7fb10959adf0>>
pen_f()  # use pen writing


# 实例属性和类属性 : 相同名称的实例属性将屏蔽掉类属性
class Student3(object):
    # 类属性
    name = "Student3"

    def __init__(self, name, score):
        # 实例属性 : 通过self变量或者实例变量
        self.name = name
        self.score = score

    def print_score(self):
        print("%s %s" % (self.name, self.score))

    def get_grade(self):
        if self.score >= 90:
            return "A"
        elif self.score >= 60:
            return "B"
        else:
            return "C"

    def __func(self):
        print(self.score)


stu31 = Student3("zhangsan", 50)
stu31.gender = "男"
print(stu31.name, stu31.score, stu31.gender)
print(Student3.name)
