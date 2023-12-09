package main

import (
	"crypto/rand"
	"fmt"
	"math/big"
	"strconv"
	"time"
)

func go_concurrency() {
	fmt.Println("===== go concurrency =====")
	/*
		golang支持并发

		goroutine是轻量级线程，goroutine 由 golang runtime 进行管理
		goroutine 语法：go 函数名( 参数列表 )
		eg:
			go func1(param_x, param_y, param_z)

			开启一个新的 goroutine:
			func1(param_x, param_y, param_z)

		同一个程序中的所有 goroutine 共享同一个地址空间。
	*/

	go say("*", 20)
	go say(".", 20)
	say("&", 10)
	fmt.Printf("\n\n say() is over\n\n") /*此时两个 goroutine 未必已经运行结束 */
	say("=", 10)

	println()
	/* go channel ：golang中传递数据的数据结构。
	1. 通道可用于两个 goroutine 之间，通过传递一个指定类型的值来同步运行和通讯
	2. 操作符 <- 用于指定通道的方向，发送或接收
	3. 如果未指定方向，则为双向通道。
	eg：
		ch := make(chan int) // 声明通道
		ch <- v    // 把 v 发送到通道 ch
		v := <-ch  // 从 ch 接收数据 并把值赋给 v
	4. golang 通道默认无缓冲。发送端发送数据，同时必须有接收端相应的接收数据
	*/
	s := []int{7, 3, 2, 1, -3, 6}
	c := make(chan int)
	go sum2(s[:len(s)/2], c)
	go sum2(s[len(s)/2:], c)
	x, y := <-c, <-c
	fmt.Println(x, y)

	/*
		通道缓冲区
		带缓冲区的通道 允许 发送端的数据发送 和 接收端的 数据获取 处于异步状态，即：
		发送端发送的数据可以放在缓冲区里面，可以等待接收端去获取数据，而不是立刻需要接收端去获取数据
		由于缓冲区的大小是有限的，所以还是必须有接收端来接收数据的，否则缓冲区一满，数据发送端就无法再发送数据
		如果通道不带缓冲，发送方会阻塞直到接收方从通道中接收了值。如果通道带缓冲，发送方则会阻塞直到发送的值
		被拷贝到缓冲区内；如果缓冲区已满，则意味着需要等待直到某个接收方获取到一个值。接收方在有值可以接收之前会一直阻塞
	*/
	ch := make(chan int, 100)
	ch <- 1
	ch <- 2
	ch <- 3
	ch <- 4
	ch <- 5
	ch <- 6
	fmt.Println(<-ch)
	fmt.Println(<-ch)
	fmt.Println(<-ch)

	// // 通道遍历和通道关闭
	close(ch)
	for i := range ch {
		fmt.Println(i)
	}

	// Go 通过 range 关键字来实现遍历读取到的数据 v, ok := <-ch 如果通道接收不到数据后 ok 就为 false，这时通道就可以使用 close() 函数来关闭
	cccc := make(chan string, 5)
	go fibonacci2(cap(cccc), cccc)
	for i := range cccc {
		fmt.Printf("%q", i)
	}
}

func say(s string, counts int) {
	for i := 0; i < counts; i++ {
		rand_int, _ := rand.Int(rand.Reader, big.NewInt(10))
		// sss := time.Duration(rand_int.Int64())
		// fmt.Println(sss)
		time.Sleep(time.Duration(rand_int.Int64()) * time.Millisecond)
		fmt.Print(s)
	}
}

func sum2(s []int, c chan int) {
	sum := 0
	for _, v := range s {
		sum += v
	}
	c <- sum
}

func fibonacci2(n int, chn chan string) {
	for i := 0; i < n; i++ {
		chn <- strconv.Itoa(i)
	}
	close(chn)
}
