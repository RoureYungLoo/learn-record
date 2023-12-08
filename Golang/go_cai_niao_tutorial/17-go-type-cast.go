package main

import (
	"fmt"
	"strconv"
)

func go_type_cast() {
	fmt.Println("========== go type cast ==========")
	/*  go 不支持隐式类型转换
	type(expression)
	*/

	// 数值类型转换  整数(浮点数)
	var sum = 17
	var count = 5
	var ret1, ret2 float32
	ret1 = float32(sum) / float32(count) //3.4
	ret2 = float32(sum / count)          //3
	fmt.Println(ret1)
	fmt.Println(ret2)

	// 字符串类型转换
	var age = "23"
	var num int
	num, err := strconv.Atoi(age) // 整数(字符串)
	if err == nil {
		fmt.Println(num)
	}

	var score float64 = 89.5
	var str_score string
	str_score = strconv.Itoa(int(score)) //字符串(整数)
	fmt.Println(str_score)

	str_score2, err := strconv.ParseFloat("123.45", 32) //浮点数(字符串)
	if err == nil {
		fmt.Println(str_score2)
	}

	// 字符串(浮点数)
	str_score = strconv.FormatFloat(score, 'f', 2, 64)
	fmt.Printf("%q\n", str_score)

	// 接口类型转换

}
