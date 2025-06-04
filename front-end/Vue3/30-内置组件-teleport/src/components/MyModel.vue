<script setup>

import {ref} from "vue";

const open = ref(false)
</script>

<template>
  <button @click="open=!open">打开/关闭</button>

  <div v-if="open" class="model">
    <p>手动实现模态框</p>
    <button v-on:click="open=false">关闭</button>
  </div>
</template>

<style scoped>

.model {
  position: fixed;
  /*position: absolute;*/
  z-index: 999;
  top: 50%;
  left: 50%;
  width: 400px;
  height: 300px;
  transform: translate(-50%, -50%);
  background-color: lightblue;
  border-radius: 15px;
  box-shadow: 0px 0px 5px 5px lightblue;
}
</style>