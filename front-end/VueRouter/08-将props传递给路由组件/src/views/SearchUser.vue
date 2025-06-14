<template>
  <h1>SearchUser.vue</h1>
  <h3>{{ $route.params }}</h3>
  <h3>{{ $route.fullPath }}</h3>
  <hr/>
  {{ id }}
  queryStr: {{ queryStr }} <br>
  query: {{ query }}<br>
  queryStringObj: {{queryObj}}<br>
  <p>city: {{city }}</p>
  <p>age: {{age}}</p>
  <p>ts: {{ts}}</p>
</template>

<script setup>
// 通过声明 prop 删除对 $route 的直接依赖

import {useRoute, useRouter} from "vue-router";

const route = useRoute();
console.log(route)
defineProps({
  id: String,
  queryStr: String,
  query: String,
  queryObj:Object, /* query 参数是字符串, 默认全部转成字符串 */
  city:String,
  age: Number,
  ts: Number
})
</script>

<style scoped>

</style>