<script setup>

import {provide, readonly, ref} from "vue";
import User from "@/views/User.vue";
import {key1} from "@/utils/keys.js";

// const stu = ref({
//   name:"tom",
//   age:22
// })
//
// const changeStu = ()=>{
//   stu.value.name="jerry"
//   stu.value.age=33
// }
// // provide('key',stu)
// provide('key',{
//   stu,
//   changeStu
// })
//
// const storm = ref("storm")
// const changeStm = ()=>{
//   storm.value="STORM"
// }
// provide("stm",readonly({
//   storm,
//   changeStm
// }))

provide(key1, {
  name: 'key1',
  age: 123
})
</script>

<template>
  <h2 @click="changeStu">App</h2>
  <User/>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
