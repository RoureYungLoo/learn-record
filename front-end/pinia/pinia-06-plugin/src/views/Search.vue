<script setup>

import {useSearchStore} from "@/stores/search.js";

const numbers = [1, 2, 3, 4]
const searchStore = useSearchStore();
const sum = numbers.reduce((previousValue, currentValue, currentIndex, array) => {
  // console.log(`previousValue: ${previousValue} , currentValue: ${currentValue} , currentIndex: ${currentIndex}`)
  return previousValue + currentValue
// })
}, 100 /* 初始值 */)

/* 如果没有提供initialValue，reduce 会从索引1的地方开始执行 callback 方法，跳过第一个索引。
    如果提供initialValue，从索引0开始。 */




</script>

<template>
  <h1>Search</h1>
  <p>数组的和是: {{ sum }}</p>
</template>

<style scoped>

</style>