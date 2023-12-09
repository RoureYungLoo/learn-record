package main

import (
	"fmt"
)

func go_interface() {
	fmt.Println("========== go interface ==========")
	/* go语言中接口的实现是[隐式]的: 如果类型 Type_A 实现了接口 Itf_B 的所有方法，那么类型
		Type_A 就自动地实现了接口 Itf_B
	接口类型变量可以存储任何实现了该接口的类型的值
	*/
	var phone Phone
	phone = new(iPhone)
	phone.call()
	phone = new(hwPhone)
	phone.call()

	var shapee Shape
	shapee = Rect{name: "矩形", width: 12.5, height: 23.7}
	shapee.print_area()
	shapee = Circ{name: "圆形", radius: 23.6}
	shapee.print_area()
}

/*
// 定义接口
type interface_name interface {
	method1() int
	method2([]string) (int, string)
	method3([]int, int) (int, error)
	method4() (int, []int)
	// ...
	//methodN(params) (rets)
}

// 定义结构体
type struct_name struct {
	var1 int
	var2 string
	var3 float32
	// ...
}

// 实现接口的方法
func (sn struct_name) method1() int {
	return 1
}

// ...
func (sn struct_name) methodN() (int, []int) {
	return 0, nil
}
*/
// 接口
type Phone interface {
	call()
}

// 结构体
type iPhone struct {
}

// 实现接口的call方法
func (ip iPhone) call() {
	fmt.Println("我是iPhone,我实现了call()方法")
}

// 结构体
type hwPhone struct {
}

// 实现接口的call方法

func (hp hwPhone) call() {
	fmt.Println("我是华为手机,我也实现了call()方法")
}

// ========
type Shape interface { //定义接口
	print_area() //接口的方法
}
type Rect struct { //定义结构体
	name   string
	width  float64
	height float64
}
type Circ struct { //定义圆形
	name   string
	radius float64
}

func (rt Rect) print_area() { //实现结构体的方法
	fmt.Println(rt.name, " 的面积是：", rt.height*rt.height)
}
func (c Circ) print_area() { //实现结构体的方法
	fmt.Println(c.name, " 的面积是：", 3.14*c.radius*c.radius)
}
