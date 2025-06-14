<script setup>
import { RouterLink, RouterView ,useRouter} from 'vue-router'

const router=useRouter()
const jump = () => {
  router.push('/settings')
}
</script>

<template>
  <button @click="jump" >跳转</button>
<div class="container">

  <!-- 命名视图 -->
  <RouterView name="LeftSidebar"/>
  <RouterView/>
  <!--  <RouterView name="default"/>-->
  <RouterView name="RightSidebar"/>
</div>
</template>

<style scoped>
.container{
  display: flex;
}
</style>
