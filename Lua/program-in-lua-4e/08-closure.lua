#!/usr/bin/lua
--[[ 像使用变量那样使用函数：函数可以被存储在全局变量中，可以被存储在表字段和局部变量中
-- 函数是第一类值
 foo=function (x)
    return 2*x
end
 function bar(y )
    return 3*y
end
print(foo(4))
print(bar(4))

 function derivative(f,delta)
    delta=delta or 1e-4
    return function (x)
        return (f(x+delta)-f(x))/delta
    end
end
print(derivative(math.sin)(5.2),math.cos(5.2))
-- ]]
--[[ 非全局函数  
function add(x,y) return x+y  end
function sub(x,y) return x-y  end
function mul(x,y) return x*y  end
function div(x,y) return x/y  end
    

Calc={
    ['add']=add,
    ['sub']=sub,
    ['mul']=mul,
    ['div']=div
}
function Calc.func1()
    print('test1')
end
print(Calc.add(2,3))
print(Calc['sub'](2,3))
print(Calc.mul(2,3))
print(Calc['div'](2,3))
Calc.func1()
--函数定义语法糖展开
-- local function fooo() body end
-- local fooo; fooo = function() body end

--间接递归函数
local f
local function g()
    f()
end
function f() --> 不能定义成local变量
    g()
end
-- ]]
---[[ 词法定界
function B()
    local a=1
    local b=2
    local c=3
    function A()
        print(a,b,c)  --> 函数A可以访问函数B的所有局部变量，这种特性叫做词法定界
    end
    A()
end
B()
--upvalue ，非局部变量
names={"Peter","Paul","Marry"}
grades={
    Marry=10,Peter=8,Paul=7
}
function sort_by_grade(names,grades)
    table.sort(names,
        function(n1,n2) -->grades是外层函数的形参，在本层函数中既不是全局变量，也不是局部变量
                        -->而是“非局部变量”，又被叫做“upvalue”    
            return grades[n1]>grades[n2]
        end
    )
end
print()
function new_counter()
    local count=0
    return function ( )
                count=count+1
                return count
            end    
end
c1=new_counter()
c2=new_counter()
print(c1())  --> 1
print(c1())  --> 2
print(c1())  --> 3
print(c2())  --> 1
print(c2())  --> 2
print(c2())  --> 3
print(new_counter()())  --> 1
print(new_counter()())  --> 1
print(new_counter()())  --> 1
print(new_counter()())  --> 1
print(new_counter()())  --> 1
-- 一个闭包就是【一个函数】外加能够使该函数正确【访问非局部变量】所需
-- 的其他【机制】
-- ]]