<script setup>

const cancelHandler = () => {
  console.log("cancel 组件 原生click事件 触发")
}
</script>

<template>
<button class="cannel" @click="cancelHandler">Cancel</button>
</template>

<style scoped>

</style>