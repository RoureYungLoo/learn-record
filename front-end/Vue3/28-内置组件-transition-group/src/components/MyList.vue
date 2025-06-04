<script setup>

import {ref} from "vue";

const items = ref(['apple', 'banana'])
const randomAdd = () => {
  let index = Math.floor(Math.random() * items.value.length)
  items.value.splice(index, 0, Math.floor(Math.random() * 10))
}
const randomRemove = () => {
  let index = Math.floor(Math.random() * items.value.length)
  items.value.splice(index, 1)
}

const randomShuffle = () => {
  for (let i = 0; i < items.value.length; i++) {
    let index = Math.floor(Math.random() * items.value.length)
    let tmp = items.value[i]
    items.value[i] = items.value[index]
    items.value[index] = tmp
  }
}
</script>

<template>
  <button @click="randomRemove">随机删除</button>
  <button @click="randomAdd">随机添加</button>
  <button @click="randomShuffle">随机打乱</button>
  <TransitionGroup name="list" tag="ul">
    <li v-for="item in items" :key="item">
      {{ item }}
    </li>

  </TransitionGroup>
</template>

<style scoped>
.list-move, /* 对移动中的元素应用的过渡 */
.list-enter-active,
.list-leave-active {
  transition: all 0.5s ease;
}

.list-enter-from,
.list-leave-to {
  opacity: 0;
  transform: translateX(30px);
}

/* 确保将离开的元素从布局流中删除
  以便能够正确地计算移动的动画。 */
.list-leave-active {
  position: absolute;
}
</style>