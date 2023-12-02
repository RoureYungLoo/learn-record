package main

import "fmt"

func variable() {
	var date string = "2023-12-02"
	var age, time int = 23, 170000000
	fmt.Println("date ", date)
	var res string = fmt.Sprintf("age=%d,time=%d", age, time)
	fmt.Println(res)

	/* 变量声明 1：声明+初始化
	var [name] [type]
	[name] = [value]
	*/
	var site string
	site = "https://www.baidu.com"

	var score float64
	var gender bool

	fmt.Println("site: ", site)
	fmt.Println("score: ", score)
	fmt.Println("gender: ", gender)

	/*
		数值类型（包括complex64/128）为 0
		布尔类型为 false
		字符串为 ""（空字符串）
	*/

	var interger_ int
	var float_ float32
	var bool_ bool
	var string_ string
	fmt.Printf("%v %v %v %q\n", interger_, float_, bool_, string_)

	/* 变量声明 2：
	var name = value
	*/
	var name = "luruoyang"
	fmt.Println(name)

	/* 变量声明 3：自动推导类型，声明并初始化（"声明+初始化"的简写）,只能在函数体中出现
	name := value
	*/
	address := "shanghai" //相当于 var address; address = "shanghai"
	fmt.Println(address)

	/* 变量声明 4：多变量声明
	 */
	//类型相同多个变量, 非全局变量
	var var1, var2, var3 int
	var1, var2, var3 = 11, 22, 33
	fmt.Println(var1, var2, var3)

	var var4, var5, var6 = 44, 55, 66
	fmt.Println(var4, var5, var6)

	var7, var8, var9 := "val7", "val8", "val9"
	fmt.Println(var7, var8, var9)

	//类型不相同多个变量, 非全局变量
	var var44, var55, var66 = 44, "55", false
	fmt.Println(var44, var55, var66)

	var77, var88, var99 := 77, "val8", true
	fmt.Println(var77, var88, var99)

	// 声明全局变量常用此方式
	var (
		global_var1 int
		global_var2 string = "empty"
		global_var3 bool
	)
	fmt.Println(global_var1, global_var2, global_var3)

	// 值类型和引用类型，注意引用类型的深浅拷贝
	// 值类型变量的值存储在堆中
	var value string = "123"
	fmt.Println(&value)

	// 初始化声明，自动推导类型
	int_var, string_var, bool_var := 12, "string", true
	fmt.Println(int_var, string_var, bool_var)

	// [局部变量] 未使用的局部变量会导致编译错误
	// var unused_var int = 123 //./03-变量.go:88:6: unused_var declared and not used

	//【全局变量】未使用的全局变量【不会】导致编译错误
	var width, height int
	var category string
	width, height, category = 100, 200, "cate1" // 如果没有前面两行的var声明，可以这样：width, height, category := 100, 200, "cate1"，即 并行赋值 或 同时赋值
	fmt.Println(width, height, category)

	//变量交换, 类型相同是前提
	var baidu, google = "https://www.baidu.com", "https://www.google.com"
	baidu, google = google, baidu
	fmt.Println(baidu, google)

	//变量丢弃，_ , 下划线是一个只写变量
	_, google = 5, "7" //5会被丢弃
	fmt.Println(google)

}
