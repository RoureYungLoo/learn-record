<script setup>


import {ref, toValue} from "vue";
import {useOtherStore, useUserListStore} from "@/store/store.js";

const userListStore = useUserListStore();

const formData = ref({
  userId: 1001,
})

const userInfo = ref(null)

function search(formData) {
  let user = userListStore.getUserById(formData.userId)
  userInfo.value = user
  console.log(user)
}

const activeUserInfo = ref(null)

function searchActive(formData) {
  let activeUser = userListStore.getActiveUserById(formData.userId);
  activeUserInfo.value = activeUser
}

/* 在 setup 语法糖中访问 store的getter, 就像访问store的属性那样 */
const otherStore = useOtherStore();
const osi = ref(null)
const findOtherStoreInfo = () => {
  osi.value = otherStore.getInfo
}
</script>

<template>
  <el-form :model="formData">
    <el-form-item label="用户ID">
      <el-input :type="'number'" v-model.number="formData.userId"/>
      <el-button type="primary" @click="search(formData)" placeholder="输入用户ID">
        查询
      </el-button>
      <el-button type="primary" @click="searchActive(formData)" placeholder="输入用户ID">
        查询活跃用户
      </el-button>
    </el-form-item>
  </el-form>

  <p v-if="userInfo">
    {{ userInfo }}
  </p>

  <p v-if="activeUserInfo">
    {{ activeUserInfo}}
  </p>

  <el-button v-on:click="findOtherStoreInfo">查看otherStoreInfo</el-button>
  <p v-if="osi">{{ osi}}</p>
</template>

<style scoped>

</style>