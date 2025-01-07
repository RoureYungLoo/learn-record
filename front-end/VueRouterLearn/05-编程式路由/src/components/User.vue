<template>
  <h1>User {{route.params.username}}</h1>
  <h2>{{route.params}}</h2>
  <button @click="back">返回</button>
</template>

<script setup>
import {useRoute, useRouter} from 'vue-router'
import {watch} from "vue";

const route=useRoute()
const router=useRouter()
console.log(route.params)

watch(()=>route.params,(newValue,oldValue)=>{
  console.log(oldValue)
  console.log(newValue)
})

const back = () => {
  router.go(-1)
}
</script>

<style scoped>

</style>