<script setup>
import {RouterView, RouterLink, useRoute, useRouter} from 'vue-router'
import {reactive, readonly} from "vue";

// 目标路由信息对象
const obj = reactive({
  name: 'profile', //哪个命名路由
  params: { // 参数对象
    username: 'lisi',
    addr: '河南省郑州市',
    time: "1999-02-15"
  }
})

const router = useRouter()

const handleClick = () => {
  // router.push(obj)
  router.replace(obj)
}

</script>

<template>
  <h5>
    <!--  命名路由  -->
    <!--        <RouterLink :to="{ name: 'profile', params: { username: 'erina' } }"> 命名路由</RouterLink>-->
    <!--    <RouterLink :to="obj"> 命名路由绑定to属性</RouterLink>-->
    <button @click="handleClick">编程式导航</button>

  </h5>

  <RouterView/>
</template>

<style scoped>

</style>
