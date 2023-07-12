#!/usr/bin/lua
---[=[
print "hi"
print [[nihao]]
print (type [[123]])

function add(a)
    local sum=0
    for i=1,#a do
        sum=sum+a[i]
    end
    return sum
end
print(add({1,3,5,7,9}))

function inc(n)
    n=n or 1
    print("参数n的值：".. n)
end
inc()   --> 1
inc(3)  --> 3
-- ]=]

---[[ 多返回值  多重赋值
tb={8,10,23,12,5}
function max(t)
    local mi=1
    local m=t[mi]
    for i = 1, #t do
        if t[i]>m then
            mi=i;
            m=t[i]
        end
    end
    return '最大值'..m,'下标为'..mi
end
print("first param",max(tb),"last param")   -->first param     最大值23        last param
print(max(tb),"last param")                 -->最大值23        last param
print("first param",max(tb))                -->first param     最大值23        下标为3

print(#{max(tb)})
print(#{1,max(tb)})
print(#{1,max(tb),2})
print()

-- ]]

---[[ 可变长参数函数
function test3(...)
    print(...)
    print(type({...}))
    for index, value in ipairs{...} do
        print(index,' ',value)
    end
    
end
-- test3({5},'1','2',3,{"one","two"})
test3('1','2','3','4','5')

function id( ... )
    return ...
end
print(id(1,'.',nil,2,3))    --> string
print({id(1,'.',nil,2,3)})  --> table

function fwrite( fmt,... )
    return io.write(string.format(fmt,...))
end

function test4( ... )
    local arg=table.pack(...)
    print("arg.n: ",arg.n)
    for i = 1, arg.n do
        print(i,' ',arg[i])        
    end
end

test4(1,2,nil,3)

print(select(1,"a","b","c","d","e"))
print(select(3,"a","b","c","d","e"))
print(select('#',"a","b","c","d","e"))
print()

function add( ... )
    local s=0
    for i = 1, select("#",...) do
        print(0+select(i,...)) --> ??? why equals i ?
        print(select(i,...))    --> ???
        
    end
    return s
end
print(add(1,2,3,4))
-- print(0+"1  2   3")
-- ]]

---[[ table.unpack()
print(type(table.unpack{10,20,30})) -->number
print(table.unpack{10,20,30})   --> 10  20  30
print(table.unpack({1,2,3,4,5},2,4))   --> 2   3   4

print(#table.pack(10,20,nil,30))
print(table.pack(10,20,nil,30))
-- ]]

---[[ 正确的尾调用
function g(y)
    --do something
end
function f(x)
    x=x+1;
    return g(x) -->尾调用
end

f(34)    -->尾调用g(x)返回时，直接返回到调用f(x)的地方

function foo( n )
    if n>0 then
        return foo(n-1) -->尾调用
    end
end
print(foo(2432840324))
-- ]]