package main

import (
	"fmt"
	"math"
	"os"
	"strconv"
)

var file_name1, file_name2, file_name3 string // , age int 会报错
var age int

// var (
// 	file1, file2 string
// 	age1, age2          int
// )

// var (
// 	file1      string = "file1"
// 	file2      string = "file2"
// 	age1, age2 int    = 20, 25
// )

// var ( //注意奥，这里不是:=
// 	file1, file2 = "file1", "file2"
// 	age1, age2   = 20, 25
// )

// var (
// 	file1, file2, age1, age2 = "john", "tom", 23, 25
// )

const OK = 200

const (
	StatusOK = 200
	// StatusReset // 200
	// StatusErr // 200

	StatusReset = 201
	StatusErr   = 202

	// iota ???
)

// 整型
var (
	integer8  int8  = 127
	integer16 int16 = 32767
	integer32 int32 = 2147483647
	integer64 int64 = 9223372036854775807
)

// 布尔型
var flag bool = true //在 Go 中，不能将布尔类型隐式转换为 0 或 1

var firstName = "John"

// 默认值
var def_int int
var def_f32 float32
var def_f64 float64
var def_bool bool
var def_str string

// 如果创建的是 Go 包，则无需编写 main() 函数

// Go 中的所有可执行程序都具有 main() 函数
func main() { // 无任何参数，无任何返回
	fmt.Println("Hello World!")
	// := 只能在函数的内部使用，不能暴露在函数外部
	file1, file2 := "file1", "file2"
	age1, age2 := 23, 25
	fmt.Println(file_name1)
	fmt.Println(file_name2)
	fmt.Println(file_name3)
	fmt.Println(age)
	fmt.Println(file1, file2, age1, age2)
	fmt.Println(OK)
	fmt.Println(StatusOK)
	fmt.Println(StatusReset)
	fmt.Println(StatusErr)

	// var integer32 int = 214748364812
	fmt.Println(integer32)
	fmt.Println(integer8, integer16, integer32, integer64)
	// fmt.Println(integer16 + integer32) // invalid operation: integer16 + integer32 (mismatched types int16 and int32)
	rune := "A"
	fmt.Println(rune)

	var i32 int = 2147483648
	fmt.Println(i32)

	var iuint uint = 10
	fmt.Println(iuint)

	// 浮点型
	fmt.Println(math.MaxFloat32)
	fmt.Println(math.MaxFloat64)

	fmt.Println(flag)

	// 字符串
	lastName := "Done"
	fmt.Println(firstName, lastName)

	fullName := firstName + lastName + "\t" + "alias" + "\"" + "\n"
	fmt.Println(fullName)

	fmt.Println(def_int, def_f32, def_f64, def_bool, def_str)

	// 类型转换
	fmt.Println(int32(integer16) + integer32)
	i, _ := strconv.Atoi("-42") // _ ：只写变量，不能读取
	S := strconv.Itoa(-42)
	fmt.Println(i, S)

	// 获取命令行参数
	param1, err1 := strconv.Atoi(os.Args[1])
	param2, err2 := strconv.Atoi(os.Args[2])
	if err1 != nil {
		fmt.Println("参数 1 获取失败")
	}
	if err2 != nil {
		fmt.Println("参数 2 获取失败")
	}
	fmt.Println(param1, err1)
	fmt.Println(param2, err2)
	sum := sum(os.Args[1], os.Args[2])
	fmt.Println(sum)
	sum = sum2(os.Args[3], os.Args[4])
	fmt.Println(sum)

	res1, res2, res3, res4 := caculator(float64(param1), float64(param2))
	fmt.Println(res1)
	fmt.Println(res2)
	fmt.Println(res3)
	fmt.Println(res4)

	// 引用传参
	addr := "旧地址"
	update_address(&addr) // 指针类型的形参 需要接收 地址类型的实参
	fmt.Println(addr)

}

// 函数
func sum(n1 string, n2 string) int {
	int1, _ := strconv.Atoi(n1)
	int2, _ := strconv.Atoi(n2)
	return int1 + int2
}

// 函数
func sum2(n1 string, n2 string) (ret int) {
	int1, _ := strconv.Atoi(n1)
	int2, _ := strconv.Atoi(n2)
	ret = int1 + int2
	return
}

// 多返回值函数
func caculator(p1 float64, p2 float64) (add float64, div float64, mul float64, sub float64) {
	add = p1 + p2
	sub = p1 - p2
	mul = p1 * p2
	div = p1 / p2
	return
}

// 函数传参方式：默认是值传递，支持引用传递
func update_address(p_addr *string) {
	*p_addr = "新地址"
}
