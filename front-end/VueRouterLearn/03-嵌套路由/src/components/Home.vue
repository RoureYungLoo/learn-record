<template>
  <h1>首页 Home.vue </h1>
  <RouterLink to="/user/543"> Home.vue 用户首页</RouterLink>
  <RouterLink to="/user/543/profile">Home.vue 用户信息</RouterLink>
  <RouterLink to="/user/543/posts"> Home.vue 用户博客</RouterLink>

  <RouterView/>
</template>

<script setup>

</script>

<style scoped>

</style>