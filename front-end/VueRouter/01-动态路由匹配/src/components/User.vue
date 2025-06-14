<template>
  <div>
    <h4>$route.params.id: {{ $route.params.id }}</h4>
    <h4>$route.params.username: {{ $route.params.username }}</h4>
    <h4>$route.params.postId: {{ $route.params.postId }}</h4>
    <h4>$route.params.afterUser: {{ $route.params.afterUser }}</h4>
  </div>
</template>

<script setup>
import {useRoute, useRouter} from 'vue-router'
import {watch} from "vue";

const route = useRoute()
console.log("route",route)
console.log("route.params",route.params)

// getter函数
const getter = function () {
  return route.params.id
}

// 回调函数
const callback = function (newValue, oldValue) {
  console.log("newValue "+newValue, "oldValue: "+oldValue)
}

// 监听路由变化
watch(getter, callback)

</script>

<style scoped>

</style>