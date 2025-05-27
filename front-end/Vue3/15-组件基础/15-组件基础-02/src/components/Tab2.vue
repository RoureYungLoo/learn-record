<template>
  <div>
    组件2
  </div>
</template>

<script setup>
import {onMounted, onUnmounted} from "vue";

onMounted(() => {
  console.log("组件2 onMounted")
})
onUnmounted(() => {
  console.log("组件2 onUnmounted")
})
</script>

<style scoped>
</style>