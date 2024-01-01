package bank

import (
	"errors"
	"fmt"
)

func Hello() string {
	return "Hey, I'm working!"
}

type Customer struct {
	Name  string
	Addr  string
	Phone string
}

type Account struct {
	Customer
	Number   int32
	Banlance float64
}

func (a *Account) Deposit(amount float64) error {
	if amount < 0 {
		return errors.New("存入金额不能小于0")
	}

	a.Banlance += amount
	return nil
}

func (a *Account) Withraw(amount float64) error {
	if amount < 0 {
		return errors.New("取出金额不能小于0")
	}
	if a.Banlance < amount {
		return errors.New("余额不足")
	}

	a.Banlance -= amount
	return nil
}

func (a *Account) Statement() string {
	return fmt.Sprintf("%v - %v - %v", a.Number, a.Name, a.Banlance)
}
