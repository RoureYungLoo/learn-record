<script setup>

import Home from "@/views/Home.vue";
import Essay from "@/views/Essay.vue";
import MyComponent from "@/components/MyComponent.vue";
import {ref} from "vue";


/* 在组件上使用自定义指令 */
const vDemo = {
  mounted: function (el, binding, vnode) {
    console.log(el)
    console.log(binding.value)
    console.log(vnode)
  }
}

const person = ref({
  username: "lisi",
  age: 23
})
</script>


<template>
  <!--  <Home/>-->
  <!--  <Essay></Essay>-->
  <!--  <MyComponent/>-->

  <MyComponent v-demo="person"/>
</template>


<style scoped>

</style>
