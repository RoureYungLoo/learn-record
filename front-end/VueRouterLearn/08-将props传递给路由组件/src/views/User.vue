<template>
  <h1>User.vue</h1>
  <h3>{{ $route.params }}</h3>
  <hr/>
  {{id}}
</template>

<script setup>
// 通过声明 prop 删除对 $route 的直接依赖

defineProps({
  id:String
})
</script>

<style scoped>

</style>