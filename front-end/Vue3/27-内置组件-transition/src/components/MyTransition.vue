<script setup>
const onEnter = (el) => {
  console.log("onEnter", el)
}
const onLeave = (el) => {
  console.log("onLeave", el)
}
</script>

<template>
<!-- 自定义Transition组件, 初次渲染时应用动画 -->
  <transition name="bounce" appear
              @enter="onEnter"
              @leave="onLeave"
  >
    <slot></slot>
  </transition>


</template>

<style>

.bounce-enter-active {
  animation: bounce-in 0.5s;
}

.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}
</style>