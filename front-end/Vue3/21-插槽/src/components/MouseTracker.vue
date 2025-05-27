<script setup>

import {onMounted, ref} from "vue";

const Coordinate = ref({
  x: 0,
  y: 0
})

function update(e) {
  // console.log(e)
  Coordinate.value.x=e.pageX
  Coordinate.value.y=e.pageY
}

onMounted(() => {
  window.addEventListener('mousemove', update)
})

</script>

<template>
  <div>
    <slot :="Coordinate"></slot>
  </div>
</template>

<style scoped>

div {
  height: 500px;
  background-color: #efefef;
}
</style>