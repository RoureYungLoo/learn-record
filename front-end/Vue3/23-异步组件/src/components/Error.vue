<template>
<h2>Something error</h2>
  <p>出错了</p>
</template>

<script setup>
import {onMounted} from "vue";

onMounted(()=>{
  console.log("Error.vue mounted")
})
</script>

<style scoped>

</style>