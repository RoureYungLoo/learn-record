<template>
  <div class="home">
    <h1>Home.vue</h1>
    <!-- 命名视图 router view name属性 -->
    <RouterView name="LeftSidebar"/>
    <RouterView/>
    <!--  <RouterView name="default"/>-->
    <RouterView name="RightSidebar"/>
  </div>
</template>

<script setup>
</script>

<style scoped>
.home{
  background-color: lightcyan;
}
</style>