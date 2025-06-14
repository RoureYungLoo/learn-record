<script setup>
import {useRouter} from "vue-router";

const router = useRouter();
const goHome = () => {
  router.push("/home")
}
</script>

<template>
  <button @click="$router.push('/users/123/posts')">go to /users/123/posts</button>
  <button @click="goHome"> go to /home</button>
  <button @click="$router.push('/users/123')">go to /users/123</button>
  <RouterView/>
</template>

<style scoped>

</style>
