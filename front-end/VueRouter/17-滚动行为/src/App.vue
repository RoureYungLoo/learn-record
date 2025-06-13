<script setup>

import {useRoute, useRouter} from "vue-router";

const route = useRoute();
const router = useRouter();
const goHome = () => {
  router.push("/home#testHash")
}
const goAbout = () => {
  router.push("/about#testHash")
}
</script>

<template>
  <h3>App.vue</h3>
  <div class="switch">
    <a-button type="primary" @click="goHome">Home</a-button>
    <a-button type="default" @click="goAbout">About</a-button>
  </div>
  <RouterView/>
</template>

<style scoped>


.switch {
  position: fixed;
  left: 50px;
  bottom: 50px;
}
</style>
