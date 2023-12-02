package main

import "fmt"

/*
算术运算符
关系运算符
逻辑运算符
位运算符
赋值运算符
其他运算符
*/
func golang_operator() {
	println("========== 运算符 ==========")

	// 算数运算符 +、-、*、/、%、++、--
	var A, B = 20, 17
	print("算数运算符\n")
	fmt.Printf("A + B: %d + %d = %d\n", A, B, A+B)
	fmt.Printf("A - B: %d - %d = %d\n", A, B, A-B)
	fmt.Printf("A * B: %d * %d = %d\n", A, B, A*B)
	fmt.Printf("A / B: %d / %d = %d\n", A, B, A/B)
	fmt.Printf("A %% B: %d %% %d = %d\n", A, B, A%B)
	A++
	B++
	println("A: ", A)
	println("B: ", B)

	// 关系运算符 ==  !=  <  <=  >  >=
	print("关系运算符\n")
	fmt.Printf("A == B: %d == %d : %v\n", A, B, A == B)
	fmt.Printf("A != B: %d != %d : %v\n", A, B, A != B)
	fmt.Printf("A > B: %d > %d : %v\n", A, B, A > B)
	fmt.Printf("A >= B: %d >= %d : %v\n", A, B, A >= B)
	fmt.Printf("A < B: %d < %d : %v\n", A, B, A < B)
	fmt.Printf("A <= B: %d <= %d : %v\n", A, B, A <= B)

	// 逻辑运算符 &&  ||  !
	a := true
	b := false
	print("逻辑运算符\n")
	fmt.Printf("A && B: %v && %v : %v\n", a, b, a && b)
	fmt.Printf("A || B: %v || %v : %v\n", a, b, a || b)
	fmt.Printf("!A : !%v : %v\n", a, !a)
	fmt.Printf("!B : !%v : %v\n", b, !b)

	// 位运算符 &  |  ^  <<  >>
	A = 60 // 00111100
	B = 13 // 00001101
	print("位运算符\n")
	fmt.Printf("A & B = %v\n", A&B)   // 00001100
	fmt.Printf("A | B = %v\n", A|B)   // 00111101
	fmt.Printf("A ^ B = %v\n", A^B)   // 00110001
	fmt.Printf("A << 2 = %v\n", A<<2) // 11110000
	fmt.Printf("A >> 2 = %v\n", A>>2) // 00001111

	// 赋值运算符 =  +=  -=  *=  /=  %=  <<=  >>=  &=  ^=  |=
	A = 23
	B = 7
	print("赋值运算符\n")
	fmt.Printf("%d += %d : ", A, B)
	A += B
	fmt.Println(A)
	fmt.Printf("%d -= %d : ", A, B)
	A -= B
	fmt.Println(A)
	fmt.Printf("%d *= %d : ", A, B)
	A *= B
	fmt.Println(A)
	fmt.Printf("%d /= %d : ", A, B)
	A /= B
	fmt.Println(A)
	fmt.Printf("%d %%= %d : ", A, B)
	A %= B
	fmt.Println(A)
	fmt.Printf("%d <<= %d : ", A, B)
	A <<= B
	fmt.Println(A)
	fmt.Printf("%d >>= %d : ", A, B)
	A >>= B
	fmt.Println(A)
	fmt.Printf("%d &= %d : ", A, B)
	A &= B
	fmt.Println(A)
	fmt.Printf("%d |= %d : ", A, B)
	A |= B
	fmt.Println(A)
	fmt.Printf("%d ^= %d : ", A, B)
	A ^= B
	fmt.Println(A)

	// 其他运算符  & *
	A = 34
	println("其他运算符")
	var int_ptr *int = &A
	var int_ptr_ptr **int = &int_ptr
	fmt.Println("int_ptr:", int_ptr)
	fmt.Println("*int_ptr:", *int_ptr)
	fmt.Println("&int_ptr:", &int_ptr)
	fmt.Println("int_ptr_ptr:", int_ptr_ptr)
	fmt.Println("*int_ptr_ptr:", *int_ptr_ptr)
	fmt.Println("**int_ptr_ptr:", **int_ptr_ptr)

	// 运算符优先级
	/*
		较高  较低
		较低

		优先级	运算符
		5		* / % << >> & &^
		4		+ - | ^
		3		== != < <= > >=
		2		&&
		1		||
	*/
}
