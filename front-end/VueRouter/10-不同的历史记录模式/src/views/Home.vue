<script setup>
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";
import {ElNotification} from "element-plus";

const router = useRouter();
const goAhead = () => {
  router.go(1)
  ElMessage({
    message:"前进成功",
    type:'success',
    showClose:false,
    duration:800,
  })
}

const goBack = () => {
  router.go(-1)
  ElNotification(
      {
        title:"💘",
        message:'后退成功',
        type:'success',
        duration:800,
        showClose:false

      }
  )

}
</script>

<template>
  <h3>Home.vue</h3>
  <router-link to="/page1">Page1</router-link>
  <br>
  <router-link to="/page2">Page2</router-link>
  <br>
  <router-link to="/page3">Page3</router-link>
  <br>
  <router-link to="/page4">Page4</router-link>
  <br>
  <p>
    <!--    <button @click="$router.go(1)">前进</button>-->
    <!--    <button @click="$router.go(-1)">后退</button>-->
<!--    <button @click="goBack">后退</button>-->
<!--    <button @click="goAhead">前进</button>-->
    <el-button type="primary" @click="goBack">后退</el-button>
    <el-button type="primary" @click="goAhead">前进</el-button>
  </p>

  <RouterView/>
</template>

<style scoped>

</style>