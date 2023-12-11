package main

/* import (
	"fmt"
	"math/rand"
)
*/

import (
	"fmt"
	"math"
	"math/cmplx"
)

/*
每个 Go 程序都是由包构成的。
程序从 main 包开始运行。
按照约定，包名与导入路径的最后一个元素一致。例如，"math/rand" 包中的源码均以 package rand 语句开始。
*/

/*
在 Go 中，如果一个名字以大写字母开头，那么它就是已导出的;如果一个名字以小写字母开头，那么它就是未导出的。
任何"未导出"的名字在该包外均无法访问。
*/
func main() {
	// fmt.Println("My favorite number is", rand.Intn(10))
	// // fmt.Printf("Now you have %g problems.\n", math.Sqrt(7))
	// fmt.Println(math.Pi)

	// fmt.Println(func1(1, 2, 3))
	// fmt.Println(func1(11, 22, 33))

	// fmt.Println(swap("hello", "world"))

	// fmt.Println(split(23))

	// var_test()

	// shor_var_test()

	// test_base_data_type()

	// test_zero_value()

	// test_type_cast()

	// test_auto_infer()

	// test_const()

	// test_numerical_const()

	// test_flow_control()

}

/*
go 函数
go 函数可以没有参数或接受多个参数
go 函数可以返回【任意数量】的返回值
*/
// func func1(x int, y int, z int) (int, int) { /* 注意类型在变量名之后 */
// 当连续两个或多个函数的形参类型相同时，除最后一个类型以外，其它都可以省略
func func1(x, y, z int) (int, int) { /* 注意类型在变量名之后 */
	return x + y, y + z
}

func swap(x, y string) (string, string) {
	return y, x
}

/* 命名返回值
Go 的返回值可被命名，它们会被视作定义在函数顶部的变量。
返回值的名称应当具有一定的意义，它可以作为文档使用。
没有参数的 return 语句返回已命名的返回值。也就是 直接 返回。
直接返回语句应当仅用在下面这样的短函数中。在长的函数中它们会影响代码的可读性。
*/
// func split(sum int) (x int,y int)  {
func split(sum int) (x, y int) {
	x = sum * 4 / 9
	y = sum - x
	return
}

// 变量
/*
var 语句用于声明一个变量列表，跟函数的参数列表一样，类型在最后。
就像在这个例子中看到的一样，var 语句可以出现在包或函数级别。
*/
// var c, python, java bool
var c, python, java = true, false, "no!"

func var_test() {
	var i, j int = 1, 2
	fmt.Println(c, java, python, i, j)
}

//
/* 短变量声明
在函数中，简洁赋值语句 := 可在类型明确的地方代替 var 声明。
函数外的每个语句都必须以关键字开始（var, func 等等），因此 【:=】结构【不能在函数外使用】 */
func shor_var_test() {
	age := 23
	c, java, python := "c", "java", "python"
	fmt.Println(age, c, java, python)
}

// 基本数据类型
/*
bool
string

int  int8  int16  int32  int64  // int, uint 和 uintptr 在 32 位系统上通常为 32 位宽在 64 位系统上则为 64 位宽。 当你需要一个整数值时应使用 int 类型，除非你有特殊的理由使用固定大小或无符号的整数类型。
uint uint8 uint16 uint32 uint64 uintptr

byte // uint8 的别名
rune // int32 的别名
    // 表示一个 Unicode 码点

float32 float64
complex64 complex128
*/
var (
	ToBe   bool       = false
	MaxInt uint64     = 1<<64 - 1
	z      complex128 = cmplx.Sqrt(-5 + 12i)
)

func test_base_data_type() {
	fmt.Printf("Type: %T Value: %v\n", ToBe, ToBe)
	fmt.Printf("Type: %T Value: %v\n", MaxInt, MaxInt)
	fmt.Printf("Type: %T Value: %v\n", z, z)
}

// 零值  没有明确初始值的变量会被赋予他们的零值
func test_zero_value() {
	var i int
	var f float64
	var b bool
	var s string
	var arr [5]int
	var mapp map[string]int
	fmt.Printf("%v %v %v %q %v %v", i, f, b, s, arr, mapp)
}

// 类型转换 表达式 T(v) 将值 v 转换为类型 T
func test_type_cast() {
	var x, y int = 3, 4
	var f float64 = math.Sqrt(float64(x*x + y*y))
	var z uint = uint(f)
	fmt.Println(x, x, z)
}

// 类型推导 声明一个变量而不指定其类型,变量的类型由右值推导得出
func test_auto_infer() {
	// v := 4.3 + 3i
	// v := make(chan int)
	// v := make(map[int]string)
	v := test_type_cast
	fmt.Printf("%v 的类型是 %T\n", v, v)
}

// 常量 常量可以是字符、字符串、布尔值或数值;常量不能用 := 语法声明
const Pi = 3.1415926
const H = "你好 "
const W = " 世界！"

func test_const() {
	fmt.Println(H + W)
}

// 数值常量
const (
	Big   = 1 << 100
	Small = Big >> 99
)

func test_numerical_const() {
	fmt.Println(need_int(Small))
	fmt.Println(need_float(Small))
	fmt.Println(need_float(Big))
}

func need_int(x int) int           { return x*10 + 1 }
func need_float(x float64) float64 { return x * 0.1 }
