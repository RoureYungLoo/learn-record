package main

import (
	"fmt"
	"time"
)

func process(ch chan int) {
	for {
		select {
		case val := <-ch:
			fmt.Println("Received value:", val)
			// 执行一些逻辑
			if val == 5 {
				return // 提前结束 select 语句的执行
			}
		default:
			fmt.Println("No value received yet.")
			time.Sleep(500 * time.Millisecond)
		}
	}
}

func golang_loop() {
	fmt.Println("========== 循环语句 ==========")

	/*
			// for循环
			var i, sum int = 0, 0
			for i = 0; i < 5; i++ {
				sum += i
			}
			fmt.Println(sum)

			// for condition (while)
			for i > 0 {
				fmt.Println(i)
				i--
			}

			// for无限循环
			for {
				time.Sleep(1 * time.Second)
				fmt.Println("for无限循环")
				break
			}

			// for range
			// langs := []string{"c", "c++", "java"}
			map1 := make(map[int]float32)
			map1[1] = 23.43
			map1[2] = 13.4
			map1[3] = 99.8
			map1[4] = -43.9
			for key, value := range map1 {
				// ... 关注key和value
				fmt.Println("key:", key, " value:", value)
			}

			for _, value := range map1 {
				// ...只关注value
				fmt.Println(" value:", value)
			}
			for key := range map1 {
				// ...关注key
				fmt.Println("key:", key)
			}
			for key, _ := range map1 {
				// ...关注key
				fmt.Println("key:", key)
			}

			// for nested
			i = 0
			var j = 0
			for i = 2; i < 100; i++ {
				for j = 2; j <= (i / j); j++ {
					if i%j == 0 {
						break
					}
				}
				if j > (i / j) {
					fmt.Printf("%d 是素数\n", i)
				}
			}

			// 循环控制语句 break continue goto
			// break
			i = 0
			j = 0
			for i = 0; i < 10; i++ {
				for j = 0; j < 10; j++ {
					if (i * j) == 12 {
						fmt.Println("内层 i:", i, "内层 j: ", j)
						break
					}
				}
				fmt.Println("=== 外层 i:", i, "外层 j: ", j)
			}

			i = 0
			for i = 0; i < 10; i++ {
				if i == 5 {
					break
				}
				fmt.Println(i)
			}

			var counter int = 10
			for counter < 20 {
				fmt.Printf("counter = %d\n", counter)
				counter++
				if counter > 15 {
					break
				}
			}

			// break 嵌套循环
			fmt.Println("=== 不使用标记 ===")
			for i := 1; i <= 3; i++ {
				fmt.Printf("i: %d\n", i)
				for i2 := 11; i2 <= 13; i2++ {
					fmt.Printf("i2: %d\n", i2)
					break
				}
			}

			fmt.Println("=== 使用标记 ===")
		re:
			for i := 1; i <= 3; i++ {
				fmt.Printf("i: %d\n", i)
				for i2 := 11; i2 <= 13; i2++ {
					fmt.Printf("i2: %d\n", i2)
					break re
				}
			}

			// break switch语句
			day := "Mon"
			switch day {
			case "Tue":
				println("Tue")
			case "Wed":
				println("Wed")
			case "Mon":
				println("Mon")
				break //编译器会自动添加，不必手动添加 break
			case "Thu":
				println("Thu")
			case "Fri":
				println("Fri")
			default:
				println("other")
			}

			// break select语句
			c1 := make(chan int)
			c2 := make(chan int)

			go func() {
				time.Sleep(3 * time.Second)
				c1 <- 1
			}()
			go func() {
				time.Sleep(1 * time.Second)
				c2 <- 2
			}()

			select {
			case <-c1:
				fmt.Println("从c1收到消息")
			case <-c2:
				fmt.Println("从c2收到消息")
				break //跳出select语句
			}


			channel := make(chan int)
			go process(channel)
			time.Sleep(2 * time.Second)
			channel <- 1
			time.Sleep(1 * time.Second)
			channel <- 3
			time.Sleep(1 * time.Second)
			channel <- 5
			time.Sleep(1 * time.Second)
			channel <- 7
			time.Sleep(2 * time.Second)

	*/

	/*
			// continue 进行下一轮循环
			var i = 10
			for i < 20 {
				if i%2 == 0 {
					i++
					continue
				}
				println(i)
				i++
			}

			// 不使用标签
			println("=== 不使用标签 ===")
			for i := 1; i <= 3; i++ {
				fmt.Printf("i: %d\n", i)
				for i2 := 11; i2 <= 13; i2++ {
					fmt.Printf("i2: %d\n", i2)
					continue
				}
			}

			// 使用标签
			println("=== 使用标签 ===")
		rep:
			for i := 1; i <= 3; i++ {
				fmt.Printf("i: %d\n", i)
				for i2 := 11; i2 <= 13; i2++ {
					fmt.Printf("i2: %d\n", i2)
					continue rep
				}
			}
	*/

	// goto 跳转之王
	var counter = 10
LOOP:
	for counter < 20 {
		if counter%2 != 0 {
			counter++
			goto LOOP
		}
		fmt.Printf("counter: %d\n", counter)
		counter++
	}

	// 无限循环
	for true {
		println("无限循环")
	}
}
