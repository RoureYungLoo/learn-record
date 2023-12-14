package main

import "fmt"

func go_pointer() {
	fmt.Println("========== go pointer ==========")
	var i, j int
	i = 43
	j = 2023
	var ptr_i, ptr_j *int
	fmt.Printf("ptr_i = %x, ptr_j = %x\n", ptr_i, ptr_j)

	ptr_i = &i // 指针重定向
	ptr_j = &j // 指针重定向

	fmt.Printf("ptr_i = %x, ptr_j = %x\n", ptr_i, ptr_j)
	fmt.Printf("*ptr_i = %v, *ptr_j = %v\n", *ptr_i, *ptr_j) // 指针解引用

	*ptr_i = 1000
	*ptr_j = 2000
	fmt.Printf("ptr_i = %v, ptr_j = %v\n", ptr_i, ptr_j)
	fmt.Printf("*ptr_i = %v, *ptr_j = %v\n", *ptr_i, *ptr_j) // 指针解引用
}
