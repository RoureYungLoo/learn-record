package main

import (
	"errors"
	"fmt"
	// "time"
)

var ErrNotFound = errors.New("Employee not found!")

type Employee struct {
	ID        int
	FirstName string
	LastName  string
	Address   string
}

func getInfo(id int) (*Employee, error) {
	// for tries := 0; tries < 3; tries++ {
	// 	employee, err := apiCallEmployee(1000)
	// 	if err == nil {
	// 		// return nil, err
	// 		// return nil, fmt.Errorf("Got an error when getting the employee information: %v", err)
	// 		return employee, nil
	// 	}
	// 	fmt.Println("Server is not responding, retrying ...")
	// 	time.Sleep(time.Second * 2)
	// }
	// return nil, fmt.Errorf("server has failed to respond to get the employee information")
	if id != 1001 {
		return nil, ErrNotFound
	}
	employee := Employee{LastName: "Doe", FirstName: "John"}
	return &employee, nil
}

func apiCallEmployee(id int) (*Employee, error) {
	employee := Employee{LastName: "Doe", FirstName: "John"}
	return &employee, nil
}
func main() {
	// 在 Go 中，可能失败的函数应始终返回一个额外值，以便你能够成功预测和管理失败。
	employee, err := getInfo(1002)
	// if err != nil {
	if errors.Is(err, ErrNotFound) {
		// fmt.Printf("出错了, %s", err.Error())
		fmt.Printf("出错了, %v", err)
	} else {
		fmt.Println(employee)
	}

}
