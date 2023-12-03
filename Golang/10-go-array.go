package main

import (
	"fmt"
	"strconv"
)

func go_array() {
	println("========== Golang Array ==========")
	/*
		Golang Array
		类型相同：整型、字符串、自定义类型
		长度已知
		索引从0开始
	*/

	// 声明数组: var arrayName [size] dataType
	// var days [7]string

	// 初始化数组：默认初始化根据类型的默认值
	// var Days = [7]string{"Sat", "Sun", "Mon", "Tue", "Wed", "Thur", "Fri"}
	Days := [7]string{"Sat", "Sun", "Mon", "Tue", "Wed", "Thur", "Fri"}
	for i := 0; i < 7; i++ {
		fmt.Printf("%q \n", Days[i])
	}

	// 在 Go 语言中，数组的大小是类型的一部分，不同大小的数组是不兼容的
	// var balance = [5]float64{1000.0,2.0,3.4,7.0,50.0}
	// balance := [5]float64{1000.0,2.0,3.4,7.0,50.0}
	// 编译器自动推断数组长度 [...]
	// var balance = [...]float64{1000.0,2.0,3.4,7.0,50.0}
	// balance := [...]float64{1000.0,2.0,3.4,7.0,50.0}
	// 指定下标
	balance := [7]float64{2: 2.3, 5: 4.9}
	for i := 0; i < 7; i++ {
		fmt.Printf("%v \n", balance[i])
	}

	// 初始化数组中 {} 中的元素个数不能大于 [] 中的数字
	// 如果 [...] 中的数字不设置数组大小，Go 语言会根据元素的个数来设置数组的大小：
	var arr = [...]float64{10: 23.343}
	arr[9] = 3.4
	for i := 0; i < 11; i++ {
		fmt.Printf("%v \n", arr[i])
	}

	// 访问数组元素
	for i := 0; i < 7; i++ {
		Days[i] = "周" + strconv.Itoa(i+1)
		fmt.Printf("%q \n", Days[i])
	}

	// 多维数组
	/* 声明一个N维数组：
	var arr_name [SIZE1][SIZE2][SIZE3]...[SIZEN] var_type
	var arr [3][4][5][6] int // 声明了一个四维数组
	*/

	// 声明一个2维数组
	array := [][]int{}
	row1 := []int{1, 2, 3}
	row2 := []int{4, 5, 6}
	array = append(array, row1)
	array = append(array, row2)

	fmt.Println("row1: ")
	fmt.Println(array[0])
	fmt.Println("row2:")
	fmt.Println(array[1])
	println("array[1][1]: ", array[1][1])

	// 二维数组初始化
	var arr2 = [3][4]int{
		{1, 2, 3, 4},
		{5, 6, 7, 8},
		{9, 10, 11, 12},
	}
	fmt.Println(arr2)

	sites := [2][2]string{}
	sites[0][0] = "第0行第0列"
	sites[0][1] = "第0行第1列"
	sites[1][0] = "第1行第0列"
	sites[1][1] = "第1行第1列"
	fmt.Println(sites)

	// 访问二维数组
	var arr3 = [][]int{{-1, 0}, {1, 2}, {2, 4}, {3, 6}, {4, 8}}
	for i := 0; i < 5; i++ {
		for j := 0; j < 2; j++ {
			fmt.Printf("arr3[%d][%d] = %d ", i, j, arr3[i][j])
		}
		println()
	}

	animals := [][]string{}

	r1 := []string{"🐖", "🦆", "🐟"}
	r2 := []string{"🐓"}
	r3 := []string{"🐍", "🐒"}

	animals = append(animals, r1)
	animals = append(animals, r2)
	animals = append(animals, r3)

	fmt.Println(animals)
	for i, v := range animals {
		fmt.Println("第几行？:", i)
		fmt.Println(v)
	}

	// 数组参数, 向函数传递数组
}
