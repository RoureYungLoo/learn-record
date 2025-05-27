<template>
  <div v-if="error">Error encountered: {{ error.message }}</div>
  <div v-else-if="data">
    {{ data }}
  </div>
  <div v-else>Loading....</div>
  <div @click="changeUrl">改变URL</div>

</template>


<script setup>

import {ref} from "vue";
import {useFetch} from "@/utils/fetch.js";


// const data = ref(null)
// const error = ref(null)
// fetch('https://jsonplaceholder.typicode.com/todos/1')
//     .then((res) => res.json())
//     .then((json) => (data.value = json))
//     .catch((err) => (error.value = err))

const url = ref("https://jsonplaceholder.typicode.com/todos/1")

// 组合式函数接收字符串
// const {data, error} = useFetch('https://jsonplaceholder.typicode.com/todos/1')
// 组合式函数接收响应式参数
const {data, error} = useFetch(url)

// const changeUrl = () => {
//   url.value = "https://jsonplaceholder.typicode.com/todos/2"
// }
</script>

<style scoped>

</style>