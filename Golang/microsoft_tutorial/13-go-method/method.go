package main

import (
	"fmt"
	"hellowrold/geo"
	"strings"
)

type datatype int

func main() {
	fmt.Println("====== method ======")
	// 面向过程：函数，
	// 面向对象：方法，对象的方法，接收者，消息，
	// 发送消息的一方是发送者，接受对象的一方是接收者
	// 消息：由接收者、方法名、参数表组成
	test_triangle()
	test_mystring()
	test_color()
	test_reload()
	test_encapsulation()
}

func (receiver datatype) MethodName(parameters ...datatype) {
	// 方法体
}

type triangle struct {
	edge int
}

func (obj triangle /* obj是接收者 */) GetPerimeter() int {
	return obj.edge * 3
}

func test_triangle() {
	tri := triangle{edge: 3}
	fmt.Println("周长是：", tri.GetPerimeter())
	tri.doubleSize()
	fmt.Println("周长是：", tri.GetPerimeter())

	squ := square{edge: 3}
	fmt.Println("周长是：", squ.GetPerimeter())
	squ.doubleSize()
	fmt.Println("周长是：", squ.GetPerimeter())
}

type square struct {
	edge int
}

func (obj square) GetPerimeter() int {
	return obj.edge * 4
}

// 按引用传参，即传递指针
func (obj *triangle) doubleSize() {
	obj.edge = obj.edge * 2
}

func (obj *square) doubleSize() {
	obj.edge *= 2
}

// 基本类型怎么自定义方法？

type mystring string

func (s mystring) upper() string {
	return strings.ToUpper(string(s))
}

func test_mystring() {
	ms := mystring("HellO World.")
	fmt.Println(ms.upper())

}

// 嵌入方法
type coloredTriangle struct {
	triangle
	color string
}

func test_color() {
	t := coloredTriangle{triangle{3}, "blue"}
	fmt.Println("size: ", t.edge)
	fmt.Println("周长: ", t.GetPerimeter())
	fmt.Println("size: ", t.triangle.edge)
	fmt.Println("周长: ", t.triangle.GetPerimeter())
}

// golang 编译器会自动添加如下包装器：
// func (t coloredTriangle) GetPerimeter() int {
// 	return t.triangle.GetPerimeter()
// }

// 重载方法
func (t coloredTriangle) GetPerimeter() int {
	return t.edge * 3 * 2
}

func test_reload() {
	t := coloredTriangle{triangle{3}, "blue"}
	fmt.Println("size: ", t.edge)
	fmt.Println("周长：", t.GetPerimeter())
	fmt.Println("tri 周长：", t.triangle.GetPerimeter())
}

// 方法封装： 仅在包与包之间有效
func test_encapsulation() {
	t := geo.Triangle{}
	t.SetEdge(3)
	fmt.Println("geo 包，周长：", t.GetPerimeter())
	// fmt.Println(t.edge) //.\method.go:115:16: t.edge undefined (type geo.Triangle has no field or method edge)
}
