<script setup>

import {useRoute} from "vue-router";

const route = useRoute();
console.log(route)
</script>

<template>
<h1>User</h1>
  <p>{{ $route.fullPath}}</p>
</template>

<style scoped>

</style>