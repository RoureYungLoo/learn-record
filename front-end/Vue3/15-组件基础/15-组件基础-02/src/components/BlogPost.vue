<template>
  <h3>{{ title }}</h3>
  <button @click="$emit('enlarge-text',1,'from large')">字体放大</button>
  <button @click="$emit('shrink-text',2,'from shrink')">字体缩小</button>
  <button @click="shrinkHandler">字体缩小</button>
</template>

<script setup>
// 组件要接收的属性 attributes
const dps = defineProps(['title'])

// 子组件要触发的事件
const emit = defineEmits(['enlarge-text', 'shrink-text'])

// console.log(dps)
// console.log(emit)

const shrinkHandler = () => {
  emit('shrink-text', 111, "from BlogPost component")
}
</script>

<style>
</style>