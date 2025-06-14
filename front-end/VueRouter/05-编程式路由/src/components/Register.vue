<template>
  <h1>Register</h1>
  <h2>{{ route.fullPath }}</h2>
  <button @click="handler">后退</button>
  <button @click="goToUser">前往用户模块</button>
  <a href="#team">123213</a>

  <div v-for="i in 50">
    <p>{{i}}</p>
  </div>
  <a name="team">team</a>


</template>

<script setup>

import {createRouter, useRoute, useRouter} from "vue-router";

const route = useRoute()
console.log("register: ", route)
const router = useRouter()

const handler = () => {
  router.go(-1)
}

const goToUser = () => {
  router.push("/users/lisi")
}
</script>

<style scoped>

</style>