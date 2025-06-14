<template>
  <div class="home">
    <h1>HomeView.vue</h1>
    <h2>HomeView{{ $route.params }}</h2>
    <h2>HomeView{{ $route.fullPath }}</h2>
  </div>
</template>

<script setup>
import {useRoute} from "vue-router";

const route = useRoute();
console.log(route);
</script>

<style scoped>
.home{
  background-color: lightblue;
}
</style>