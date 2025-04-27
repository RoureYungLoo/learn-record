<template>
	<div id="app">
		<!-- <Counter></Counter> -->
		<CounterWithMapXXX></CounterWithMapXXX>
	</div>
</template>

<script>
	import Counter from './components/Counter.vue'
	import CounterWithMapXXX from './components/CounterWithMapXXX.vue'
	export default {
		name: 'App',
		components: {
			Counter,
			CounterWithMapXXX
		}
	}
</script>

<style>
	#app {}
</style>