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
	/* 1.类型断言： 类型断言用于将[接口类型]转换为[指定类型]
	ret, ok := value.(type) 或者 value.(T)
	value 是接口类型的变量,type 或 T 是要转换成的类型。
		2.类型转换  */

	//类型断言
	var itf interface{} = "Hello World"
	str, ok := itf.(string)
	if ok {
		fmt.Println(str)
	} else {
		fmt.Println("conv failed")
	}

	/* 类型转换： 将一个接口类型的值value转换为另一个接口类型T: T(value)
	在类型转换中，必须保证要转换的[值]和[目标接口]类型之间是兼容的，否则编译器会报错*/

	var w Writer = &StringWriter{}
	sw := w.(*StringWriter) //类型转换, 将 w 转换为 StringWriter 类型
	sw.str = "HelloWorld"
	fmt.Println(sw.str)
}

// 接口
type Writer interface {
	Writer([]byte) (int, error)
}

// 结构体
type StringWriter struct {
	str string
}

func (sw *StringWriter) Writer(data []byte) (int, error) {
	sw.str += string(data)
	return len(data), nil
}
