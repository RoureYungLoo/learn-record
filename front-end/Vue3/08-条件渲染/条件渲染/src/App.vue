<script setup>

import {ref} from "vue";

const awesome = ref(true)
const type = ref("A")
const ok = ref(true)

function changeawesome() {
  awesome.value = !awesome.value
  ok.value = !ok.value
}

const chageType = () => {
  var randomInt = Math.round(Math.random() * 10)
  if (randomInt > 0 && randomInt <= 2) {
    type.value = "A"
  } else if (randomInt <= 5) {
    type.value = "B"
  } else if (randomInt <= 7) {
    type.value = "C"
  } else {
    type.value = "D"
  }

}
</script>

<template>
  <button @click="awesome=!awesome">切换</button>
  <button @click="changeawesome">切换</button>

  <p v-if="awesome">vue is awesome</p>
  <p v-else>Oh no 😢</p>

  <h1 v-if="awesome">标题1</h1>
  <h2 v-else v-on:click="chageType">点击标题2</h2>

  <h2 v-if="type ==='A'">A</h2>
  <h2 v-else-if="type ==='B'">B</h2>
  <h2 v-else-if="type==='C'">C</h2>
  <h2 v-else>other</h2>

  <!-- 包装器元素 -->
  <template v-if="ok">
    <h1>title</h1>
    <p>p1</p>
    <p>p2</p>
  </template>
  <div v-show="ok">
    <h1>标题</h1>
    <p>段落1</p>
    <p>段落2</p>
  </div>
</template>

<style scoped>

</style>
