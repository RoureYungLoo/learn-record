<template>
  <!--  <button class="basebtn" @click="basefunc">BaseButton</button>-->

  <Cancel></Cancel>
</template>

<script setup>
import Cancel from "@/components/Cancel.vue";

const basefunc = () => {
  console.log(" BaseButton组件原生click事件触发 ")
}
</script>

<style scoped>

</style>