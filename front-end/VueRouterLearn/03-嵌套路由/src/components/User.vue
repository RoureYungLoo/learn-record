<template>
  <div>
    <h2>User.vue:  User {{ getter() }}</h2>
    <h2><RouterLink to="/user/543">User.vue 用户首页 </RouterLink></h2>
    <h2><RouterLink to="/user/543/profile">User.vue 用户信息</RouterLink></h2>
    <h2><RouterLink to="/user/543/posts"> User.vue 用户博客</RouterLink></h2>
    <RouterView/>
  </div>
</template>

<script setup>
import {useRoute, useRouter,RouterView,RouterLink} from 'vue-router'

const route = useRoute()

const getter = () => {
  return route.params
}


</script>

<style scoped>

</style>