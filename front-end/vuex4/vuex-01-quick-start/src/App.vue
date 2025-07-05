<script setup>

import {store} from "@/store/counter.js";

const add = () => {
  store.commit('increment')
}
</script>

<template>
  <h3>{{ store.state.count }}</h3>
  <button @click="add">commit</button>
  <button @click="store.commit('decrement')">decrement</button>

</template>

<style scoped>

</style>
