<script setup>

import {useRoute, useRouter} from "vue-router";

let route = useRoute();
let router = useRouter();

console.log(route)
console.log(router)
</script>

<template>
  <p>current: route.fullPath:{{ $route.fullPath }}</p>
  <nav>
    <RouterLink to="/">首页</RouterLink> &nbsp;
    <RouterLink to="/about">关于</RouterLink>
  </nav>

  <RouterView/>

</template>

<style scoped>

</style>
