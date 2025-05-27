<script setup>

import {ref} from "vue";
const counter = ref(0)
</script>

<template>
  <button @click="counter++">点击了{{ counter }}次</button>
</template>

<style scoped>

</style>