<script setup>

import {useRoute} from "vue-router";
import {ref, watch} from "vue";

const route = useRoute()

const loading = ref(false)
const post = ref({
  title: "",
  body: "",
  id: ""
})
const error = ref(null)

watch(() => route.params.id, () => {

  error.value = null
  post.value = {
    title: "",
    body: "",
    id: ""
  }
  loading.value = true

  /* 模拟获取数据 */
  setTimeout(() => {
    post.value = {
      title: "title",
      body: "body",
      id: route.params.id
    }
    loading.value = false
    if (route.params.id >= 50) {
      error.value = "出错了"
    }
  }, 2000)

}, {immediate: true})


</script>

<template>
  <div class="post">
    <div v-if="loading" class="loading">加载中...</div>
    <div v-if="$route.params.id>=50" class="error">{{ error }}</div>
    <div v-else class="content">
      <h3>{{ post.title }}</h3>
      <p>{{ post.body }}</p>
      <p>{{ post.id }}</p>
    </div>
  </div>
</template>

<style scoped>

</style>