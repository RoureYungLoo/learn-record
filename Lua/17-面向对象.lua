#!/usr/local/bin/lua

-- 面向对象：封装、继承、多态、抽象
-- lua中的面向对象可以用table+function模拟出来
-- 继承可以通过metatable模拟（不推荐）
-- Accout={balance=0}
-- function Accout.func1(v)
--     Accout.balance=Accout.balance-v
-- end
-- Accout.func1(100.0)
-- print(Accout.balance)

Rectangle={area=0,length=0,width=0}

-- function Rectangle:new(o,len,width)
--     o=o or {}
--     setmetatable(o,self)
--     self.__index=self
--     self.length=len or 0
--     self.width=width or 0
--     self.area=len*width;
--     return o
-- end

-- function Rectangle:printArea()
--     print("矩形的面积：",self.area)
-- end

-- r=Rectangle:new(nil,10,20)
-- print(r.length)
-- r:printArea()

Shape={area=0}

function Shape:new(o,side)
    o=o or {}
    setmetatable(o,self)
    self.__index=self
    side=side or 0
    self.area=side*side;
    return o
end

function Shape:printArea()
    print("面积为：",self.area)
end

myshape=Shape:new(nil,10)
myshape:printArea()

Square=Shape:new()
function Square:new(o,side)
    o=o or Shape:new(o,side)
    setmetatable(o,self)
    self.__index=self
    return o
end

function Square:printArea()
    print("正方形面积为：",self.area)
end

mysquare=Square:new(nil,10)
mysquare:printArea()

function Rectangle:new(o,len,width)
    o=o or Shape:new(o)
    setmetatable(o,self)
    self.__index=self
    self.area=len*width
    return o
end

function Rectangle:printArea()
    print("矩形面积：",self.area)
end

mytang=Rectangle:new(nil,10,30)
mytang:printArea()

-- 函数重写
function Square:printArea()
    print("正方形面积：",self.area)
end
