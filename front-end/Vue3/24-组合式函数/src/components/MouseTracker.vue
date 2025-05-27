<template>
  <div>
    <h3>
      Mouse is at: ({{ x }}, {{ y }})
    </h3>
  </div>
</template>

<script setup>
/*
import {onMounted, onUnmounted, ref} from "vue";

const x = ref(0)
const y = ref(0)

function update(event) {
  x.value = event.pageX
  y.value = event.pageY
}

onMounted(() => window.addEventListener('mousemove', update))
onUnmounted(() => window.removeEventListener('mousemove', update))
*/

import {useMouse2} from "@/utils/mouse.js";

const {x, y} = useMouse2()
</script>

<style scoped>
div {
  background-color: lightblue;
}
</style>