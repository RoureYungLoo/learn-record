<script setup>
import ChildVue from '@/components/Child.vue'
import {ref} from "vue";

/* 定义事件处理函数 */
const handler = (p1, p2) => {
  console.log("子组件事件触发，父组件收到：p1=", p1, " p2=", p2)
}

const validHandler = (obj) => {
  console.log("收到子组件事件：obj=", obj)
}


const styleObj = ref({
  fontSize: 16 + 'px'
})
const increaseHandler = (delta) => {
  console.log("delta", delta)
  let fs = Number(styleObj.value.fontSize.slice(0, -2))
  fs += delta
  styleObj.value.fontSize = fs + 'px'
}

const handleSubmit = (param) => {
  console.log('子组件submit触发', param)
}


</script>

<template>
  <div class="parent">
    <h3>父组件</h3>
    <!-- Vue中没有事件冒泡机制,只能监听直接子组件触发的事件
       平级组件或跨越多层嵌套的组件通信可以使用 [状态管理] 或 [全局事件总线]
       -->
    <!--        <ChildVue @event-name="handler"/>-->
    <!--        <ChildVue v-on:event-name="handler"/>-->
    <!--    <ChildVue v-on:event-name.once="handler" @increase-by="increaseHandler"/>-->
    <ChildVue
        v-on:event-name="handler"
        @increase-by="increaseHandler"
        @submit="handleSubmit"
        @in-focus="console.log('子组件inFocus触发')"
        @validator="validHandler"/>

    <div>
      <p v-bind:style="styleObj">组件事件组件事件组件事件组件事件组件事件vvv组件事件组件事件组件事件组件事件组件事件</p>
    </div>
  </div>


</template>

<style scoped>
.parent {
  background-color: #a8abb2;
  padding: 5px;
  margin: 5px;
  width: 500px;
  height: 500px;
}
</style>
