package main

import "fmt"

func go_struct() {
	fmt.Println("========== go struct ==========")
	// go array 数据类型相同
	// go struct 数据类型不同
	/*
		// 定义结构体
			type struct_variable_type  struct{
			   member definition
			   member definition
			   ...
			   member definition
			}
			var_name := struct_name{value1,value2,... }
			var_name := struct_name{key1;value1,key2:value2,... }

	*/

	// 定义结构体
	// type Book struct {
	// 	title   string
	// 	author  string
	// 	subject string
	// 	book_id int
	// }

	b1 := Book{"Go程序设计语言", "Donovan&Kernighan", "计算机技术", 1001}
	var b2 Book
	b2 = Book{title: "Go程序设计语言", author: "Donovan&Kernighan", subject: "CS", book_id: 1002}
	b3 := Book{title: "Go程序设计语言", author: "Donovan&Kernighan", subject: "CS"}
	fmt.Println(b1)
	fmt.Println(b2)
	fmt.Println(b3)

	// 访问结构体成员
	fmt.Printf("b3 title : %s\n", b3.title)
	fmt.Printf("b3 author : %s\n", b3.author)
	fmt.Printf("b3 subject : %s\n", b3.subject)
	fmt.Printf("b3 book_id : %d\n", b3.book_id)

	// 结构体作为参数
	print_book(b2)
	println("b2.title", b2.title)

	// 结构体指针
	var ptr_b1 *Book
	ptr_b1 = &b1
	println(ptr_b1.title)
	println(ptr_b1.author)
	println(ptr_b1.subject)
	println(ptr_b1.book_id)

	print_book2(&b3)
	println(b3.title)
}

type Book struct {
	title   string
	author  string
	subject string
	book_id int
}

func print_book(book Book) {
	book.title = "teststetse" //值传递，这里对形参的修改不会影响实参 思考一下深拷贝和浅拷贝，假如book结构体里有一个引用，修改引用会不会传递给实参
	// fmt.Printf("book title : %s\n", book.title)
	fmt.Printf("book author : %s\n", book.author)
	fmt.Printf("book subject : %s\n", book.subject)
	fmt.Printf("book book_id : %d\n", book.book_id)
}

func print_book2(book *Book) {
	book.title = "teststetse" //引用传递，思考同上，深浅拷贝
	// fmt.Printf("book title : %s\n", book.title)
	fmt.Printf("book author : %s\n", book.author)
	fmt.Printf("book subject : %s\n", book.subject)
	fmt.Printf("book book_id : %d\n", book.book_id)
}
