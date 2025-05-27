<script setup>
import {defineAsyncComponent, onMounted} from "vue";
import Home from "@/components/Home.vue";
import User from "@/components/User.vue";
import Loading from "@/components/Loading.vue";
import Error from "@/components/Error.vue";

/* 异步组件 Promise */
const AsyncComp = defineAsyncComponent(() => {
  return new Promise((resolve, reject) => {
    resolve(User)
  })
})

/* 异步组件 动态导入 */
const AsyncComp2 = defineAsyncComponent(() =>
    import('./components/Home.vue')
)

const AsyncUser2 = defineAsyncComponent({
  loader: () => (new Promise((resolve, reject) => reject())),
  loadingComponent: Loading,
  delay: 500,
  errorComponent: Error,
  timeout: 2000
})

const AsyncUser3 = defineAsyncComponent({
  loader: () => (new Promise((resolve, reject) => setTimeout(() => {
    // resolve(User)
    reject(User)

  }, 3500))),
  loadingComponent: Loading,
  delay: 0,
  errorComponent: Error,
  timeout: 2000
})

onMounted(() => {
  console.log("App.vue mounted")
})
</script>

<template>
  <!--  <h1>App</h1>-->
  <!--  <AsyncComp></AsyncComp>-->
  <!--  <AsyncComp2></AsyncComp2>-->
  <!--  <AsyncHome></AsyncHome>-->
      <AsyncUser/>
  <!--    <AsyncUser2/>-->
<!--  <AsyncUser3/>-->
  <!--  <Home></Home>-->
  <!--  <User></User>-->
</template>

<style scoped>

</style>
