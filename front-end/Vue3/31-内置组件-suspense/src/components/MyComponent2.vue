<script setup>
const res = await fetch("http://127.0.0.1:8080/server/1000/1000")
const posts = await res.json()
const err = 1 / 0;
console.log(posts)
</script>

<template>
  <template v-for="post in posts" :key="post.id">
    <h5>id: {{ post.id }}</h5>
    <p>name: {{ post.name }}</p>
    <p>time: {{ post.postTime }}</p>
  </template>
</template>

<style scoped>

</style>