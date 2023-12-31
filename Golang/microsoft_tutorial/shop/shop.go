package shop

import "fmt"

// 在线商店管理程序包

type Account struct {
	FirstName string // 名字
	LastName  string // 姓氏
}

func (a *Account) ChangeName(firstname, lastname string) {
	a.FirstName = firstname
	a.LastName = lastname
}

// func (a *Account) String() string {
// 	return fmt.Sprintf("姓名：%s %s.\n", a.LastName, a.FirstName)
// }

type Employee struct {
	Account
	balance float64 //账户余额
}

func (e *Employee) AddCredits(f float64) {
	e.balance += f
}

func (e *Employee) RemoveCredits(f float64) {
	e.balance -= f

}

func (e *Employee) CheckCredits() {
	fmt.Printf("当前账户余额：%v.\n", e.balance)
}

func (e *Employee) String() string {
	return fmt.Sprintf("姓名：%s %s, 余额：%v.\n", e.LastName, e.FirstName, e.balance)
}

/* 官方代码
package store

import (
    "errors"
    "fmt"
)

type Account struct {
    FirstName string
    LastName  string
}

type Employee struct {
    Account
    Credits float64
}

func (a *Account) ChangeName(newname string) {
    a.FirstName = newname
}

func (e Employee) String() string {
    return fmt.Sprintf("Name: %s %s\nCredits: %.2f\n", e.FirstName, e.LastName, e.Credits)
}

func CreateEmployee(firstName, lastName string, credits float64) (*Employee, error) {
    return &Employee{Account{firstName, lastName}, credits}, nil
}

func (e *Employee) AddCredits(amount float64) (float64, error) {
    if amount > 0.0 {
        e.Credits += amount
        return e.Credits, nil
    }
    return 0.0, errors.New("Invalid credit amount.")
}

func (e *Employee) RemoveCredits(amount float64) (float64, error) {
    if amount > 0.0 {
        if amount <= e.Credits {
            e.Credits -= amount
            return e.Credits, nil
        }
        return 0.0, errors.New("You can't remove more credits than the account has.")
    }
    return 0.0, errors.New("You can't remove negative numbers.")
}

func (e *Employee) CheckCredits() float64 {
    return e.Credits
}

===========================================

package main

import (
    "fmt"
    "store"
)

func main() {
    bruce, _ := store.CreateEmployee("Bruce", "Lee", 500)
    fmt.Println(bruce.CheckCredits())
    credits, err := bruce.AddCredits(250)
    if err != nil {
        fmt.Println("Error:", err)
    } else {
        fmt.Println("New Credits Balance = ", credits)
    }

    _, err = bruce.RemoveCredits(2500)
    if err != nil {
        fmt.Println("Can't withdraw or overdrawn!", err)
    }

    bruce.ChangeName("Mark")

    fmt.Println(bruce)
}
*/
