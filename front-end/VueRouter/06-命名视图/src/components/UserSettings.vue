<template>

  <div class="settings">
    <h2>User Settings</h2>
    <NavBar/>
    <RouterView/> <!-- 命名视图默认名称是 default -->
    <!--        <RouterView name="default"/>-->
    <RouterView name="helper"/>
  </div>
</template>

<script setup>

import NavBar from "@/components/NavBar.vue";
</script>

<style scoped>
.settings {
  background-color: lightyellow;
}
</style>