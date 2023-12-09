package main

// 全局变量
var version string = "1.0"
var limit = 99

func go_var_scope() {
	println("========== 变量作用域 ==========")
	// 作用域：常量、变量、类型、函数、包等 在源代码中的作用范围（能否访问的到）
	/*
	   全局变量：函数外部定义的变量
	   局部变量：函数内部定义的变量
	   形式参数：函数定义中的变量
	   实际参数：函数调用中的变量
	*/

	// 局部变量；函数参数和函数返回值变量也是局部变量
	var sub_version = "1.5"
	var version = "2.0" // 局部变量和全局变量同名，优先使用局部变量
	var limit = 11
	sum(limit, 1)

	println("全局变量：", version)
	println("全局变量+局部变量：", version+"."+sub_version)

	// 变量默认值：0或nil
	var v1 int
	var v2 float64
	var v3 *int
	println(v1)
	println(v2)
	println(v3)

}

func sum(a, b int) int {
	println("sum()中a=", a)
	println("sum()中b=", b)
	return a + b
}
