<script setup>
import {RouterView, RouterLink, useRoute, useRouter} from 'vue-router'
import {reactive, readonly} from "vue";

// 目标路由信息对象
const obj = reactive({
  name: 'profile', //哪个命名路由
  params: { // 参数对象
    username: 'erina'
  }
})

const router=useRouter()

const goto = ()=>{
  router.push(obj)
}

</script>

<template>
  <h1>
<!--    <RouterLink :to="{ name: 'profile', params: { username: 'erina' } }"> User Profile</RouterLink>-->
    <RouterLink :to="obj"> RouterLink跳转</RouterLink>
<!--    <button @click="goto">Button 点击跳转</button>-->

  </h1>

  <RouterView/>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
