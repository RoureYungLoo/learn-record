#!/usr/local/bin/lua

luasql= require "luasql.mysql"

env=luasql.mysql()

conn=env:connect("test","root","lry216216","172.26.143.243",3309)

conn:execte"SET NAMES UTF8"

cur=conn:execte("select * form role")

row=cur:fetch({},"a")

file = io.open("role.txt","w+");
while row do 
    var =string.format("%d %s\n",row.id,row.name)
    print(var)
    file:write(var)
    row=cur:fetch(row,"a")
end

file:close()
conn:close()
env:close()