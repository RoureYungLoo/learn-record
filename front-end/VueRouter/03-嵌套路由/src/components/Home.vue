<template>
  <div>
  <h1>Home.vue </h1>
  <RouterLink to="/user/543"> /user/543 用户首页</RouterLink>
    <br>
  <RouterLink to="/user/543/profile">/user/543/profile 用户信息</RouterLink>
    <br>
  <RouterLink to="/user/543/posts"> /user/543/posts 用户博客</RouterLink>
    <br>
  <RouterView/>
  </div>
</template>

<script setup>

</script>

<style scoped>
div{
  background-color: lightcyan;
}
</style>