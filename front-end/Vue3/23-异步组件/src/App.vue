<script setup>
import {defineAsyncComponent} from "vue";

// 获取异步组件
// const AsyncComp = defineAsyncComponent(()=>{
//   return new Promise((resolve ,reject)=>{
//     resolve()
//   })
// })

const AsyncComp2 = defineAsyncComponent(()=>
  import('./components/Home.vue')
)
</script>

<template>
  <h1>App</h1>
  <AsyncComp2></AsyncComp2>
  <home></home>
  <User/>
</template>

<style scoped>

</style>
