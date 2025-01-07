<template>
  <h1>SideBar.vue</h1>

  Sidebar: {{id}}
</template>

<script setup>
// 通过声明 prop 删除对 $route 的直接依赖

defineProps({
  id:String
})
</script>

<style scoped>

</style>