<script setup>

import {ref} from "vue";

const open = ref(false)

setTimeout(() => {
  open.value = true
}, 1000)
</script>

<template>
  <button @click="open=!open">打开/关闭</button>

  <Teleport to="body">
    <div v-if="open" class="model">
      <p>手动实现模态框</p>
      <button v-on:click="open=false">关闭</button>
    </div>
  </Teleport>
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