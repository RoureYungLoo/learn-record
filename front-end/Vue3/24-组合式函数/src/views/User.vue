<template>
  <div>
    <h3> UserVue {{ x }},{{ y }}</h3>
  </div>
</template>

<script setup>
import {useMouse2} from "@/utils/mouse.js";

/* 使用自定义组合式函数 */
// const {x, y} = useMouse()
const {x, y} = useMouse2()
</script>

<style scoped>
div{
  background-color: lightpink;
}
</style>