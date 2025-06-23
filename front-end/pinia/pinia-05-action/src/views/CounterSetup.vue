<script setup>

import {useCounterStore} from "@/store/counter.js";

const counterStore = useCounterStore();

function add() {
  counterStore.increment()
}

</script>

<template>
  <p>{{ counterStore.count }}</p>
  <p>{{ counterStore.double }}</p>
  <el-button @click="add()"> +1</el-button>
</template>

<style scoped>

</style>