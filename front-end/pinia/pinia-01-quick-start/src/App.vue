<script setup>
import { RouterLink, RouterView } from 'vue-router'
import {useCountStore} from "@/stores/counter.js";
import AboutView from "@/views/AboutView.vue";
import Third from "@/views/Third.vue";
import Todos from "@/views/Todos.vue";

const countStore = useCountStore();

</script>

<template>
  <h1>App count: {{ countStore.count}}</h1>
  <RouterView />
  <AboutView/>
  <Third/>
  <Todos/>
</template>

<style scoped>

</style>
