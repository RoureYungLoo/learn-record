package main

import (
	"fmt"
	"math"
)

// 闭包
func getSeq() func() int { //返回值是函数
	i := 0
	return func() int { //返回这个函数
		i++
		return i
	}
}

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

	swap_ref(&age1, &age2)
	fmt.Println(age1, age2)

	// 回调函数：函数作为另外一个函数的实参
	get_root := func(x float64) float64 {
		return math.Sqrt(x)
	}
	fmt.Println(get_root(9))

	// 闭包：匿名函数. 匿名函数是一种【没有函数名】的函数，通常用于在函数内部定义函数，或者作为函数参数进行传递。

	nextNum := getSeq()
	println(nextNum())
	println(nextNum())
	println(nextNum())

	another_counter := getSeq()
	println(another_counter())
	println(another_counter())

	add := func(a, b int) int { //匿名函数
		return a + b
	}

	ret = add(2, 3)
	println("2+3=", ret)

	mul := func(x, y int) int { //匿名函数
		return x * y
	}
	ret = mul(2, 3)
	println("2 x 3 =", ret)

	calculate := func(func_name func(int, int) int, x, y int) int { //func_name就是一个函数, 作为函数calculate的形参
		return func_name(x, y)
	}
	println("4 + 5 =", calculate(add, 4, 5)) // add 函数作为函数calculate的实参，即回调函数
	println("4 x 5 =", calculate(mul, 4, 5)) // mul 函数作为函数calculate的实参，即回调函数

	// 体会一下在调用函数的同时定义匿名函数
	diff := calculate(func(x, y int) int { return x - y } /* 定义匿名函数 */, 10, -6)
	println("10 - (-6) =", diff)

	// 方法：一个包含了接收者的函数. （面向对象）
	/*
		1. Go 语言中同时有函数和方法
		2. 一个方法就是一个包含了接受者的函数
		3. 接受者可以是【命名类型】或者【结构体类型】的一个【值】或者是一个【指针】
		4. 所有【给定类型】的方法属于【该类型】的方法集

		func (var_name var_type) func_name [ret_type]{
			// 函数体
		}
	*/

	var c1 Circle
	c1.radius = 10.05
	println("面积是：", c1.get_area())

}

// 结构体
type Circle struct {
	radius float64
}

// 该 method 属于 Circle 类型对象中的方法
func (C Circle) get_area() float64 {
	return 3.14 * C.radius * C.radius
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

// 值传递
func swap_int(x, y int) { //形参
	x, y = y, x //交换 x y 的值, 值传递不会对实参产生影响,形参是实参的副本
	println("\n在swap_int中,x=", x)
	println("在swap_int中,y=", y, "\n")
}

// 引用传递
func swap_ref(x *int, y *int) {
	var temp int
	temp = *x
	*x = *y
	*y = temp
}
