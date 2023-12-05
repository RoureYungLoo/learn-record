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

	// 二级指针：指向另外一个指针的指针
	var ptr_ptr_age **int
	ptr_ptr_age = &ptr_age
	fmt.Printf("\n变量age: %d\n", age)
	fmt.Printf("一级指针 ptr_age: %x, *ptr_age = %d\n", ptr_age, *ptr_age)
	fmt.Printf("二级指针 ptr_ptr_age: %x, *ptr_ptr_age = %x\n", ptr_ptr_age, *ptr_ptr_age)

	// 多级指针
	var ppp_age ***int = &ptr_ptr_age
	fmt.Printf("三级指针 ppp_age: %x, *ppp_age = %x\n", ppp_age, *ppp_age)

	var pppp_age ****int = &ppp_age
	fmt.Printf("四级指针 pppp_age: %x, *pppp_age = %x\n", pppp_age, *pppp_age)

	// 指针作为形参，地址作为实参（这里以一级指针为例子）
	var date1 = 16999999
	var date2 = 17000000
	println(date1, date2)
	swap2(&date1, &date2)
	println(date1, date2)

}

func swap2(n1 *int, n2 *int) {
	// *n1, *n2 = *n2, *n1
	var temp int
	temp = *n1 /* 保存 n1 地址的值 */
	*n1 = *n2  /* 将 n2 赋值给 n1 */
	*n2 = temp /* 将 temp 赋值给 n2 */
}
