<template>
  <!--  <button class="btn">点击我</button>-->
  <!--  <button class="btn" @click="nativeClickHandler">点击我</button>-->

  <!--    <BaseButton/>-->

  <!-- 将所有透传的属性应用在内部button上,而不是根元素div上 -->
  <div class="div-wrapper">
    <button class="btn" v-bind="$attrs" @click="nativeClickHandler">点击我</button>
  </div>


  透传的属性{{ attrs }}<br>
  透传的监听器{{ attrs.onClick }}<br>
  调用{{ attrs.onClick() }}

</template>


<script setup>
import BaseButton from './BaseButton.vue'

// 访问透传属性
import {useAttrs} from "vue";

defineOptions({
  inheritAttrs: false // 禁用继承
})

const attrs = useAttrs()

console.log("透传的属性", attrs)

const nativeClickHandler = () => {
  console.log("原生 button click事件触发")
}


</script>

<style scoped>

</style>