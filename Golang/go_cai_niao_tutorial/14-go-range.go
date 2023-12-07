package main

import (
	"fmt"
	"reflect"
)

func go_range() {
	fmt.Println("========== go range ==========")
	/* 关键字range
	用于迭代 array、slice、channel、map
	作用于array、slice时：返回 index,value
	作用于channel、map时：返回 key,value
	eg:
		for key,value := range oldMap {
		for _,value := range oldMap {
		for key,_ := range oldMap {
		for key := range oldMap {
			newMap[key] = value
		}
	*/
	var days = [7]string{"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"}
	for index, day := range days {
		fmt.Println("index: ", index, "day: ", day)
	}
	// for index, _ := range days {
	for index := range days {
		fmt.Println("index: ", index)
	}

	for _, value := range days {
		fmt.Println("day: ", value)
	}

	for index, day := range days {
		fmt.Println("type(index): ", reflect.TypeOf(index), "  ； type(day): ", reflect.TypeOf(day))
	}

	// slice
	nums := []int{1, 2, 3, 4, 5, 6, 7}
	sum := 0
	for _, v := range nums {
		sum += v
	}
	fmt.Println(sum)

	// map
	langs := map[string]string{"c": "C", "c++": "C++", "java": "JAVA"}
	for k, v := range langs {
		fmt.Println(k, " : ", v)
	}

	//string
	str := "a go\n"
	for k, v := range str {
		fmt.Println(k, " : ", v) // index : unicode
	}
}
