<script setup>

import MyRouterLink from "@/components/MyRouterLink.vue";

const getId = () => {
  return Math.floor(Math.random() * 10000)
}
</script>

<template>
  <a-flex align="center" justify="space-evenly">
    <a-button @click="$router.push('/')">首页</a-button>
    <a-button @click="$router.push('/posts/'+getId())">博客</a-button>
  </a-flex>

  <MyRouterLink to="/posts/666">666</MyRouterLink>
  <RouterView/>
</template>

<style scoped>

</style>
