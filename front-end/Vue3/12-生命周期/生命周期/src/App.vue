<script setup>
import ArticleVue from "@/components/ArticleVue.vue";
import {ref} from "vue";

const show = ref(true)
</script>

<template>
  <ArticleVue v-if="show"></ArticleVue>
  <button @click="show=!show">switch</button>
</template>

<style scoped>
</style>
