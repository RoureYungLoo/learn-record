<script setup>
import {useRoute, useRouter} from "vue-router";

const boxStyle = {
  width: '100%',
  height: '120px',
  borderRadius: '6px',

};

const router = useRouter()
const onGoPostId = () => {
  router.push("/post/" + Math.floor(Math.random() * 100))
}
const onGoPostId2 = () => {
  router.push("/post2/" + Math.floor(Math.random() * 100))
}
</script>

<template>
  <a-flex :style="boxStyle" justify="space-evenly" align="center">
    <a-button type="primary" @click="onGoPostId">前往"/post/id"页面</a-button>
    <a-button type="primary" @click="onGoPostId2">前往"/post2/id"页面</a-button>
    <a-button type="primary" @click="$router.push('/')">回首页</a-button>
  </a-flex>
  <RouterView/>
</template>

<style scoped>

</style>
