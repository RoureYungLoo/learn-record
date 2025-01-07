<script setup>
import ChildVue from '@/components/Child.vue'

/* 定义事件处理函数 */
const handler = (p1, p2) => {
  console.log("子组件事件触发，父组件收到：p1=", p1, " p2=", p2)
}

const validHandler = (obj) => {
  console.log("收到子组件事件：obj=", obj)
}
</script>

<template>
  <div class="parent">
    <h3>父组件</h3>
    <!--    <ChildVue @event-name="handler"/>-->
    <!--    <ChildVue v-on:event-name="handler"/>-->
    <ChildVue v-on:event-name="handler" @submit="console.log('子组件submit触发')" @in-focus="console.log('子组件inFocus触发')"
              @validator="validHandler"/>
  </div>
</template>

<style scoped>
.parent {
  background-color: #a8abb2;
  padding: 5px;
  margin: 5px;
  width: 300px;
  height: 300px;
}
</style>
