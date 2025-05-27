<template>
	<div>
		组件3
	</div>
</template>

<script setup>
import {onMounted, onUnmounted} from "vue";

onMounted(()=>{
  console.log("组件3 onMounted")
})
onUnmounted(()=>{
  console.log("组件3 onUnmounted")
})
</script>

<style scoped>
</style>