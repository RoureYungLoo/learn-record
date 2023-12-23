package main

import (
	"fmt"
	"io"
	"math/rand"
	"os"
	"regexp"
	"time"
)

var printf = fmt.Printf
var println = fmt.Println
var print = fmt.Print

func get_number() int {
	return 8 //,-1
}
func main() {
	flow_control()
}
func flow_control() {
	fmt.Println("====== glow control ======")
	// golang不支持三元运算符
	var age int = 27
	if age%2 == 0 {
		println("age是偶数")
	}
	if age%2 == 1 {
		println("age是奇数")
	}

	// var num int
	if num := get_number(); num < 0 {
		println(num, "是负数")
	} else if num < 10 {
		println(num, "是1位数")
	} else {
		println(num, "是2位数")
	}
	// println(num) //./flow-control.go:34:10: undefined: num

	// switch
	sec := time.Now().Unix()
	rand.Seed(sec)
	var magic = rand.Int31n(5)
	switch magic {
	case 0:
		print("zero...")
	case 1:
		print("ONE...")
	case 2:
		print("TWO...")
	default:
		print("not match...")
	}
	println("ok")

	// switch multi case
	var location = func(city string) (string, string) {
		var region string
		var continent string
		switch city {
		case "Delhi", "Hyderabad", "Mumbai", "Chennai", "Kochi":
			region, continent = "印度", "亚洲"
		case "Lafaytte", "Louisville", "Boulder":
			region, continent = "科罗拉多", "美国"
		case "Beijing", "Shanghai":
			region, continent = "中国", "亚洲"
		default:
			region, continent = "未知国家", "未知地区"
		}
		return region, continent
	}
	region, continent := location("Shanghai")
	printf("John works in %s, %s. \n", region, continent)

	// switch a function
	switch time.Now().Weekday().String() {
	case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday":
		println("工作日")
	case "Sunday", "Saturday":
		println("休息日")
	}

	// case a function
	var test_switch = func(contact string) {
		var reg_email = regexp.MustCompile(`^[^@]+@[^@.]+\.[^@.]+`)
		var reg_phone = regexp.MustCompile(`^[(]?[0-9][0-9][0-9][). \-]*[0-9][0-9][0-9][.\-]?[0-9][0-9][0-9][0-9]`)
		switch { //省略switch条件
		case reg_email.MatchString(contact):
			println(contact, "is an email")
		case reg_phone.MatchString(contact):
			println(contact, "is a phone number")
		default:
			println(contact, "is not recognized")
		}

		r := rand.Float64()
		switch {
		case r > 0.3 && r < 0.5:
			println("Common case,30%~50% of the time")
		case r > 0.5:
			println("Common case,50% of the time")
		default:
			println("10% of the time")
		}

		num := 15
		switch {
		case num < 50:
			println("num<50")
			fallthrough
		case num > 100:
			println("num>100")
		case num > 200:
			println("num>200")
		}
	}

	test_switch("18113572468")
	test_switch("test@gamil.com")

	var test_loop = func() {
		sum := 0
		for i := 1; i <= 100; i++ { //for loop
			sum += i
		}
		println("sum of 1..100 is ", sum)

		var num int64
		for num != 5 { // while loop
			num = rand.Int63n(15)
			for i := 1; i <= int(num); i++ {
				print("=")
			}
			println()
		}

		for { //break
			println("running in loop...")
			if ctr := rand.Int63n(10); ctr == 5 {
				fmt.Println("finished")
				break
			}
		}

		zoo := 0
		for n := 1; n <= 100; n++ { //continue
			if n%5 == 0 {
				println(n, " skipped")
				continue
			}
			zoo += n
		}
		println("1..100之内不能被5整除的数之和：", zoo)
	}
	test_loop()

	var test_defer = func() {
		for i := 1; i < 5; i++ {
			defer println("defered", -i)
			println("regular", i)
		}

		new_file, err := os.Create("test.txt")
		if err != nil {
			println("creat failed")
			return
		}
		defer func(file *os.File) {
			println("即将关闭文件")
			file.Close()
		}(new_file)

		if _, err = io.WriteString(new_file, "test defer!"); err != nil {
			println("write error")
			return
		}
		new_file.Sync()
	}
	test_defer()
	// test_panic()
	exercise(15)
	exercise(10)
	exercise(12)
	exercise(13)

	println("20以内的质数：")

	for number := 1; number <= 20; number++ {
		if find_primes(number) {
			printf("%v ", number)
		}
	}

	user_input()

}

func highlow(high int, low int) {
	if high < low {
		println("Panic")
		panic("highlow() low greater than high")
	}
	defer println("Derferred: highlow(", high, ",", low, ")")
	println("Call: highlow(", high, ",", low, ")")
	highlow(high, low+1)
}
func test_panic() {
	defer func() {
		handler := recover() //只能在调用 defer 的函数中调用 recover。 如果调用 recover() 函数，则在正常运行的情况下，它会返回 nil，没有任何其他作用。
		if handler != nil {
			println("Main(): recover", handler)
		}
	}()
	highlow(3, 0)
	println("success") // 这一行不会输出
}

func exercise(digit int) {
	if digit >= 1 && digit <= 100 {
		switch {
		case digit%3 == 0 && digit%5 != 0:
			println("Fizz")
		case digit%3 != 0 && digit%5 == 0:
			println("Buzz")
		case digit%3 == 0 && digit%5 == 0:
			println("FizzBuzz")
		default:
			println(digit)
		}
	}
}

func find_primes(number int) bool {
	for i := 2; i < number; i++ {
		if number%i == 0 {
			return false
		}
	}
	if number < 20 {
		return true
	} else {
		return false
	}
}

func user_input() {
	// var val int

	// fmt.Print("输入一个数字")
	// for {
	// 	fmt.Scanf("%d", &val)
	// 	// fmt.Println("你的输入11: ", val)
	// 	switch {
	// 	case val < 0:
	// 		// println("收到负数")
	// 		panic("你输入的是负数")
	// 	case val == 0:
	// 		println("0 is neither negative nor positive")
	// 		continue
	// 	case val > 0:
	// 		println("你的输入22：", val)
	// 		continue
	// 	}
	// }

	val := 0

	for {
		fmt.Print("Enter number: ")
		fmt.Scanf("%d", &val)

		switch {
		case val < 0:
			panic("You entered a negative number!")
		case val == 0:
			fmt.Println("0 is neither negative nor positive")
		default:
			fmt.Println("You entered:", val)
		}
	}
}
