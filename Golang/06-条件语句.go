package main

import (
	"fmt"
	"time"
)

// import "golang.org/x/text/cases"

func golang_condition() {
	println("========== 条件语句 ==========")
	// Golang 没有三目运算符 ：？
	// if
	/*
		if 布尔表达式 {
		    // 在布尔表达式为 true 时执行
		}
	*/
	var condition bool
	if !condition {
		println("true")
	}
	// if else
	/*
		if 布尔表达式 {
		    //在布尔表达式为 true 时执行
		} else {
			//在布尔表达式为 false 时执行
		}
	*/
	var age = 25
	if age < 25 {
		println("age<25")
	} else {
		println("age>=25")
	}
	// if nested
	if age < 25 {
		println("age<25")
	} else if age > 25 {
		println("age>25")
		if condition {

		} else if condition {

		}
	} else if age == 25 {
		println("age=25")
		if condition {

		} else if condition {
			if condition {

			}
		}
	}

	// switch  默认情况下 case 最后自带 break 语句，匹配成功后就不会执行其他 case，如果我们需要执行后面的 case，可以使用 fallthrough 。
	/*
		switch var1 {
		    case val1:
		        ...
		    case val2:
		        ...
		    default:
		        ...
		}
	*/
	var grade string = "B"
	var marks int = 90

	switch marks {
	case 90:
		grade = "A"
	case 80:
		grade = "B"
	case 50, 60, 70:
		grade = "C"
	default:
		grade = "D"
	}

	println("您的等级是：", grade)
	switch grade {
	case "A":
		println("优秀")
		fallthrough //使用 fallthrough 会强制执行后面的 case 语句，fallthrough 不会判断下一条 case 的表达式结果是否为 true。
	case "B":
		println("良好")
		fallthrough
	case "C":
		println("良好")
	case "D":
		println("及格")
	case "F":
		println("不及格")
	default:
		println("您的成绩很差")
	}

	switch {
	case grade == "A":
		fmt.Printf("优秀!\n")
	case grade == "B", grade == "C":
		fmt.Printf("良好\n")
	case grade == "D":
		fmt.Printf("及格\n")
	case grade == "F":
		fmt.Printf("不及格\n")
	default:
		fmt.Printf("差\n")
	}
	fmt.Printf("你的等级是 %s\n", grade)

	// type switch 判断某个 interface 变量中实际存储的变量类型
	var x interface {
	}
	switch i := x.(type) {
	case nil:
		fmt.Printf("x 的类型是 %T\n", i)
	case int:
		fmt.Printf("x 是 int 型")
	case float64:
		fmt.Printf("x 是 float64 型")
	case bool, string:
		fmt.Printf("x 是 bool 或 string 型")
	default:
		fmt.Printf("未知型")
	}

	switch {
	case false:
		fmt.Println("1、case 条件语句为 false")
		fallthrough
	case true:
		fmt.Println("2、case 条件语句为 true")
		fallthrough
	case false:
		fmt.Println("3、case 条件语句为 false")
		fallthrough
	case true:
		fmt.Println("4、case 条件语句为 true")
	case false:
		fmt.Println("5、case 条件语句为 false")
		fallthrough
	default:
		fmt.Println("6、默认 case")
	}

	// select 随机执行一个可运行的case。如果没有case可运行，它将阻塞，直到有case可运行。
	/*
		select 语句只能用于通道操作，每个 case 必须是一个通道操作，要么是发送要么是接收。
		select 语句会监听所有指定的通道上的操作，一旦其中一个通道准备好就会执行相应的代码块。
		如果多个通道都准备好，那么 select 语句会随机选择一个通道执行。如果所有通道都没有准备好，那么执行 default 块中的代码。
	*/

	/*
		select {
		case <-channel1:
			// 执行的代码
		case value := <-channel2:
			// 执行的代码
		case channel3 <- value:
			// 执行的代码

			// 你可以定义任意数量的 case

		default:
			// 所有通道都没有准备好，执行的代码
			// 如果没有 default 子句，select 将阻塞，直到某个通道可以运行
			// Go 不会重新对 channel 或值进行求值
		}
	*/
	// 定义通道
	chn1 := make(chan string)
	chn2 := make(chan string)

	// 启动协程 goroutine 分别从两个通道中获取数据
	go func() {
		time.Sleep(1 * time.Second)
		chn1 <- "one"
	}()
	go func() {
		time.Sleep(2 * time.Second)
		chn2 <- "two"
	}()

	for i := 0; i < 2; i++ {
		select {
		case msg1 := <-chn1:
			fmt.Println("收到：", msg1)
		case msg2 := <-chn2:
			fmt.Println("收到：", msg2)
		}
	}

	ch1 := make(chan string)
	ch2 := make(chan string)
	go func() {
		for {
			time.Sleep(300 * time.Millisecond)
			ch1 <- "from1"
		}
	}()
	go func() {
		for {
			time.Sleep(700 * time.Millisecond)
			ch2 <- "from2"
		}
	}()

	// 使用 select 语句非阻塞地从两个通道中获取数据
	for {
		select {
		case ms1 := <-ch1:
			fmt.Println(ms1)
		case ms2 := <-ch2:
			fmt.Println(ms2)
		default:
			time.Sleep(1000 * time.Millisecond)
			fmt.Println("no message received")
		}
	}

}
