/*
 * @Description: Description
 * @Version: 1.0
 * @Author: luruoyang
 * @Date: 2023-05-25 00:36:59
 * @LastEditors: luruoyang
 * @LastEditTime: 2023-05-25 01:42:13
 */
#include <spdlog/spdlog.h>

#include <iostream>
int main(int argc, char const *argv[]) {
  /* code */
  spdlog::info("Log level info.");
  spdlog::error("Some error message with arg: {}", 1);
  spdlog::warn("Easy padding in numbers like {:08d}", 12);
  spdlog::critical(
      "Support for int: {0:d};  hex: {0:x};  oct: {0:o}; bin: {0:b}", 42);
  spdlog::info("Support for floats {:03.2f}", 1.23456);
  spdlog::info("Positional args are {1} {0}..", "too", "supported");
  spdlog::info("{:<30}", "left aligned");

  spdlog::set_level(spdlog::level::debug);  // Set global log level to debug
  spdlog::debug("This message should be displayed..");

  // change log pattern
  spdlog::set_pattern("[%H:%M:%S %z] [%n] [%^---%L---%$] [thread %t] %v");

  // Compile time log levels
  // define SPDLOG_ACTIVE_LEVEL to desired level
  SPDLOG_TRACE("Some trace message with param {}", 42);
  SPDLOG_DEBUG("Some debug message");
  return 0;
}
