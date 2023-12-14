package main

import (
	"fmt"
	"math"
)

func go_interface() {
	fmt.Println("========== go interface ==========")

	var a Abser
	f := MyFloat(-math.Sqrt2) // f:=float64(-math.Sqrt2)
	v := Vertex{3, 4}

	a = f
	a = &v

	a = v
	fmt.Println(a.Abs())

	// Srt类型实现了接口itfc
	var inter itfc = Srt{"Hi"}
	inter.Mthd()

	// 接口值：可以看做包含值value和具体数据类型type的元组：(value, type)
	// 接口值保存了一个具体底层类型的具体值。
	// 接口值调用方法时会执行其底层类型的同名方法
	var sh1 SayHi
	sh1 = &Person{"lisi"}
	describe(sh1)
	sh1.M_Hi()
	sh1.M_Run("公园")
	sh1.M_Dance("芭蕾")

	var sh2 SayHi
	sh2 = Dog{"tidy"}
	describe(sh2)
	sh2.M_Hi()
	sh2.M_Dance("小草")
	sh2.M_Run("小路")

	// 底层值为nil的接口
	var iabser Abser
	var pp *Person
	iabser = pp
	describe2(iabser)

	//nil接口值：既不保存值也不保存具体类型
	var i3 Abser
	describe2(i3)
	i3.Abs() //(<nil>, <nil>)  panic: runtime error: invalid memory address or nil pointer dereference

	// 空接口

}

func (f MyFloat) Abs() float64 {
	if f < 0 {
		return float64(-f)
	}
	return float64(f)
}

// 一组方法签名定义的集合;接口类型的变量可以保存任何实现了这些方法的值
type Abser interface {
	Abs() float64
}

// type Vertex struct{
// 	X,Y float64
// }

// func (v *Vertex) Abs() float64{
// 	return math.Sqrt(v.X*v.X+v.Y*v.Y)
// }

type itfc interface {
	Mthd()
}

type Srt struct {
	member1 string
}

// 隐式接口实现
func (obj Srt) Mthd() {
	fmt.Println(obj.member1)

}

// 接口
type SayHi interface {
	M_Hi()
	M_Dance(t string)
	M_Run(w string)
}

// 结构体
type Person struct {
	name string
}

type Dog struct {
	dogname string
}

// person实现接口sayhi
func (obj *Person) M_Hi() {
	fmt.Println("HI, I'm " + obj.name)
}

func (obj *Person) M_Dance(t string) {
	fmt.Println(obj.name + " 正在跳 " + t)
}

func (obj *Person) M_Run(w string) {
	fmt.Println(obj.name + " 正在 " + w + " 跑步")
}

// Dog 实现接口sayhi
func (obj Dog) M_Hi() {
	fmt.Println("HI, I'm " + obj.dogname)
}

func (obj Dog) M_Dance(t string) {
	fmt.Println(obj.dogname + " 正在吃 " + t)
}

func (obj Dog) M_Run(w string) {
	fmt.Println(obj.dogname + " 正在 " + w + " 闲逛")
}
func describe(i SayHi) {
	fmt.Printf("(%v, %T)\n", i, i)
}

// 即便接口内的具体值为 nil，方法仍然会被 nil 接收者调用。
func (obj *Person) Abs() float64 {
	if obj == nil {
		fmt.Println("<nil>")
		return 1.0
	}
	fmt.Println(obj.name)
	return 1.0
}

func describe2(i Abser) {
	fmt.Printf("(%v, %T)\n", i, i)
}
