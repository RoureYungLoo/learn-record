<script setup>
import {isNavigationFailure, NavigationFailureType, RouterLink, RouterView, useRouter} from 'vue-router'
import {inject, onMounted, ref} from "vue";

const msg = ref('')
const router = useRouter();

const goHome = async () => {
  /*同步等待路由结果*/
  // await router.push('/home')
  // msg.value = "路由至 Home 页面"


  /*导航故障的属性*/
  await router.push('/home').then(failure => {
    if (isNavigationFailure(failure, NavigationFailureType.duplicated)) {
      console.log("failure", failure.to, failure.from)
    }
  })

  /*检测重定向*/
  if (router.currentRoute.value.redirectedFrom){
    console.log()
  }
  console.log("router.currentRoute.value.redirectedFrom: ",router.currentRoute.value.redirectedFrom)

  msg.value = "路由至 Home 页面"
}

const goAbout = async () => {
  const failure = await router.push("/about")
  if (failure) {
    console.log("导航被阻止")
    console.log("failure:  111:  ", failure)
  } else {
    console.log("导航成功")
    msg.value = "成功路由至About页面"
  }

  /*检测导航故障*/
  const navigationFailure = isNavigationFailure(failure, NavigationFailureType.aborted);
  console.log("navigationFailure", navigationFailure)
  // 被终止
  if (navigationFailure) {
    console.log("是否丢弃修改,直接跳转?")
  }
  // 重复了
  if (isNavigationFailure(failure, NavigationFailureType.duplicated)) {
    console.log("已经在/about页面了")
  }

  // 被取消了
  if (isNavigationFailure(failure, NavigationFailureType.cancelled)) {
    console.log("路由被取消了")
  }


}
let loading = inject('loading');
</script>

<template>
  <button @click="goHome">Home</button>
  <button @click="goAbout">About</button>
  <a-spin :spinning="loading">
    <RouterView/>
    {{ msg }}
  </a-spin>
</template>

<style scoped>

</style>
