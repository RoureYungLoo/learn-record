package main

import "fmt"

func go_function() {
	println("========== 函数 ==========")
	/*
		func function_name( [parameter list] 此处为实际参数 ) [return_types] {
		   函数体
		}
		C语言中
			形参：在函数定义中出现的参数可以看做是一个占位符，它没有数据，只能等到函数被调用时接收传递进来的数据，所以称为形式参数，简称形参。
			实参: 函数被调用时给出的参数包含了实实在在的数据，会被函数内部的代码使用，所以称为实际参数，简称实参。
	*/

	var ret = max(12, 23) //实参
	fmt.Println("最大值：", ret)

	// 多返回值
	v1, v2 := swap("Google", "Baidu") //实参
	fmt.Println(v1, v2)

	// 传参方式: 值传递, 引用传递
	// Go语言默认使用值传递
	age1 := 20
	age2 := 30

	swap_int(age1, age2)

	println("交换后age1的值: ", age1)
	println("交换后age2的值: ", age2)

}

func max(num1, num2 int) int { //形参
	var res int
	if num1 >= num2 {
		res = num1
	}

	if num1 <= num2 {
		res = num2
	}
	return res
}

func swap(x, y string) (string, string) { //形参
	return y, x
}

func swap_int(x, y int) { //形参
	x, y = y, x //交换 x y 的值, 值传递不会对实参产生影响,形参是实参的副本
	println("\n在swap_int中,x=", x)
	println("在swap_int中,y=", y, "\n")
}
