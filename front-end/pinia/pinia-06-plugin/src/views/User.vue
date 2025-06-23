<script setup>

import {useUserStore} from "@/stores/user.js";
import {ref} from "vue";

const userStore = useUserStore();
const secret = ref(null)
const password = ref(null)
const showSecret = () => {
  console.log(userStore)
  secret.value = userStore.secret
}
const showPassword = () => {
  console.log(userStore)
  password.value = userStore.password
}

const changePassword = function () {
  userStore.password = genNewPwd()
};

function genNewPwd() {
  return Math.floor(Math.random() * 10000000000).toString(16)
}

const changeAddress = () => {
  userStore.address = 'zhengzhou'
}

const changeSharedData = () => {
  userStore.sharedData = `modified by UserVue at ${new Date().toLocaleString()}`
}
</script>

<template>
  <h3>User.vue</h3>
  <el-button @click="showSecret">查看userStore.secret</el-button>
  <p>{{ secret }}</p>

  <el-button @click="showPassword">查看userStore.password</el-button>
  <el-button type="warning" @click="changePassword">changePassword</el-button>
  <p>{{ password }}</p>

  <p>userStore.password: {{ userStore.password }}</p>
  <p>userStore.hello: {{ userStore.hello }}</p>
  <p>userStore.address: {{ userStore.address }}</p>
  <el-button @click="changeAddress">changeAddress</el-button>
  <p>userStore.sharedData: {{userStore.sharedData}}</p>
  <el-button @click="changeSharedData">changeSharedData</el-button>


</template>

<style scoped>

</style>