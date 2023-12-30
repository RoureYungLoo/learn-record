package main

import (
	"encoding/json"
	"fmt"
	"io"
	"log"
	"math"
	"net/http"
	"os"
)

func main() {
	fmt.Println("====== interface ======")
	// golang中的接口是只支持隐式实现的，golang不提供接口实现关键字
	// test_interface()
	// test_string()
	// test_extend()
	test_http()

}

// 声明接口：只有方法声明
type Shape interface {
	GetPerimeter() float64
	GetArea() float64
}

// 实现接口：实现了接口中定义的所有方法时，自动实现该接口（隐式实现）
type Square struct {
	edge float64
}

func (s Square) GetArea() float64 {
	return s.edge * s.edge
}

func (s Square) GetPerimeter() float64 {
	return s.edge * 4
}

func test_interface() {
	var s Shape = Square{3} //多态
	print_info(s)

	var c Shape = Circle{3} //多态
	print_info(c)
}

type Circle struct {
	radius float64
}

func (c Circle) GetArea() float64 {
	return math.Pi * c.radius * c.radius
}

func (c Circle) GetPerimeter() float64 {
	return 2 * math.Pi * c.radius
}

func print_info(s Shape) {
	fmt.Printf("%T\n", s)
	fmt.Println("Area: ", s.GetArea())           //多态
	fmt.Println("Perimeter: ", s.GetPerimeter()) //多态

	fmt.Printf("%s", s) // 自定义String()方法

	fmt.Println()
}

// 实现字符串接口
// type Stringer interface{
// 	String() string
// }

// 编写自定义String()方法, 类似重写Java中的tostring()方法
func (s Square) String() string {
	return fmt.Sprintf("正方形的面积：%v, 正方形的周长: %v", s.GetArea(), s.GetPerimeter())
}

func (c Circle) String() string {
	return fmt.Sprintf("圆形的面积：%v, 圆形的周长: %v", c.GetArea(), c.GetPerimeter())
}

type Person struct {
	Name, Country string
}

func (p Person) String() string {
	return fmt.Sprintf("%v is from %v", p.Name, p.Country)
}

func test_string() {
	p1 := Person{"asan", "印度"}
	p2 := Person{"lisi", "中国"}

	fmt.Printf("%s\n%s\n", p1, p2)
}

// 扩展现有实现
type myWriter struct{}

type GitHubResp []struct {
	FullName string `json:"full_name"`
}

func (w myWriter) Write(p []byte) (n int, err error) {
	var resp GitHubResp
	json.Unmarshal(p, &resp)
	for _, r := range resp {
		fmt.Println(r.FullName)
	}
	return len(p), nil
}

var my_github_repo_url = "https://api.github.com/users/microsoft/repos?page=15&per_page=3"

func test_extend() {
	resp, err := http.Get(my_github_repo_url)
	if err != nil {
		fmt.Println("error: ", err)
		os.Exit(1)
	}
	writer := myWriter{}
	io.Copy(writer, resp.Body)
}

type dollars float32

func (d dollars) String() string {
	return fmt.Sprintf("$%.2f", d)
}

type database map[string]dollars

func (db database) ServeHTTP(w http.ResponseWriter, req *http.Request) {
	for item, price := range db {
		fmt.Fprintf(w, "%s: %s\n", item, price)
	}
}

func test_http() {
	db := database{"Go T-shirt": 25, "Go Jacket": 55}
	log.Fatal(http.ListenAndServe("localhost:8080", db))
}
