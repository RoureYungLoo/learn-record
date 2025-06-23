<script setup>

import {useArticleStore} from "@/stores/article.js";
import {ref} from "vue";

const articles = ref(null)
const articleStore = useArticleStore();
const loadData = async () => {
  await articleStore.fetchArticles()
  articles.value = articleStore.articles
}

const formData = ref({
  id: null
})
const findById = () => {
  articleStore.removeById(formData.value.id)
  articles.value = articleStore.articles
  formData.value.id++
}

</script>

<template>
  <h2>Article</h2>
  <el-button type="primary" @click="loadData">加载</el-button>
  <el-input v-model.number="formData.id" type="number" label="文章ID" placeholder="输入文章ID"></el-input>
  <el-button type="primary" @click="findById">查询</el-button>
  <p v-if="articles">{{ articles }}</p>
</template>

<style scoped>

</style>