<template>
	<div>
		<button @click="increment">count:{{count}}</button>
	</div>
</template>

<script setup>
	import {ref,onMounted} from 'vue'
	
	/* 响应式数据 */
	const count = ref(0)
	
	function increment(){
		count.value++
	}
	
	/* 声明周期函数 */
	onMounted(function(){
		step1()
		step2()
		step3()
	})
	
	function step1(){
		console.log("step1")
	}
	function step2(){
		console.log("step2")
	}
	function step3(){
		console.log("step3")
	}
</script>

<style>
</style>