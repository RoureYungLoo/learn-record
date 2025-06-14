<template>
  <div>
    <h2>User.vue:  User {{ getter() }}</h2>
    <h2><RouterLink to="/user/543">/user/543 </RouterLink></h2>
    <h2><RouterLink to="/user/543/profile">/user/543/profile</RouterLink></h2>
    <h2><RouterLink to="/user/543/posts"> /user/543/posts</RouterLink></h2>
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
div{
  background-color: lightpink;
}
</style>