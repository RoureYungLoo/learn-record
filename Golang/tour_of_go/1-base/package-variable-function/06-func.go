package main

import (
	"fmt"
	"math"
)

func go_func() {
	fmt.Println("========== go func ==========")
	/* 函数值
	函数也是值。它们可以像其它值一样传递
	函数值可以用作函数的参数或返回值
	*/

	hypot := func(x, y float64) float64 {
		return math.Sqrt(x*x + y*y)
	}
	fmt.Println(hypot(5, 12))
	fmt.Println(compute(hypot))
	fmt.Println(compute(math.Pow))

	// lamda表达式
	// 闭包：函数A引用了函数A外部变量B的函数A就是一个闭包
	// 该函数可以访问并赋予其引用的变量的值，换句话说，该函数被这些变量"绑定"在一起
	counter1 := counter()
	counter2 := counter()
	c1 := counter1()
	c2 := counter2()
	c2 = counter2()
	c2 = counter2()
	c2 = counter2()
	fmt.Println(c1)
	fmt.Println(c2)

	// 斐波那契
	f := fibonacci()
	for i := 0; i < 200; i++ {
		fmt.Printf("%d ", f())
	}
}

func compute(f func(float64, float64) float64) float64 {
	return f(3, 4) //调用f
}

func counter() func() int {
	sum := 0
	return func() int { //返回的这个函数引用了外部变量sum
		sum++
		return sum
	}
}

func fibonacci() func() int {
	x1, x2 := 0, 1
	sum := 0
	return func() int {
		sum = x1 + x2
		x1 = x2
		x2 = sum
		return sum
	}
}
