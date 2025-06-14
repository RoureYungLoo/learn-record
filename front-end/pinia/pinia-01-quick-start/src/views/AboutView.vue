<script setup>

import {useCountStore} from "@/stores/counter.js";

const counter = useCountStore();
const subOne = () => {
  counter.decrement()
}
</script>


<template>
  <div class="container">
    <h2>About</h2>
    <a-button type="primary" @click="subOne">-1</a-button>

  </div>
</template>

<style scoped>
.container {
  border: 1px solid black;
  padding: 10px;
}
</style>