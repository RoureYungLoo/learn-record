<script setup>

import {useRoute} from "vue-router";

let route = useRoute();
console.log(route)
</script>

<template>
  <h2>User.vue {{ $route.params }}</h2>
</template>

<style scoped>

</style>
