#!/usr/local/bin/lua


-- file = io.open (filename [, mode])
-- r	以只读方式打开文件，该文件必须存在。
-- w	打开只写文件，若文件存在则文件长度清为0，即该文件内容会消失。若文件不存在则建立该文件。
-- a	以附加的方式打开只写文件。若文件不存在，则会建立该文件，如果文件存在，写入的数据会被加到文件尾，即文件原先的内容会被保留。（EOF符保留）
-- r+	以可读写方式打开文件，该文件必须存在。
-- w+	打开可读写文件，若文件存在则文件长度清为零，即该文件内容会消失。若文件不存在则建立该文件。
-- a+	与a类似，但此文件可读可写
-- b	二进制模式，如果文件是二进制文件，可以加上b
-- +	号表示对文件既可以读也可以写

-- io.read() 参数
-- "*n"	读取一个数字并返回它。例：file.read("*n")
-- "*a"	从当前位置读取整个文件。例：file.read("*a")
-- "*l"（默认）	读取下一行，在文件尾 (EOF) 处返回 nil。例：file.read("*l")
-- number	返回一个指定字符个数的字符串，或在 EOF 时返回 nil。例：file.read(5)

-- io.tmpfile():返回一个临时文件句柄，该文件以更新模式打开，程序结束时自动删除
-- io.type(file): 检测obj是否一个可用的文件句柄
-- io.flush(): 向文件写入缓冲中的所有数据
-- io.lines(optional file name): 返回一个迭代函数，每次调用将获得文件中的一行内容，当到文件尾时，将返回 nil，但不关闭文件。

-- 简单模式 使用标准的 I/O 或使用一个当前输入文件和一个当前输出文件。
-- file=io.open("test.db","r")
-- io.input(file)

-- print(io.read())
-- io.close(file)

-- file=io.open("test.db","a")
-- io.output(file)
-- io.write("this is second line.")
-- io.close(file)

-- 完全模式 在同一时间处理多个文件
-- file:read() 参数同io.read()
-- file:seek(optional whence, optional offset): 设置和获取当前文件位置,成功则返回最终的
-- 文件位置(按字节),失败则返回nil加错误信息。参数 whence 值可以是:
-- "set": 从文件头开始
-- "cur": 从当前位置开始[默认]
-- "end": 从文件尾开始
-- offset:默认为0
-- 不带参数file:seek()则返回当前位置,file:seek("set")则定位到文件头,file:seek("end")则
-- 定位到文件尾并返回文件大小
-- file:flush(): 向文件写入缓冲中的所有数据
-- io.lines(optional file name): 打开指定的文件 filename 为读模式并返回一个迭代函数，每次
-- 调用将获得文件中的一行内容，当到文件尾时，将返回 nil，并自动关闭文件。
-- 若不带参数时io.lines() <=> io.input():lines(); 读取默认输入设备的内容，但结束时不关闭
-- 文件

fname="test.db"
-- mode="r"
-- file=io.open(fname,mode)
-- print(file:read())
-- file:close()
-- mode="a"
-- file=io.open(fname,mode)
-- msg="this is the third msg"
-- file:write(msg)
-- file:close()

file=io.read(fname,"r")
file:seek("end",-5)
print(file:read("*a"))
file:close()