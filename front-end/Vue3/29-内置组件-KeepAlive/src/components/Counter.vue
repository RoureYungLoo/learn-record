<script setup>

import {onActivated, onDeactivated, ref} from "vue";

const counter = ref(0)

onActivated((a, b, c) => {
  console.log(a, b, c)
})
onDeactivated((a, b, c) => {
  console.log(a, b, c)
})
</script>

<template>
  Count: {{ counter }}
  <button @click="counter++">+1</button>
</template>

<style scoped>

</style>