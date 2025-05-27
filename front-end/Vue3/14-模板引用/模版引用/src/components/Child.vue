<script setup>

import {ref} from "vue";

const counter = ref(0)
const getCounter = () => {
  console.log("in child", counter.value)
}
const setCounter = (delta) => {
  console.log("in child setCounter delta", delta)
  counter.value += delta
}

/* 使用了setup语法糖的组件默认私有
必须在 任何await方法前 调用,否则会无法访问暴露的属性和方法 */
defineExpose({
  getCounter,
  setCounter
})
</script>

<template>
  <h3>counter is : {{ counter }}</h3>
</template>

<style scoped>

</style>