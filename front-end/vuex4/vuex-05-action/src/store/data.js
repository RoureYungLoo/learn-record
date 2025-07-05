export function getData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve({
        user: "lisi",
        pwd: "123456"
      })
    }, 500)
  })
}

export function getOtherData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve({
        user: "zhangsan",
        pwd: "zhangsan666"
      })
    }, 100)
  })
}