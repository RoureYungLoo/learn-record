<template>
<!--<button class="btn" @click="func">点击我</button>-->

<!--  <BaseButton/>-->

<div class="div-wrapper">
  <button class="btn" v-bind="$attrs" @click="func">点击我</button>

</div>


</template>


<script setup>
import BaseButton from './BaseButton.vue'

// 访问透传属性
import {useAttrs} from "vue";

defineOptions({
  inheritAttrs:false
})

const attrs = useAttrs()

console.log(attrs)

const func = () => {
  console.log(" 子组件点击事件 ")
}


</script>

<style scoped>

</style>