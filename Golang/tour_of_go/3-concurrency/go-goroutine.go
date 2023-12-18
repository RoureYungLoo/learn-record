package main

import (
	"fmt"
	"time"
)

func sum(a, b, c int) int {
	fmt.Println(a + b + c)
	return a + b + c
}

func say(s string) {
	for i := 0; i < 8; i++ {
		time.Sleep(100 * time.Millisecond)
		fmt.Println(s)
	}
}
func go_goroutine() {
	fmt.Println("========== go goroutine ==========")
	// golang goroutine 是由 Go 运行时管理的轻量级线程
	// 启动一个新的golang 协程并运行
	// Go 协程在相同的地址空间中运行，因此在访问共享的内存时必须进行同步
	go sum(1, 2, 3)
	time.Sleep(100 * time.Microsecond)
	sum(4, 5, 6)

	// 开启下一个新的golang协程
	go say("world")

	// 当前协程
	say("hello")

	s := []int{7, 2, 8, -9, 4, 0}

	c := make(chan int)

	go go_channel(s[:len(s)/2], c)
	go go_channel(s[len(s)/2:], c)

	x, y := <-c, <-c

	fmt.Println(x, y, x+y)

	// 信道缓冲；信道可以是带缓冲的，仅当信道的缓冲区填满后，向其发送数据时才会阻塞。当缓冲区为空时，接受方会阻塞。
	ch := make(chan int, 2)
	ch <- 1
	ch <- 2
	// ch <- 3 //fatal error: all goroutines are asleep - deadlock!
	fmt.Println(<-ch)
	fmt.Println(<-ch)

	//
	c = make(chan int, 10)
	go fibonacci(cap(c), c)
	for i := range c { // for range 可以从信道接受值，直至信道关闭
		fmt.Println(i)
	}

	// select 语句：使一个 Go 程可以等待多个通信操作
	// 阻塞到某个分支可以继续执行为止，这时就会执行该分支。当多个分支都准备好时会随机选择一个执行
	chn := make(chan int)
	quit := make(chan int)
	go func() {
		for i := 0; i < 15; i++ {
			time.Sleep(200 * time.Millisecond)
			fmt.Println("--- ", <-chn) // 从chn里拿
		}
		quit <- 0
	}()
	fibonacci2(chn, quit)

	// select default分支：当 select 中的其它分支都没有准备好时，default 分支就会执行。
	tick := time.Tick(100 * time.Millisecond)
	boom := time.After(5000 * time.Millisecond)
	for {
		select {
		case <-tick:
			fmt.Println("tick.")
		case <-boom:
			fmt.Println("BOOM!")
			return
		default:
			fmt.Println("      .")
			time.Sleep(1000 * time.Millisecond)
		}
	}

}

// 信道是带有类型的管道; 信道在使用前必须创建; 默认无缓冲且会阻塞
func go_channel(s []int, c chan int) {
	sum := 0
	for _, v := range s {
		sum += v
	}
	c <- sum
}

func fibonacci(n int, c chan int) {
	x, y := 0, 1
	for i := 0; i < n; i++ {
		c <- x
		x, y = y, x+y
	}
	close(c) //
}

func fibonacci2(chn, quit chan int) {
	x, y := 0, 1
	for {
		select {
		case chn <- x: // 发送给chn
			x, y = y, x+y
		case <-quit:
			fmt.Println("quit:")
			return
		}
	}
}
