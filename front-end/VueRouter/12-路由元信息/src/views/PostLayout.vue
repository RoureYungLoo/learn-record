<script setup>

import {useRoute, useRouter} from "vue-router";

const router = useRouter();
const randomId = Math.floor(Math.random() * 1000)
const onBrowser = () => {
  router.push("/posts/" + randomId)
}
const onNew = () => {
  router.push("/posts/new")
}
</script>

<template>
  <p>PostLayout.vue</p>
  <!--  <button @click="onBrowser">浏览</button>-->
  <!--  <button v-on:click="onNew">新建</button>-->

  <a-button type="default" @click="onNew">新建</a-button>
  <a-button type="primary" @click="onBrowser">浏览</a-button>
  <RouterView/>
</template>

<style scoped>

</style>