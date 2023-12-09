package main

import (
	"errors"
	"fmt"
	"math"
)

func go_error_handle() {
	fmt.Println("========== go error handle ==========")
	/*
	   	go语言内置错误处理机制
	    error接口的定义:
	   	type error interface{
	   		Error() string
	   	}
	*/
	ret, err := my_sqrt(-1)
	fmt.Println(ret)
	fmt.Println(err)

	// ret1, err1 := Divd(100, 0)
	ret1, err1 := Divd(100, 10)
	if err1 == "" {
		fmt.Println("100➗10=", ret1)
	} else {
		fmt.Println("errMsg:", err1)
	}

}

func my_sqrt(f float64) (float64, error) {
	if f < 0 {
		return 0, errors.New("非法输入")
	} else {
		return math.Sqrt(f), nil
	}
}

type divErr struct {
	num_a int
	num_b int
}

// 实现 `error` 接口
func (de *divErr) Error() string {
	err := `
	Cannot proceed, the divider is zero.
    dividee: %d
    divider: 0
	`
	return fmt.Sprintf(err, de.num_a)
}

// 整数除法运算
func Divd(n1 int, n2 int) (result int, errMsg string) {
	if n2 == 0 {
		dData := divErr{num_a: n1, num_b: n2}
		errMsg = dData.Error()
		return
	} else {
		return n1 / n2, ""
	}
}
