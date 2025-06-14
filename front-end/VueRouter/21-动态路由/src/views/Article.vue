<script setup>

import {useRoute, useRouter} from "vue-router";

const route = useRoute();
console.log(route)

const router = useRouter();
/*动态添加路由*/
router.addRoute({
  path: '/about',
  component: () => import('@/views/About.vue')
})

async function switchRoute() {
  /* 切换 */
  console.log(router)
// router.replace(router.currentRoute.value.fullPath)
// router.replace('/about')
  /*等待新的路由显示*/
  await router.replace('/about')
}

switchRoute();
</script>

<template>
  <h1>Article</h1>
  <p>文章名称: {{ route.params.articleName }}</p>
</template>

<style scoped>

</style>