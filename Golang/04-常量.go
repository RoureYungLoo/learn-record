package main

import (
	"fmt"
	"unsafe"
)

// 自定义函数
func test(a int, b int) int {
	fmt.Println(a * b)
	return a * b
}

func const_variable() {
	fmt.Println("========== Golang 常量 ==========")

	/* 常量的特点
	1. 只读，程序运行期间不可被修改
	2. 声明必须初始化，因为第1点
	3. const identifier [type] = value，[type] 可以省略
	*/

	const DEFAULT_WID int = 10 //const DEFAULT_WID = 10
	const DEFAULT_HIT int = 5  //const DEFAULT_HIT = 5
	const con_v1, con_v2, con_v3 = "con1", 9999, true
	fmt.Println(DEFAULT_HIT*DEFAULT_WID, con_v1, con_v2, con_v3)

	// const 用作枚举类型
	const (
		Unknown = 0
		Female  = 1
		Male    = 2
	)
	fmt.Println(Unknown, Female, Male)
	test(Female, Male)

	// const test_val = test(3, 4) //常量表达式中，函数必须是内置函数
	// fmt.Println(test_val)
	const (
		name = "luruoyang"
		len  = len(name)
		size = unsafe.Sizeof(name)
	)
	println(name, len, size)

	// iota 一个可以被编译器修改的常量, 可理解为 const 语句块中的行索引
	const (
		iota_a = iota // 0
		iota_b = iota // 1
		iota_c = iota // 2
	)

	/* 简写如下
	const (
		iota_a = iota // 0
		iota_b // 1
		iota_c // 2
	)
	*/
	println(iota_a, iota_b, iota_c)

	// 实例1
	const (
		a = iota    // 0
		b           // 1
		c           // 2
		d = "ddddd" // ddddd
		e           // ddddd
		f = "fffff" // fffff
		g           // fffff
		h = iota    // 7
		i           // 8
	)
	println(a, b, c, d, e, f, g, h, i)

	// 实例2 【左移运算 <<n 等于 *(2^n)】
	const (
		j = 1 << iota // 1 << 0
		k = 3 << iota // 3 << 1
		l             // 3 << 2 , 这里简写了 3 << iota
		m             // 3 << 3 , 这里简写了 3 << iota
	)
	fmt.Println("j=", j) //     1
	fmt.Println("k=", k) //   110
	fmt.Println("l=", l) //  1100
	fmt.Println("m=", m) // 11000
}
