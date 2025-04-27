<template>
	<div>
		<SearchBar></SearchBar>
		<Content></Content>
	</div>
</template>

<script>
	import Content from '../../components/Content/Content.vue';
	import SearchBar from '../../components/SearchBar/SearchBar.vue';
	export default {
		name: "Home",
		components: {
			Content,
			SearchBar
		}
	}
</script>

<style>
</style>