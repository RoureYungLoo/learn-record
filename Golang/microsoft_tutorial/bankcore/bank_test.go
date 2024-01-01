package bank

import "testing"

func TestAccount(t *testing.T) {
	account := Account{
		Customer: Customer{
			Name:  "John",
			Addr:  "Shanghai",
			Phone: "123456",
		},
		Number:   1001,
		Banlance: 0,
	}
	if account.Name == "" {
		t.Error("不能创建对象")
	}
}

func TestDeposit(t *testing.T) {
	account := Account{
		Customer: Customer{
			Name:  "John",
			Addr:  "shanghai",
			Phone: "132142142",
		},
		Number:   1001,
		Banlance: 0,
	}

	account.Deposit(10)

	if account.Banlance != 10 {
		t.Error("account.Deposit failed")
	}
}

func TestWithdraw(t *testing.T) {
	account := Account{
		Customer: Customer{
			Name:  "John",
			Addr:  "shanghai",
			Phone: "132142142",
		},
		Number:   1001,
		Banlance: 0,
	}

	account.Deposit(10)
	account.Withraw(10)

	if account.Banlance != 0 {
		t.Error("account.Deposit failed")
	}
}

func TestStatement(t *testing.T) {
	account := Account{
		Customer: Customer{
			Name:  "John",
			Addr:  "shanghai",
			Phone: "132142142",
		},
		Number:   1001,
		Banlance: 0,
	}

	account.Deposit(100)
	stat := account.Statement()
	if stat != "1001 - John - 100" {
		t.Error("对账单格式错误")
	}
}
