<template>
	<div id="app">
		<Cpt1></Cpt1>
		<Cpt2></Cpt2>
	</div>
</template>

<script>
	import Cpt1 from './components/Cpt1.vue'
	import Cpt2 from './components/Cpt2.vue'
	export default {
		name: 'App',
		components: {
			Cpt1,Cpt2
			
		},
		
	}
</script>

<style>
	#app {}
</style>