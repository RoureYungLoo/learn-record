<script setup>

import {useCountStore} from "@/stores/counter.js";

const countStore = useCountStore();
const plusOne = () => {
  countStore.increment()

  // countStore.$patch(
  //     {
  //       count: countStore.count + 1
  //     }
  //     )

}
</script>

<template>
  <div class="container">
    <h2>Home</h2>
    <a-button type="primary" @click="plusOne">+1</a-button>

  </div>
</template>

<style scoped>
.container {
  border: 1px solid black;
  padding: 10px;
}
</style>