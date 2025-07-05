<script setup>
import User from "@/views/User.vue";
import Counter from "@/views/Counter.vue";
import {useUserStore} from "@/stores/user.js";
import Article from "@/views/Article.vue";
import Search from "@/views/Search.vue";

const userStore = useUserStore();
const goPost = () => {
  console.log(userStore);
  userStore.router.push('/posts')
}
const goArticle = () => {
  userStore.router.push('/articles')
}
</script>

<template>

  <User/>
  <hr/>
  <hr/>
  <Counter/>
  <el-button @click="goPost">post</el-button>
  <el-button @click="goArticle">article</el-button>

  <RouterView/>
  <Article/>
  <br>
  <br>
  <Search/>
  <br>
  <br>
</template>

<style scoped>

</style>
