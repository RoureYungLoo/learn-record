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
