package main

import "fmt"

func go_struct() {
	fmt.Println("========== go struct ==========")
	// go array 数据类型相同
	// go struct 数据类型不同
	/*
		type struct_variable_type  struct{
		   member definition
		   member definition
		   ...
		   member definition
		}
		var_name := struct_name{value1,value2,... }
		var_name := struct_name{key1;value1,key2:value2,... }

	*/
	type Book struct {
		title   string
		author  string
		subject string
		book_id int
	}

	b1 := Book{"Go程序设计语言", "Donovan&Kernighan", "计算机技术", 1001}
	var b2 Book
	b2 = Book{title: "Go程序设计语言", author: "Donovan&Kernighan", subject: "CS", book_id: 1002}
	b3 := Book{title: "Go程序设计语言", author: "Donovan&Kernighan", subject: "CS"}
	fmt.Println(b1)
	fmt.Println(b2)
	fmt.Println(b3)

}
