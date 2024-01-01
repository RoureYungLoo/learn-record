package main

import (
	"fmt"
	"math/rand"
	"net/http"
	"time"
)

func main() {
	fmt.Println("====== concurrency ======")
	/*
		实现并发的方法：
		1、多进程 multi-process
		2、多线程 multi-thread （LWT：轻量级线程）
		3、协程 coroutine
		golang实现并发的方法：goroutine + channel，不是通过共享内存通信，而是通过通信共享内存
	*/
	// test_goroutine()
	// test_channel()
	// test_unbuffered_channel()
	// test_buffered_channel()
	// test_buffered_channel2()
	// test_chan_direction()
	// test_reuse()
	test_challenge()

}

func test_goroutine() {
	// go func_name()
	start := time.Now()
	apis := []string{
		"https://management.azure.com",
		"https://dev.azure.com",
		"https://api.github.com",
		"https://outlook.office.com/",
		"https://api.somewhereintheinternet.com/",
		"https://graph.microsoft.com",
	}

	// for _, api := range apis { // 一个一个检查网站是否在运行
	// 	_, err := http.Get(api)
	// 	if err != nil {
	// 		fmt.Printf("ERROR: %s is down.\n", api)
	// 		continue
	// 	}
	// 	fmt.Printf("SUCCESS: %s is up and running.\n", api)
	// }

	for _, api := range apis { // 同时检查所有的网站
		go checkApi(api)
	}

	elapsed := time.Since(start)

	time.Sleep(3 * time.Second) // 不加此行代码程序会立即往下运行，无论checkApi协程是否return

	fmt.Printf("Done. It took %v seconds.\n", elapsed.Seconds())
}

func checkApi(api string) {
	_, err := http.Get(api)
	if err != nil {
		fmt.Printf("ERROR: %s is down.\n", api)
		return
	}
	fmt.Printf("SUCCESS: %s is up and running.\n", api)
}

// channel: goroutine 之间的通信机制；golang并发不是通过共享内存通信，而是通过通信共享内存

func test_channel() {
	// 声明一个传输int类型的channel
	// ch := make(chan int)

	// ch <- xxx , 向通道ch发送数据
	// yyy = <- ch, 从通道ch接受数据
	//<- ch, 从通道ch接受数据，收到的数据被丢弃
	// 通道close后，不再向该通道发送数据。向closed的Chanel发送数据会导致程序崩溃；从closed的Chanel读取数据，会一次性将Chanel的
	// 所有数据读取出来，后续再读取将获得零值。
	start := time.Now()
	ch := make(chan string)
	apis := []string{
		"https://management.azure.com",
		"https://dev.azure.com",
		"https://api.github.com",
		"https://outlook.office.com/",
		"https://api.somewhereintheinternet.com/",
		"https://graph.microsoft.com",
	}

	for _, api := range apis { // 同时检查所有的网站
		go checkApi2(api, ch)
	}

	// fmt.Print(<-ch) // 放到这里只有一条输出
	// fmt.Print(<-ch) // 放到这里只有一条输出
	// fmt.Print(<-ch) // 放到这里只有一条输出
	// fmt.Print(<-ch) // 放到这里只有一条输出
	// fmt.Print(<-ch) // 放到这里只有一条输出
	// fmt.Print(<-ch) // 放到这里只有一条输出
	// fmt.Print(<-ch) // 会阻塞，只有发送方发送数据时，才会继续运行

	for i := 0; i < len(apis); i++ {
		fmt.Print(<-ch)
	}
	elapsed := time.Since(start)
	fmt.Printf("Done. It took %v seconds.\n", elapsed.Seconds())
}

func checkApi2(api string, ch chan string) {
	_, err := http.Get(api)
	if err != nil {
		ch <- fmt.Sprintf("ERROR: %s is down.\n", api)
		return
	}
	ch <- fmt.Sprintf("SUCCESS: %s is up and running.\n", api)
}

/*
make(chan datatype), 默认创建无缓冲通道。当通道的另一方没有接收者时，向该通道发送数据会阻塞，直到有接收者接收数据，接收同样是阻塞的
*/
func test_unbuffered_channel() {

}

func test_buffered_channel() {
	SIZE := 2
	ch := make(chan string, SIZE) //缓冲区大小10字节
	send(ch, "one")
	send(ch, "two")
	go send(ch, "three")
	go send(ch, "four")
	fmt.Println("发送完毕")

	for i := 0; i < 4; i++ {
		fmt.Println(<-ch)
	}

	fmt.Println("Done.")
}

func send(ch chan string, msg string) {
	ch <- msg
}

