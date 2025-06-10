<script setup>
</script>

<template>

  <RouterLink to="/">
    首页
  </RouterLink>

  <RouterLink to="/about">
    关于
  </RouterLink>
  <br>
  <RouterLink to="/login">Login</RouterLink>
  <br>
  <RouterLink to="/todo/100">Todo 100</RouterLink>
  <br>
  <RouterLink to="/todo/101">Todo 101</RouterLink>
  <br>
  <br>
  <br>
  <RouterView/>
</template>

<style scoped>

</style>
