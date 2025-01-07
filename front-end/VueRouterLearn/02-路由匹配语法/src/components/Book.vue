<template>
<h3>Book</h3>
  <p @click="handler">{{route.params}}</p>
</template>

<script setup>
import{useRoute,useRouter} from 'vue-router'
import {watch} from "vue";

const route=useRoute()
const router=useRouter()

const handler=()=>{
  console.log(router.resolve(
      {
        name:'ctrs', // 命名路由的名字
        params:{  // 路由参数
          chapters:[
              'a','b'
          ]
        }
      }
  ).href)
}

watch(()=>route.params,(newValue,oldValue)=>{
  console.log("oldValue: ")
  console.log(oldValue)
  console.log("newValue: ")
  console.log(newValue)


})


</script>

<style scoped>

</style>