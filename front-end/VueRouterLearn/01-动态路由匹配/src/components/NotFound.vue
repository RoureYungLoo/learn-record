<template>
  <h1>NotFound 404</h1>
  <h4> {{ $route.params.pathMatch }}</h4>
</template>

<script setup>
import {useRoute} from 'vue-router'
import {watch} from "vue";

const route = useRoute()

// getter函数
const getter = function () {
  return route.params
}

// 回调函数
const callback = function (newValue, oldValue) {
  console.log(oldValue)
  console.log(newValue)
}

watch(getter, callback)


</script>

<style scoped>

</style>