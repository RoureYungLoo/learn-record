<script setup>

import {ref} from "vue";

const msg = ref("data from son")
const counter = ref(1)
</script>

<template>
  <!--  <div>-->
  <!--  作用域插槽, 往插槽上传属性, 类似组件 Props  -->
  <!--    <slot :text="msg" :counter="counter"></slot>-->
  <!--  </div>-->

  <div class="header">
<!--  name属性不会作为作用域插槽传递给 slot props  -->
    <slot name="header" message="header msg" :ctr="counter"></slot>
  </div>
  <div class="main">
    <slot name="main" :message="msg" :count="counter"></slot>
  </div>
  <div class="footer">
    <slot name="footer" :message="counter" nums="666"></slot>
  </div>

</template>

<style scoped>

div.header {
  background-color: #efc;
  height: 150px;
}

div.main {
  background-color: #ccfff7;
  height: 150px;
}

div.footer {
  background-color: #f8ccff;
  height: 150px;
}
</style>