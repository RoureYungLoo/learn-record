<script setup>
import {useRouter} from 'vue-router'

let randomName = Math.floor(Math.random() * 1000000).toString(16)
const router = useRouter()
const username = randomName

/* 路由对象 */
const obj = {
  // path: '/users/eduardo'
  path: `/users/${username}`
}

//注意这里是 name + params
const obj2 = {
  name: 'user', // 命名路由
  params: { // 路径参数
    // username: 'zhangsan'
    username: username
  }
}
// query字符串
const obj3 = {
  // path: '/register',
  name: "reg",
  query: {
    plan: 'private',
    username: randomName,
    age: Math.floor(Math.floor(100))
  }
}

const obj4 = {
  path: '/register',
  hash: '#team',

  // Path "/register" was passed with params but they will be ignored.
  // Use a named route alongside params instead.
  /*params: {
    param1: '123'
  }*/
}

const obj5 = {
  path: '/register',
  hash: '#team',
  replace: true, // 是否替换(栈顶),  加上这个，router.push(obj5) 等价于 router.replace(obj5)
}
/* path 不能和 param 一起使用 */

const obj6={
  name:"user",
  // params:[
  //     'str1','str2',123,234
  // ],
  params:{
    username:randomName
  }
}

const change = () => {

  /* 编程式路由 */
  // router.push('/users/' + randomName) // 字符串路径
  // router.push(obj) // 带有路径的对象
  // router.push(obj2) // 命名路由和路径参数
  // router.push(obj3) // 带有路径和query查询参数的对象
  // router.push(obj4) // 带 hash，结果是 /register#team

  // router.push(`/users/${username}`)
  // router.push(obj2)
  // router.push(obj3)
  // router.push(obj4)
  router.push(obj6)


  // router.replace(obj3)

}

/* 前进 */
const forward = () => {
  router.go(1)
}

/* 后退 */
const back = () => {
  router.go(-1)
}

</script>

<template>
  <h1 @click="change">Home.vue</h1>
  <button @click="back">👈</button>
  <button @click="forward">👉</button>
</template>

<style scoped>
</style>
