<script setup>
import {useRouter} from "vue-router";

const router = useRouter();
const onButtonClick = () => {
  router.push("/search/aaa/bbb")
}
</script>
<template>
  <div class="search">
    <h1>SearchView.vue</h1>
    <h2>{{ $route.params }}</h2>
    <h2>{{ $route.fullPath }}</h2>
    <button v-on:click="onButtonClick">go to /search/xxx/xxx</button>
  </div>
</template>

<style scoped>
.search{
  background-color: #ffc5b0;
}
</style>