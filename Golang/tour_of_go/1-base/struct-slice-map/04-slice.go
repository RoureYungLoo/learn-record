package main

import (
	"fmt"
	"strings"

	"golang.org/x/tour/pic"
)

func go_slice() {
	fmt.Println("========== go slice ==========")
	/* go切片：即动态数组
	类型 []T 表示一个元素类型为 T 的切片

	*/
	primes := [6]int{2, 3, 5, 7, 11, 13}
	var slice []int
	slice = primes[1:4] // 切片，左闭右开区间
	fmt.Println(slice)

	names := []string{
		"zhangsan",
		"wangwu",
		"xiaoming",
		"lisi",
	}

	/* 切片并不存储任何数据，它只是描述了底层数组中的一段。
	更改切片的元素会修改其底层数组中对应的元素。
	与它共享底层数组的切片都会观测到这些修改。 */
	fmt.Println(names)
	slice_a := names[0:2]
	slice_b := names[1:3]
	fmt.Println(slice_a)
	fmt.Println(slice_b)
	slice_a[1] = "WangWu"
	fmt.Println(slice_a)
	fmt.Println(slice_b)

	slice_c := []int{1, 3, 5, 7}
	slice_d := []bool{true, false, false, true}
	slice_e := []st{
		{1, false}, {2, true}, {3, true},
		{4, false}, {5, true},
	}
	fmt.Println(slice_c)
	fmt.Println(slice_d)
	fmt.Println(slice_e)

	// 以下几个切片是等价的. 切片的默认左下标是0，右下标是被切数组（或切片）的长度
	fmt.Println(slice_e[:])
	fmt.Println(slice_e[0:])
	fmt.Println(slice_e[:5])
	fmt.Println(slice_e[0:5])

	// 切片长度和容量.长度就是它所包含的元素个数.容量是从它的第一个元素开始数，到其[底层数组]元素末尾的个数
	var slc = []int{1, 3, 5, 7, 9, 11, 14}
	print_slice(slc)
	slc = slc[:0]
	print_slice(slc)
	slc = slc[:4]
	print_slice(slc)
	slc = slc[:7]
	// slc = slc[:8] // panic: runtime error: slice bounds out of range [:8] with capacity 7
	print_slice(slc)

	// nil切片
	var slc2 []string //nil 切片的长度和容量为 0 且没有底层数组
	if slc2 == nil {
		fmt.Println(slc2, len(slc2), cap(slc2))
		fmt.Println("slc2:", slc2)
	}

	// 零值切片
	var slc3 = make([]string, 5, 10)
	fmt.Printf("%q\n", slc3)
	print_slice2(slc3)

	// 切片的切片
	board := [][]string{
		[]string{"_", "_", "_"},
		[]string{"_", "_", "_"},
		[]string{"_", "_", "_"},
	}
	board[0][0] = "X"
	board[2][2] = "O"
	board[1][2] = "X"
	board[1][0] = "O"
	board[0][2] = "X"
	for i := 0; i < len(board); i++ {
		fmt.Printf("%s\n", strings.Join(board[i], " "))
	}

	// 向切片追加元素
	slc2 = append(slc2, "one")
	slc2 = append(slc2, "2")
	slc2 = append(slc2, "3")
	slc2 = append(slc2, "4")
	slc2 = append(slc2, "5") // len(slc2) = 8
	print_slice2(slc2)

	// range slice or range map:每次迭代都会返回两个值。
	// 第一个值为当前元素的下标，第二个值为该下标所对应元素的一份副本。
	for index, value := range slc2 {
		// for index := range slc2 {
		// for index, _ := range slc2 {
		// for _, value := range slc2 {
		fmt.Printf("%d %q\n", index, value)
	}

	// 练习
	pic.Show(Pic)

}

type st struct {
	id     int
	gender bool
}

func print_slice(s []int) {
	fmt.Printf("lend = %d, cap = %d , %v\n", len(s), cap(s), s)
}
func print_slice2(s []string) {
	fmt.Printf("lend = %d, cap = %d , %q\n", len(s), cap(s), s)
}

func Pic(dx /*每个切片元素个数*/, dy /*切片长度*/ int) [][]uint8 {
	var ret = make([][]uint8, dy)
	for x := range ret {
		inner := make([]uint8, dx)
		for y := range inner {
			// inner[y] = uint8(x * y)
			// inner[y] = uint8(x ^ y)
			inner[y] = uint8(x/2 + y/2)
			// inner[y] = uint8(x%(y+1))
		}
		ret[x] = inner
	}
	return ret
}
