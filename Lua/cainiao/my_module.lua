my_module={}

my_module.const_var1="常量1"

function my_module.func1()
    io.write("公有func1\n")
end

local function func2()
    print("私有函数func2")
end

function my_module.func3()
    func2()
end

return my_module