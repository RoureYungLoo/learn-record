package main

import (
	"fmt"
)

func go_recursion() {
	fmt.Println("========== go recursion ==========")

	/* 递归：函数A调用函数A本身
	需要注意：必须设置递归退出条件，否则会导致栈溢出 [stack overflow]
	*/
	// recursion()
	fmt.Println(factorial(15))

	for i := 0; i < 10; i++ {
		fmt.Println(fibonacci(i), " ")
	}

	fmt.Println(sqrt(25))
}

func recursion() {
	recursion()
}

// 阶乘
func factorial(n uint64) (ret uint64) {
	if n > 0 {
		ret = n * factorial(n-1)
		return ret
	}
	return 1
}

// fibonacci
func fibonacci(n int) int {
	if n < 2 {
		return n
	}
	return fibonacci(n-1) + fibonacci(n-2)
}

// 求平方根 【待整理】
func sqrtRecursive(x, guess, prevGuess, epsilon float64) float64 {
	if diff := guess*guess - x; diff < epsilon && -diff < epsilon {
		return guess
	}

	newGuess := (guess + x/guess) / 2
	if newGuess == prevGuess {
		return guess
	}

	return sqrtRecursive(x, newGuess, guess, epsilon)
}

func sqrt(x float64) float64 {
	return sqrtRecursive(x, 1.0, 0.0, 1e-9)
}
