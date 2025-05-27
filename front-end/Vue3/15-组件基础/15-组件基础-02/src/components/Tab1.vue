<template>
	<div>
		组件1
	</div>
</template>

<script setup>
import {onMounted, onUnmounted} from "vue";

onMounted(()=>{
  console.log("组件1 onMounted")
})
onUnmounted(()=>{
  console.log("组件1 onUnmounted")
})
</script>

<style scoped>
</style>