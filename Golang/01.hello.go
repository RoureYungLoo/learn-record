package main

import "fmt"

func main() {
	/*  */
	//

	fmt.Println("Hello,World")
	fmt.Println("123" + "345")

	var code = 123
	var date = "2023-12-1"
	var url = "Code=%d&EndDate=%s"
	var target_url = fmt.Sprintf(url, code, date)
	fmt.Println(target_url)
	fmt.Println(a)
	Datatype()

	// 3-变量.go
	// variable()

	// 4-常量.go
	// const_variable()

	// 5-运算符.go
	// golang_operator()

	// 6-条件语句.go
	// golang_condition()

	// 7-循环语句.go
	// golang_loop()

	// 8-函数.go
	// go_function()

	// 9-变量作用域.go
	// go_var_scope()

	// 10-go-array.go
	// go_array()

	// 11-go-pointer.go
	// go_pointer()

	// 12-go-struct.go
	go_struct()
}

/* 关键字
break	default	func	interface	select
case	defer	go	map	struct
chan	else	goto	package	switch
const	fallthrough	if	range	type
continue	for	import	return	var
*/
/* 保留字
append	bool	byte	cap	close	complex	complex64	complex128	uint16
copy	false	float32	float64	imag	int	int8	int16	uint32
int32	int64	iota	len	make	new	nil	panic	uint64
print	println	real	recover	string	true	uint	uint8	uintptr
*/

// var x int
// const Pi float32 = 3.23254232342
// var fruit string
// var apple string
// var orange string
// fruit = apple + orange
// if x>0 {
// 	// ...
// }
// var res int
// // res := add(2,3)
