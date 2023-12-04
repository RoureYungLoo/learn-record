package main

import "fmt"

func go_pointer() {
	fmt.Println("========== Golang指针 ==========")
	// 指针：是一个值，这个值是内存中的某个地址的值
	// 取地址符是 &，放到一个变量前使用就会返回相应变量的内存地址
	var age int = 10
	fmt.Printf("0X%x\n", &age)

	// 指针变量：变量的类型是指针类型
	score := 89.4
	var ptr_age *int = &age
	var ptr_f *float64 = &score
	fmt.Println(ptr_age)
	fmt.Println(ptr_f)

	// 怎样使用指针？1.定义指针变量  2.为指针变量赋值   3.访问指针变量中指向地址的值（*）
	fmt.Println(*ptr_age)
	fmt.Println(*ptr_f)

	// 空指针：不指向任何变量的指针，其值为nil
	// nil在概念上和其它语言的null、None、nil、NULL一样，都指代零值或空值。
	var ptr_arr *int
	fmt.Println(ptr_arr) //<nil>
	if ptr_arr == nil {
		fmt.Println(ptr_arr, "是空指针")
	}
	if ptr_age != nil {
		fmt.Println(ptr_age, "不是空指针")
	}

	// 指针数组：顾名思义，元素是指针的数组
	const MAX int = 3
	weights := []int{10, 100, 200}
	for i := 0; i < MAX; i++ {
		fmt.Printf("\nweights[%d] = %d  ", i, weights[i])
	}
	var ptr_w [MAX]*int
	for i := 0; i < MAX; i++ {
		ptr_w[i] = &weights[i]
	}
	for i := 0; i < MAX; i++ {
		fmt.Printf("\n*ptr_w[%d] = %d", i, *ptr_w[i])
	}

	// 二级指针
	// 多级指针

	// 指针作为形参，地址作为实参（这里以一级指针为例子）
}
