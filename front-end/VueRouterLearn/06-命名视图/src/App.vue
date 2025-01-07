<script setup>
import { RouterLink, RouterView ,useRouter} from 'vue-router'

const router=useRouter()
const jump = () => {
  router.push('/settings')
}
</script>

<template>
  <button @click="jump" >跳转</button>
  <RouterView name="LeftSidebar"/>
  <RouterView/>
  <!--  <RouterView name="default"/>-->
  <RouterView name="RightSidebar"/>
</template>

<style scoped>

</style>
