package main

import (
	"fmt"
	"runtime"
	"time"
)

func test_flow_control() {
	// test_for()
	// test_while()
	// test_unlimited_loop()
	// test_if()
	// test_newton(83235423)
	defer test_defer(1)
	defer test_defer(2)
	defer test_defer(3)
	test_switch()

}

func test_for() {
	sum := 0
	// for [循环变量初始化];循环条件;[循环变量增加]，循环变量作用域为for语句
	for i := 0; i < 10; i++ {
		sum += i
	}
	println(sum)
	for sum < 100 { //while语句
		sum += sum
	}
	println(sum)
}
func test_while() { //while语句
	sum := 1
	for sum < 500 {
		sum += sum
	}
	println(sum)
}

func test_unlimited_loop() {
	for {
		println(1)
	}
}

func test_if() {
	x := 5
	if x == 5 {
		println("x=5")
	} else if x > 5 {
		println("x>5")

	} else if x < 5 {
		println("x<5")
	}

	if age := 26; age < 25 {
		println("age< 25")
	} else {
		println("age> 25,", age)
	}
	// println(age) //undefined: age
}

func test_newton(x float64) {
	z := float64(1)
	arr := [2]float64{0, 0}
	for i := 0; i < 1000; i++ {
		z -= (z*z - x) / (z * 2)

		arr[i%2] = z

		if arr[0] == arr[1] {
			break
		}

		fmt.Println(z)
	}
	// fmt.Println(arr)
}

// Golang会在每个case语句的最后面添加一行 break 语句
// 除非以 fallthrough 语句结束，否则分支会自动终止
// switch 的 case 无需为常量，且取值不必为整数
func test_switch() {
	fmt.Println("机器平台")
	switch os := runtime.GOOS; os {
	case "darwin":
		println(os)
	case "linux":
		println(os)
	default:
		fmt.Printf("%s. \n", os)
	}

	// case 语句从上到下顺次执行，直到匹配成功时停止
	fmt.Println("When Sat.?")
	today := time.Now().Weekday()
	switch time.Saturday {
	case today + 0:
		println("今天是周六")
	case today + 1:
		println("明天")
	case today + 2:
		println("后天")
	case today + 2:
		println("大后天")
	default:
		println("太遥远了")
	}

	// 没有条件的switch语句
	t := time.Now()
	switch {
	case t.Hour() < 12:
		println("早上好")
	case t.Hour() < 17:
		println("下午好")
	default:
		println("晚上好")
	}
}

// 延迟调用，参数会立即求值，但直到外层函数返回前该函数都不会被调用
func test_defer(level int) {
	println("延迟调用栈", level)
	for i := 0; i < 5; i++ {
		defer println("延迟调用栈", i)
	}
}
