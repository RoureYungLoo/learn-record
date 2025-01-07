<template>
  <h1>UserView</h1>
  <h2>UserView{{ $route.params }}</h2>
  <h2>UserView{{ $route.fullPath }}</h2>

  <RouterView/>
</template>

<script setup>
import {useRoute} from 'vue-router'

var route = useRoute();
console.log(route)
</script>

<style scoped>

</style>