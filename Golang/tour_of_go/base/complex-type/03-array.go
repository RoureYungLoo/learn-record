package main

import "fmt"

func go_array() {
	fmt.Println("========== go array ==========")
	/*
	   golang 数组：[n]Type : 表示拥有 n 个 Type 类型的值的数组
	   数组的长度是数组的一部分

	*/
	var arr [7]string
	arr = [7]string{"1", "2", "3", "4", "5", "6", "7"}
	fmt.Println(arr)
	fmt.Println(arr[0], arr[4])

	primes := [6]int{2, 3, 5, 7, 11, 13}
	fmt.Println(primes)
}
