package main

import "fmt"

func main() {
	println("====== datatype ======")
	// test_array()
	test_slice()
}

func test_array() {
	// 类型相同，长度固定，无法调整大小
	var args [5]int
	// args[0] = 0
	// args[1] = 1
	// args[2] = 2
	// args[3] = 3
	// args[4] = 4
	args = [5]int{1, 2, 3, 4}
	ages := [5]int{11, 13, 15}
	fmt.Println(args)
	fmt.Println(len(args))
	fmt.Println(ages)

	// 自动推导数组长度
	alpha := [...]string{"a", "b", "c", "d", "e", "f"}
	fmt.Println(alpha)
	fmt.Println(len(alpha))

	nums := [...]int{20: 99}
	fmt.Println(nums)
	fmt.Println(len(nums))

	//多维数组
	var matrix [4][5]int
	for i := 0; i < 4; i++ {
		for j := 0; j < 5; j++ {
			// matrix[i][j] = 0
			matrix[i][j] = (i + 1) * (j + 1)
		}
		fmt.Println("行：", i, matrix[i])
	}
	fmt.Println("\n所有：", matrix)

	var matrix2 [3][5][2]int
	for i := 0; i < 3; i++ {
		for j := 0; j < 5; j++ {
			for k := 0; k < 2; k++ {
				matrix2[i][j][k] = (i + 1) * (j + 1) * (k + 1)
			}
			fmt.Println("层：", i, j, matrix2[i][j])

		}
		fmt.Println("层：", i, matrix2[i])
	}
	fmt.Println("\n所有：", matrix2)

}

func test_slice() {
	// 类型相同，长度可变，可以调整容量
	// 切片的3个组件1.指向基础数组中第一个可访问元素的【!!!指针!!!】 2.切片的长度 3.切片的容量

	months := []string{
		"January",
		"February",
		"March",
		"April",
		"May",
		"June",
		"July",
		"August",
		"September",
		"October",
		"November",
		"December",
	}
	fmt.Println(months)
	fmt.Println(cap(months))
	fmt.Println(cap(months))

	quarter1 := months[0:3] //cap(quarter1)=12 , 切片容量仅指出切片可扩展的程度
	quarter2 := months[3:6]
	quarter3 := months[6:9]
	quarter4 := months[9:12]

	fmt.Println(quarter1, len(quarter1), cap(quarter1))
	fmt.Println(quarter2, len(quarter2), cap(quarter2))
	fmt.Println(quarter3, len(quarter3), cap(quarter3))
	fmt.Println(quarter4, len(quarter4), cap(quarter4))

	quarter2_Ext := quarter2[:4]
	fmt.Println(quarter2_Ext, len(quarter2_Ext), cap(quarter2_Ext))

	// 增
	var number []int
	for i := 0; i < 10; i++ {
		number = append(number, i) //深拷贝or浅拷贝？
		fmt.Printf("%d\tcap=%d\t%v\n", i, cap(number), number)
	}

	// 删
	index := 5
	if index < len(number) {
		fmt.Println("=== before", number)
		number = append(number[:index], number[index+1:]...)
		fmt.Println("=== after", number)
	}

	//拷贝
	n_cpy := make([]int, 4)
	copy(n_cpy, number[1:5])
	fmt.Println(n_cpy)

	fmt.Println("修改切片slice1之前：", number)
	slice1 := number[0:2]
	// slice2 := number[1:4]

	slice2 := make([]int, 3)
	copy(slice2, number[1:4])

	slice1[1] = 999 //修改切片：更改切片中的元素时，基础数组将随之更改。 引用该基础数组的任何其他切片都会受到影响

	fmt.Println("修改切片slice1之后：", number)
	fmt.Println(slice1)
	fmt.Println(slice2)

}
