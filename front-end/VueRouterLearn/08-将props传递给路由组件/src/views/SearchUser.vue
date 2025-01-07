<template>
  <h1>SearchUser.vue</h1>
  <h3>{{ $route.params }}</h3>
  <hr/>
  {{id}}
  queryStr {{queryStr}} <br>
  query {{query}}
</template>

<script setup>
// 通过声明 prop 删除对 $route 的直接依赖

defineProps({
  id:String,
  queryStr:String,
  query:String,
})
</script>

<style scoped>

</style>