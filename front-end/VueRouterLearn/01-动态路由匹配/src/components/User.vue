<template>
  <div>
    <h4>User: {{ $route.params.id }}</h4>
    <h4>User: {{ $route.params.username }}</h4>
    <h4>{{ $route.params.postId }}</h4>
    <h4>User: {{ $route.params.afterUser }}</h4>


  </div>
</template>

<script setup>
import {useRoute, useRouter} from 'vue-router'
import {watch} from "vue";

const route = useRoute()
console.log(route.params)
console.log(route)

// getter函数
const getter = function () {
  return route.params
}

// 回调函数
const callback = function (newValue, oldValue) {
  console.log(oldValue)
  console.log(newValue)
}

// 监听路由变化
watch(getter, callback)

</script>

<style scoped>

</style>