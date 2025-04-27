<template>
	<div id="app">
		<Cpt1Vue></Cpt1Vue>
		<Cpt2Vue></Cpt2Vue>
	</div>
</template>

<script>
	import Cpt1Vue from './components/Cpt1.vue';
	import Cpt2Vue from './components/Cpt2.vue';
	export default {
		name: 'App',
		components: {
			Cpt1Vue,
			Cpt2Vue
		}
	}
</script>

<style>
#app{
	padding: 15px;
}
</style>