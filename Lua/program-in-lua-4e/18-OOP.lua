#!/usr/local/bin/lua
Accout = {balance = 0}
function Accout.withdraw1(v)
    Accout.balance = Accout.balance - v
end
function Accout.withdraw2(self, v)
    self.balance = self.balance - v
end
-- 冒号隐藏参数self
function Accout:withdraw(v)
    self.balance = self.balance - v
end

function Accout:deposit(v)
    self.balance = self.balance + v
end
Accout.withdraw1(-100)
print(Accout.balance)

a = Accout
a.withdraw2(a, -100)
print(a.balance)
a:deposit(60)
print(a.balance)

local mt = {
    __index = Accout
}
-- function Accout.new(o)
--     o = o or {}
--     setmetatable(o, mt)
--     return o
-- end

-- 改进后
function Accout:new(o)
    o = o or {}
    self.__index = self --> ?
    setmetatable(o, self) --> ?
    return o
end

-- account_a = Accout.new {balance = 0}
account_a = Accout:new {balance = 0}
a:deposit(100)

local Accoutt = require "Account"

special_account = Accoutt:new()
s = special_account:new {limit = 1000}

function special_account:get_limit()
    return self.limit or 0
end

function special_account:withdraw(v)
    if v - self.balance >= self:get_limit() then
        error("透支额度不足")
    end
    self.balance = self.balance - v
end

-- s账户限额10%
function s:get_limit()
    return self.balance * 0.10
end
s:deposit(100)
s:withdraw(109)
-- s:withdraw(1100)
print(s.balance)

-- 多继承
-- 在plist中查找k
local function search(k, plist)
    for i = 1, #plist do
        local v = plist[i][k]
        if v then
            return v
        end
    end
end

function create_class(...)
    local derived_class = {}
    local base_class = {...}
    setmetatable( --在父类中查找类缺失的方法
        derived_class,
        {
            __index = function(t, k)
                return search(k, base_class)
            end
        }
    )

    -- 把derived_class作为其实例的元素
    derived_class.__index = derived_class

    -- derived_class 构造函数
    function derived_class:new(o)
        o = o or {}
        setmetatable(o, derived_class)
        return o
    end
    return derived_class
end

Named = {}
function Named:getname()
    return self.name
end

function Named:setname(n)
    self.name = n
end

NamedAccount = create_class(Account, Named)
account=NamedAccount:new {name = "Paul"}
print(account:getname())
local util=require"util"
local table_2_string=util.table_2_string
print(table_2_string(account.__index.__index.__index))