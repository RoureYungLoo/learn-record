<template>
  <button class="basebtn" @click="basefunc">BaseButton</button>

</template>

<script setup>
const basefunc = () => {
  console.log(" BaseButton组件点击事件 ")
}
</script>

<style scoped>

</style>