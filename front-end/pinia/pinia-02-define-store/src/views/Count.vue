<script setup>

import useCountStore from "@/stores/count.js";
import {storeToRefs} from "pinia";

const countStore = useCountStore();

/* 解构store会失去响应式 */
const {count} = countStore

/* 使用storeToRefs() 保证解构出来的属性具有响应式 */
const {doubleCount} = storeToRefs(countStore)

// setInterval(() => {
//   countStore.increment()
// }, 1000)

</script>

<template>
  <h1>Count</h1>
  <h3>count: {{ countStore.count }}</h3>
  <h3>doubleCount: {{ countStore.doubleCount }}</h3>
  <h3>name: {{ countStore.name }}</h3>
  <a-card>
    <a-button type="primary" @click="countStore.increment()">+1</a-button>
    <a-button type="primary" @click="countStore.decrement()">-1</a-button>
    <a-button type="primary" @click="countStore.getNewName()">getNewName</a-button>
  </a-card>
  <p>{{ countStore.user }}</p>
  <p> 解构后的count {{ count }}</p>
  <p>解构后的 doubleCount {{ doubleCount }}</p>
</template>

<style scoped>

</style>