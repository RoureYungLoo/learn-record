<script setup>

import {ref} from "vue";
import {useRouter} from "vue-router";

const modules = import.meta.glob('@/views/*.vue')

const ipt = ref({})

const router = useRouter()
let removeRoute
const submit = () => {
  let path = '/' + ipt.value.path
  let name = ipt.value.path
  /* 动态导入的路径无法解析'@'符号,需要替换为'/src/' */
  let cmpPath = '/src/views/' + ipt.value.component
  console.log(cmpPath);
  let route = {
    path, name,
    component: modules[cmpPath]
  }
  removeRoute = router.addRoute(route);

  console.log(router.getRoutes());
}

const remove2 = () => {
  removeRoute()
  console.log(router.getRoutes());

}

const test = async () => {
  await router.push(ipt.value.path)
  console.log("跳转成功")
}

console.log(router.getRoutes())

const onDelete = () => {
  let path = '/' + ipt.value.path
  let name = ipt.value.path
  /* 动态导入的路径无法解析'@'符号,需要替换为'/src/' */
  let cmpPath = '/src/views/' + ipt.value.component
  console.log(cmpPath);
  let route = {
    path,
    name: 'about',
    component: modules[cmpPath]
  }
  router.addRoute(route)

  console.log(router.getRoutes());
}

const nameToRemove = ref('')
const deleteRouteByName = () => {
  router.removeRoute(nameToRemove.value)
  console.log(router.getRoutes())
}

const submit2 = () => {
  let path = ipt.value.path
  let cmpPath = '/src/views/' + ipt.value.component
  let route = {
    path, // 子路由不能以根路径开头
    component: modules[cmpPath]
  }
  console.log(route)
  /* 添加嵌套路由 */
  router.addRoute('about', route)

  console.log(router.getRoutes());
}

const getRouteByName = () => {
  console.log(router.hasRoute(nameToRemove.value))
}
const getAllRoutes = () => {
  console.log(router.getRoutes())
}
</script>

<template>
  <a-input v-model:value="ipt.path" placeholder="输入路由地址"/>
  <a-input v-model:value="ipt.component" placeholder="输入路由组件名称"/>
  <a-input v-model:value="nameToRemove" placeholder="输入待删除的命名路由名: "/>
  <a-space direction="horizontal">
    <a-button type="primary" @click="$router.push('/')">首页</a-button>
    <a-button type="primary" @click="submit">添加</a-button>
    <a-button type="primary" @click="submit2">添加嵌套路由</a-button>
    <a-button type="primary" @click="remove2">删除</a-button>
    <a-button type="primary" @click="test">跳转测试</a-button>

    <a-button type="primary" @click="onDelete">删除about路由</a-button>
    <a-button type="primary" @click="$router.push({name: 'about'})">跳转about</a-button>
    <br>    <a-button @click="deleteRouteByName">X</a-button>
    <!--    <a-anchor-link>-->
    <!--      <RouterLink to="/about/other">/about/other</RouterLink>-->
    <!--    </a-anchor-link>-->
    <a-button @click="$router.push('/about/other')">/about/other</a-button>
  </a-space>
    <a-button @click="getRouteByName">查询路由</a-button>
    <a-button @click="getAllRoutes">查询所有路由</a-button>
  <RouterView/>
</template>

<style scoped>

</style>
