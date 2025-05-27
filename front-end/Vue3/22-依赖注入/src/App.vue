<script setup>

import {provide, readonly, ref} from "vue";
import User from "@/views/User.vue";
import {key1, key4, keyCount} from "@/utils/keys.js";

// 准备响应式ref数据
const stu = ref({
  name: "tom",
  age: 22
})

// 在供给方组件中提供响应式数据更新方法
const changeStu = () => {
  stu.value.name = "jerry" + Math.floor(Math.random() * 10)
  stu.value.age += 1
}
// provide('key',stu)
provide('key', {
  stu,
  changeStu
})

const sites = ['shanghai', 'zhengzhou', 'hangzhou', 'shenzhen', 'suzhou']
const locationn = ref("beijing")
const updateLocation = () => {
  locationn.value = sites[Math.floor(Math.random() * sites.length)]
}
provide("loc", {locationn, updateLocation})


const storm = ref("storm")
const changeStm = () => {
  storm.value = "STORM"
}
// 注入只读响应式数据
provide("stm", readonly({
  storm,
  changeStm
}))

provide(key1, {
  name: 'key1',
  age: 123
})

provide("name", "zhangsan")

/* 注入响应式,
尽可能将任何对响应式状态的变更都保持在【供给方】组件中 */
const count = ref(0)
provide(keyCount, count)

provide('readonly-count', readonly(count))

/* 使用symbol作为注入名 */
provide(key4, {
  name: 'lisi',
  age: 23,
  addr: "zhengzhou",
  hobby: ['swim', 'sing', 'running'],
  orders: [
    {
      id: Math.floor(Math.random() * 1000000),
      price: Math.floor(Math.random() * 4000),
    },
    {
      id: Math.floor(Math.random() * 1000000),
      price: Math.floor(Math.random() * 1000),
    }
  ]
})
</script>

<template>
  <h2 @click="changeStu">App</h2>
  <div>
    {{ count }}
    <button @click="count++">+1</button>
  </div>
  <User/>
</template>

<style scoped>

</style>
