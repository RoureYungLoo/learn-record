<template>
<h3>
  Mouse is at: ({{x}}, {{y}})
</h3>
</template>

<script setup>

import {onMounted, onUnmounted, ref} from "vue";

const x=ref(0)
const y=ref(0)

function update(event){
  x.value=event.pageX
  y.value=event.pageY
}
onMounted(()=>window.addEventListener('mousemove',update))
onUnmounted(()=>window.removeEventListener('mousemove',update))

</script>

<style scoped>

</style>