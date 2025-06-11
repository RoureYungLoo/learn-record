<script setup>

import {useRoute, useRouter} from "vue-router";

const route = useRoute();
const router = useRouter();
const showRouteInfo = () => {

}
const showRouterInfo = () => {

}

</script>

<template>
  <p>首页</p>
  <a-flex justify="space-evenly" align="center">
    <a-button type="primary" @click="showRouteInfo">查看当前路由</a-button>
    <a-button type="link" @click="showRouterInfo">查看当前router</a-button>
  </a-flex>
</template>

<style scoped>

</style>