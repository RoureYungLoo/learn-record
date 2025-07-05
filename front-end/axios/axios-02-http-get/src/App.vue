<script setup>


import {ref} from "vue";
import axios from "axios";

const formData = ref({
  id: 12312124,
  title: "title",
  category: ['cat1', 'cat2'],
  time: "2022-12-12 12:23:23",
  state: 1,
  coverImg: "cat1.jpg",
  createTime: "2022-12-12 12:23:23",
  updateTime: "2022-12-12 12:23:23"
})

const submitGetRequestBody = () => {
  axios({
    url: "http://localhost:5174/api/axios/get/reqbody",
    method: "GET",
    data: formData.value
  })
}
</script>

<template>

  <button @click="submitGetRequestBody">提交get request body</button>
</template>

<style scoped>
</style>
