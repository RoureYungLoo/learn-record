<template>
  <h2>Loading ...</h2>
  <p>正在加载中</p>
</template>

<script setup>
import {onMounted} from "vue";

onMounted(()=>{
  console.log("Loading.vue mounted")
})
</script>

<style scoped>

</style>