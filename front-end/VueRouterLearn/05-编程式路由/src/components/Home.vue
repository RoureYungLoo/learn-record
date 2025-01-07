<script setup>
import {useRouter} from 'vue-router'

const router = useRouter()
const username="zhangsan"

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
  path: '/register',
  query: {
    plan: 'private'
  }
}

const obj4 = {
  path: '/register',
  hash: '#team'
}

const obj5 = {
  path: '/register',
  hash: '#team',
  replace: true, // 加上这个，router.push(obj5) 等价于 router.replace(obj5)
}
/* path 不能和 param 一起使用 */

const change = () => {
  /* 编程式路由 */
  // router.push('/users/eduardo') // 字符串路径
  // router.push(obj) // 带有路径的对象
  // router.push(obj2) // 命名路由和路径参数
  // router.push(obj3) // 带有路径和query查询参数的对象
  // router.push(obj4) // 带 hash，结果是 /register#team

  // router.push(`/users/${username}`)
  // router.push(obj2)
  router.push(obj3)


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
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.greetings h1,
.greetings h3 {
  text-align: center;
}

@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
}
</style>
