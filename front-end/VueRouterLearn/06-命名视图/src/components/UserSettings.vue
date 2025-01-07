<template>

  <div>
    <h2>User Settings</h2>
    <NavBar/>
<!--    <RouterView/>-->
    <RouterView name="default"/>
    <RouterView name="helper"/>
  </div>
</template>

<script setup>

import NavBar from "@/components/NavBar.vue";
</script>

<style scoped>

</style>