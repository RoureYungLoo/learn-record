package main

import (
	"fmt"
	"math"
)

func go_method() {
	fmt.Println("========== go method ==========")
	/* golang 没有类
	方法就是一类带特殊的 接收者 参数的函数。
	方法接收者在它自己的参数列表内，位于 func 关键字和方法名之间。

	1. 接收者的类型定义和方法声明必须在同一包内
	2. 不能为内建类型声明方法
	*/
	var i Vertex
	i = Vertex{3, 4}
	fmt.Println(i.Abs()) //5
	fmt.Println(Abs2(i))

	var score MyFloat
	score = -93.5
	fmt.Println(score.Abs3())

	i.Scale(2.5)         // Golang会自动将语句 i.Scale(5) 解释为 (&i).Scale(5)
	fmt.Println(i.Abs()) // 12.5
	Scale(&i, 2)
	fmt.Println(i.Abs()) // 25
	p := &i
	p.Scale(3)
	fmt.Println(p.Abs()) // Golang会自动将语句 p.Abs() 解释为 （*p).Abs()

	vtx := &Vertex{3, 4}
	fmt.Printf("1 %+v, Abs: %v\n", vtx, vtx.Abs3())
	vtx.Scale(5)
	fmt.Printf("1 %+v, Abs: %v\n", vtx, vtx.Abs3())

}

type Vertex struct {
	X float64
	Y float64
}

// 这个是方法
func (recver Vertex /*接收者*/) Abs() float64 {
	// 方法只是个带[特殊]接收者参数的函数
	return math.Sqrt(recver.X*recver.X + recver.Y*recver.Y)
}

// 一般函数
func Abs2(recver Vertex) float64 {
	return math.Sqrt(recver.X*recver.X + recver.Y*recver.Y)
}

type MyFloat float64

func (r MyFloat) Abs3() float64 {
	if r < 0 {
		return float64(-r)
	}
	return float64(r)
}

// 指针接收者
// 以指针为接收者的方法被调用时，接收者既能为值又能为指针
func (ptr *Vertex /*指针接收者, 不能是内建类型的指针*/) Scale(f float64) {
	ptr.X = ptr.X * f
	ptr.Y = ptr.Y * f
}

func (ptr *Vertex) Abs3() float64 {
	return math.Sqrt(ptr.X*ptr.X + ptr.Y*ptr.Y)
}
func Scale(v *Vertex, f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}
