package main

import (
	"fmt"
)

/* 结构体：一组变量或常量的组合体

 */

type Vertex struct {
	X float64
	Y float64
}

func go_struct() {
	fmt.Println("========== go struct ==========")
	fmt.Println(Vertex{4.50, 5.40})
	var v Vertex
	v = Vertex{2.5, 6.2}
	// 访问结构体成员
	fmt.Printf("点的坐标是(%v,%v)\n", v.X, v.Y)
	// 结构体指针
	var ptr_v *Vertex
	ptr_v = &v
	fmt.Println(ptr_v.X, ptr_v.Y)       // 通过结构体指针访问结构体成员
	fmt.Println((*ptr_v).X, (*ptr_v).Y) //通过结构体指针访问结构体成员

	// 结构体赋值
	type Student struct {
		name   string
		age    int
		gender bool
	}
	var s1 Student
	s1 = Student{name: "zhangsan", gender: true}
	fmt.Println(s1)
	var (
		s2 = Student{"lisi", 23, false}
		s3 = Student{age: 21}
		p1 = &Student{gender: true}
	)
	fmt.Println(s2, s3, p1)

}
