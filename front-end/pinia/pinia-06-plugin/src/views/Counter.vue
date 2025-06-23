<script setup>

import {useCounterStore} from "@/stores/counter.js";

const counterStore = useCounterStore();
// console.log("counterStore", counterStore)

const changeSharedData = () => {
  counterStore.sharedData = `modified by CounterVue at ${new Date().toLocaleString()}`
}

const changeHasError = () => {
  counterStore.hasError = !counterStore.hasError
}
</script>

<template>
  <h3>Counter</h3>
  <p>counterStore.sharedData: {{ counterStore.sharedData }}</p>
  <el-button @click="changeSharedData">changeSharedData</el-button>
  <p> counterStore.hasError: {{ counterStore.hasError }}</p>
  <el-button @click="changeHasError">changeHasError</el-button>
  <el-button @click="counterStore.$reset()">reset</el-button>
</template>

<style scoped>

</style>