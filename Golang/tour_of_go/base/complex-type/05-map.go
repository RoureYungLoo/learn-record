package main

import (
	"fmt"
	"golang.org/x/tour/wc"
	"strings"
)

type Geo struct {
	Lat, Lon float64
}

var sites map[string]Geo

func go_map() {
	fmt.Println("========== go map ==========")
	/*
		映射将键映射到值
		映射的零值为 nil 。nil 映射既没有键，也不能添加键。
		make 函数会返回给定类型的映射，并将其初始化备用。
	*/
	sites = make(map[string]Geo, 5)
	sites["zz"] = Geo{12.12, 23.23} //向 nil map中添加会导致： panic: assignment to entry in nil map
	sh := "Shanghai"
	sites[sh] = Geo{123.23, 234.23}
	fmt.Println(sites)

	/* 若顶级类型只是一个类型名，你可以在文法的元素中省略它???这说的是什么玩意？？？ */
	var m = map[string]Geo{
		"Bell":   Geo{40.68433, -74.39967},
		"Google": Geo{37.42202, -122.08408},
	}
	fmt.Println(m)

	m["Google"] = Geo{1.0, 1.0}
	fmt.Println(m)
	fmt.Println(m["Bell"])
	delete(m, "Bell")
	fmt.Println(m)
	elem, ok := m["Bell"] //检测key是否存在，不存在key则会返回零值和false
	fmt.Println(elem, ok)
	// fmt.Println(m["Bell"]) //直接获取某个key的值，不存在key则会返回零值

	// map练习
	// wc.Test(Wor)
	// fmt.Printf("Fields are: %q", strings.Fields("  foo bar  baz   "))
	wc.Test(WordCount)
	fmt.Println(WordCount("Ni Ni Ni hao a a a ha ha hi"))
}

func WordCount(s string) map[string]int {
	var m = make(map[string]int)
	for _, v := range strings.Fields(s) {
		if m[v] != 0 { //直接获取某个key的值，不存在key则会返回零值
			m[v]++
		} else {
			m[v] = 1
		}
	}
	return m
}
