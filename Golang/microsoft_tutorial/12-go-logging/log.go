package main

import (
	"fmt"
	// "log"
	// "os"

	"github.com/rs/zerolog"
	"github.com/rs/zerolog/log"
)

func main() {
	fmt.Println("======== golang log=======")

	// test_log()

	// 日志框架推荐：logrus、zerolog、zap、apex

	test_zerolog()

}

func test_log() {
	// log.SetPrefix("main(): ")

	// log.Print("这一行是日志")

	// log.Fatal("程序出错了崩溃了")
	// log.Print("这一行不会被输出")

	// log.Panic("程序出错了崩溃了")
	// log.Print("这一行不会被输出")

	// 记录日志到文件
	// file, err := os.OpenFile("info.log", os.O_CREATE|os.O_APPEND|os.O_WRONLY, 0644)
	// if err != nil {
	// 	log.Fatal(err)
	// }
	// defer file.Close()

	// log.SetOutput(file)
	// log.Print("this is a log.")
}

func test_zerolog() {
	zerolog.TimeFieldFormat = zerolog.TimeFormatUnix
	log.Print("这是一行日志")

	log.Debug().Int("EmpID", 1001).Msg("获取员工信息")

	log.Debug().Str("Name", "John").Send()

}
