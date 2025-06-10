<script setup>

import {ref} from "vue";

const username = ref('')
const password = ref('')
const login = () => {
  console.log(username.value)
  console.log(password.value)
}
</script>

<template>

  <label for="name">name: </label>
  <input type="text" name="name" id="name" v-model="username" >
  <label for="pwd">pwd: </label>
  <input type="text" name="pwd" id="pwd" v-model="password" >
  <button @click="login">login</button>
  {{username}}:{{password}}
</template>

<style scoped>

</style>