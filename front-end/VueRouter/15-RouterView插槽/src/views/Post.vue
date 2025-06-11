<script setup>

import {ref} from "vue";

const LoginData = ref({
  uname: ""
})

function postFunc() {
  console.log("postFunc")
}
</script>

<template>
  <div>

    <p>Post</p>
    <a-space direction="horizontal">
      <label for="uname">用户名：</label>
      <a-input id="uname" v-model:value="LoginData.uname" placeholder="请输入用户名"/>
    </a-space>
    <a-card>
      <h3>用户输入: {{ LoginData.uname }}</h3>
    </a-card>
  </div>
</template>

<style scoped>

</style>