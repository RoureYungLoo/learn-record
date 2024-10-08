package main

import "fmt"

func go_slice() {
	fmt.Println("========== go slice ==========")
	var array [5]int
	array = [5]int{11, 22, 33, 44, 55}
	// 即动态数组

	// 定义切片: 切片不需要说明长度
	//方式1： var var_name []date_type
	var slice []int
	// 方式2：var slice []type = make([]type, len) 或者 slice := make([]type, len) 或者指定长度和容量：make([]Type, length, capacity)
	var slice2 []int = make([]int, 10, 1000)
	slice3 := make([]int, 100, 1000)

	slice = []int{1, 2, 3}
	fmt.Println(slice)

	// s := arr[startIndex:endIndex]  arr中从下标 startIndex 到 endIndex-1 下的元素创建为一个新的切片。
	slice2 = array[:]
	fmt.Println(slice2)

	slice3 = array[1:3] //array[1] array[2]
	fmt.Println(slice3)

	fmt.Println("slice的长度", len(slice), "slice的容量", cap(slice))
	fmt.Println("slice2的长度", len(slice2), "slice的容量", cap(slice2))
	fmt.Println("slice3的长度", len(slice3), "slice的容量", cap(slice3))

	// 空切片
	var empty []int
	if empty == nil {
		fmt.Println("empty 是空切片")
		print_slice(empty)
	}

	// 切片截取 new_slice = slice[start:end]  !!!左闭右开！！！
	var days = [7]string{"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"}
	var day_slice = days[1:4]
	fmt.Println(day_slice)
	fmt.Println(days[:])
	fmt.Println(days[3:])
	fmt.Println(days[:5])

	// append()  and  copy()
	var new_clice []string
	fmt.Println(append(new_clice, "周一"))
	fmt.Println(new_clice)
	new_clice = append(new_clice, "周二", "周三")
	fmt.Println(new_clice)
	// 异地扩容
	new_slice := make([]string, len(new_clice), cap(new_clice)*2)
	copy(new_slice, new_clice)
	fmt.Println(new_slice, len(new_slice), cap(new_slice))

}
func print_slice(s []int) {
	fmt.Printf("len = %d, cap = %d, slice = %v\n", len(s), cap(s), s)
}