func test_buffered_channel2() {
	start := time.Now()

	apis := []string{
		"https://management.azure.com",
		"https://dev.azure.com",
		"https://api.github.com",
		"https://outlook.office.com/",
		"https://api.somewhereintheinternet.com/",
		"https://graph.microsoft.com",
	}

	ch := make(chan string, 2)

	for _, api := range apis {
		go checkApi2(api, ch)
	}

	for i := 0; i < len(apis); i++ {
		fmt.Print(<-ch)
	}

	elapsed := time.Since(start)
	fmt.Printf("Done! It took %v seconds!\n", elapsed.Seconds())
}

// 有缓冲将发送和接收操作解耦，无缓冲同步通信

// channel方向
func test_chan_direction() {
	// 声明一个只进行发送数据的channel
	var ch1 chan<- int // 只能向这个通道发送数据
	// 声明一个只进行发接收数据的channel
	var ch2 <-chan int // 只能从这个通道接收数据
	fmt.Println(ch1)
	fmt.Println(ch2)

	chn := make(chan string, 1)
	send2(chn, "hello world")
	read2(chn)
}

func send2(ch_send_only chan<- string, msg string) {
	fmt.Printf("Sending: %#v\n", msg)
	ch_send_only <- msg
	// <-ch_send_only // invalid operation: cannot receive from send-only channel ch_send_only (variable of type chan<- string)
}
func read2(ch_receive_only <-chan string) {
	fmt.Printf("Receiving: %#v\n", ch_receive_only)
	// ch_receive_only <- "bye" // invalid operation: cannot send to receive-only channel ch_read_onlyh (variable of type <-chan string)
}

// 多路复用 select case，而非其他IO多路复用select、poll、epoll
func test_reuse() {
	chn1 := make(chan string)
	chn2 := make(chan string)

	go process(chn1)
	go replicating(chn2)

	for i := 0; i < 2; i++ {
		// for {
		select {
		case p := <-chn1:
			fmt.Println(p)
		case r := <-chn2:
			fmt.Println(r)
			// default:
			// time.Sleep(500 * time.Millisecond)
			// fmt.Println("no data")
		}
	}
}

func process(ch chan string) {
	time.Sleep(3 * time.Second)
	ch <- "处理完成"
}

func replicating(ch chan string) {
	time.Sleep(1 * time.Second)
	ch <- "复制完成"
}

func test_challenge() {
	// raw_fibonacci()
	new_fibonacci()
}

func raw_fibonacci() {
	start := time.Now()

	chn := make(chan float64, 20)

	for i := 0; i < 15; i++ {
		// n := fib(float64(i))
		go fib(float64(i), chn)
		// fmt.Printf("Fib(%v): %v\n", i, <-chn)
	}

	for i := 0; i < 15; i++ {
		fmt.Printf("Fib(%v): %v\n", i, <-chn)
	}

	elapsed := time.Since(start)
	fmt.Printf("Done. 花费了 %v 秒", elapsed.Seconds())
}

func fib(num float64, ch chan float64) {
	x, y := 1.0, 1.0
	for i := 0; i < int(num); i++ {
		x, y = y, x
	}

	r := rand.Intn(2)
	time.Sleep(time.Duration(r) * time.Second)

	// return x
	ch <- x
}

var chn1 = make(chan int)
var chn2 = make(chan string)

func new_fibonacci() {
	start := time.Now()

	go Fibnacci()
	go handle_input()

	time.Sleep(1 * time.Second)

	elapsed := time.Since(start)

	fmt.Printf("Done! It took %v seconds!\n", elapsed.Seconds())
}

func handle_input() {
	var input string
	for {
		fmt.Println(<-chn1)
		fmt.Scanf("%s", &input)
		if input == "quit" {
			chn2 <- input
			break
		}
	}
}

func Fibnacci() {
	x, y := 1, 1
	for {
		select {
		case chn1 <- x:
			x, y = y, x+y
		case input := <-chn2:
			if input == "quit" {
				fmt.Println("停止计算斐波那契数列")
			}
		}
	}
}

/*
package main

import (
    "fmt"
    "time"
)

var quit = make(chan bool)

func fib(c chan int) {
    x, y := 1, 1

    for {
        select {
            case c <- x:
                x, y = y, x+y
            case <-quit:
                fmt.Println("Done calculating Fibonacci!")
            return
        }
    }
}

func main() {
    start := time.Now()

    command := ""
    data := make(chan int)

    go fib(data)

    for {
        num := <-data
        fmt.Println(num)
        fmt.Scanf("%s", &command)
        if command == "quit" {
            quit <- true
            break
        }
    }

    time.Sleep(1 * time.Second)

    elapsed := time.Since(start)
    fmt.Printf("Done! It took %v seconds!\n", elapsed.Seconds())
}
*/
