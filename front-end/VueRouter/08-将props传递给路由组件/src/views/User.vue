<template>
  <h1>User.vue</h1>
  <!-- 这种方式获取路由参数, 耦合了路由配置 -->
  <!--  <h3>{{ $route.params }}</h3>-->
  <hr/>
  以Props方式将路由参数传递给组件: <br>{{ id }}
  <br>
  路由中配置的静态props:  {{myProp}}

</template>

<script setup>
// 通过在路由配置中声明 props配置 删除对 $route 的直接依赖

defineProps({
  id: String,
  myProp: Object, // 从路由中传递过来的props

})
</script>

<style scoped>

</style>