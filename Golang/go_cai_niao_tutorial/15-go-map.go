package main

import (
	"fmt"
)

func go_map() {
	fmt.Println("========== go range ==========")
	/*
		map :
			1. 无顺序 key:value 键值对[集合]
			2. 在获取 Map 的值时，如果键不存在，返回该类型的零值，例如 int 类型的零值是 0，string 类型的零值是 ""
			3. Map 是引用类型
	*/

	// 定义map: var var_map = make(map[key_type]value_type, init_capacity)
	var ages = make(map[string]int, 10)
	fmt.Println(len(ages))
	// var days = make(map[int]int)
	var rates = map[string]int{
		"c":    23,
		"C++":  12,
		"java": 43,
	}

	// 访问元素 【查】
	var v1 = rates["C++"]
	var v2, ok = rates["lua"]
	fmt.Println(v1)
	fmt.Println(v2, " : ", ok)

	// 修改元素 【增】【改】
	rates["Python"] = 99
	fmt.Println(rates)

	// 删除元素	【删】
	delete(rates, "c")
	fmt.Println(rates)

	// 获取map元素个数 or 获取map长度
	fmt.Println(len(rates))

	// 遍历map
	for key, value := range rates {
		fmt.Println(key, " : ", value)
	}

	var sites map[string]string
	sites = make(map[string]string)

	sites["c"] = "https://www.c.url"
	sites["java"] = "https://www.java.url"
	sites["baidu"] = "https://www.baidu.com"

	for k, v := range sites {
		fmt.Println(k, v)
	}
	site, ok := sites["java"]
	if ok {
		fmt.Println(site)
	} else {
		fmt.Println("key not exists")
	}

	country := map[string]string{"France": "Paris", "Italy": "Rome", "Japan": "Tokyo", "India": "New Delhi"}
	for k, v := range country {
		fmt.Println("country: ", k, ", capital: ", v)
	}

	delete(country, "France")
	for k, v := range country {
		fmt.Println("country: ", k, ", capital: ", v)
	}
}
