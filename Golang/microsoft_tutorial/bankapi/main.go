package main

import (
	"fmt"
	bank "hellowrold/bankcore"
	"log"
	"net/http"
	"strconv"
)

var ACCOUNTS = map[float64]*bank.Account{}

func main() {
	fmt.Println(bank.Hello())
	ACCOUNTS[1001] = &bank.Account{
		Customer: bank.Customer{
			Name:  "John",
			Addr:  "shanghai",
			Phone: "124213",
		},
		Number: 1001,
	}

	http.HandleFunc("/stat", statement)

	http.HandleFunc("/deposit", deposit)

	http.HandleFunc("/withdraw", withdraw)
	log.Fatal(http.ListenAndServe("localhost:8000", nil))
}

// 存款
func deposit(w http.ResponseWriter, req *http.Request) {
	numberqs := req.URL.Query().Get("number")
	amountqs := req.URL.Query().Get("amount")

	if numberqs == "" {
		fmt.Fprintf(w, "Account number is missing!")
		return
	}

	if number, err := strconv.ParseFloat(numberqs, 64); err != nil {
		fmt.Fprintf(w, "账户无效")
	} else if amount, err := strconv.ParseFloat(amountqs, 64); err != nil {
		fmt.Fprintf(w, "amount无效")
	} else {
		account, ok := ACCOUNTS[number]
		if !ok {
			fmt.Fprintf(w, "Account with number %v can't be found!", number)
		} else {
			err := account.Deposit(amount)
			if err != nil {
				fmt.Fprintf(w, "%v", err)
			} else {
				fmt.Fprintf(w, account.Statement())
			}
		}
	}
}

// 取款
func withdraw(w http.ResponseWriter, req *http.Request) {
	numberqs := req.URL.Query().Get("number")
	amountqs := req.URL.Query().Get("amount")

	if numberqs == "" {
		fmt.Fprintf(w, "Account number is missing!")
		return
	}

	if number, err := strconv.ParseFloat(numberqs, 64); err != nil {
		fmt.Fprintf(w, "Invalid account number!")
	} else if amount, err := strconv.ParseFloat(amountqs, 64); err != nil {
		fmt.Fprintf(w, "Invalid amount number!")
	} else {
		account, ok := ACCOUNTS[number]
		if !ok {
			fmt.Fprintf(w, "Account with number %v can't be found!", number)
		} else {
			err := account.Withraw(amount)
			if err != nil {
				fmt.Fprintf(w, "%v", err)
			} else {
				fmt.Fprintf(w, account.Statement())
			}
		}
	}
}

// 查看对账单
func statement(w http.ResponseWriter, req *http.Request) {
	numberqs := req.URL.Query().Get("number")

	if numberqs == "" {
		fmt.Fprintf(w, "Account number is missing!")
		return
	}

	if number, err := strconv.ParseFloat(numberqs, 64); err != nil {
		fmt.Fprintf(w, "无效账户")
	} else {
		accout, ok := ACCOUNTS[number]
		if !ok {
			fmt.Fprintf(w, "没有找到该账户: %v", number)
		} else {
			fmt.Fprintf(w, accout.Statement())
		}
	}
}

// TDD  Testing Driven Development, 测试驱动开发，文件必须以"_test.go"结尾
// 要编写的每个测试都必须是以 Test 开头的函数
// 测试文件时，该文件的名称必须以 _test.go 结尾
