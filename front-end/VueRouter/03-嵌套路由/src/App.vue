<script setup>
import {RouterView, RouterLink} from 'vue-router'

</script>

<template>
  <div>
    <h1>App.vue</h1>
    <RouterLink to="/admin">admin</RouterLink>
    <br>
    <RouterLink to="/admin/users">userList</RouterLink>
    <br>
    <RouterLink to="/admin/users/123">userDetail</RouterLink>
    <br>
    <RouterView/>
  </div>
</template>

<style scoped>
div {
  background-color: lightblue;
}
</style>
