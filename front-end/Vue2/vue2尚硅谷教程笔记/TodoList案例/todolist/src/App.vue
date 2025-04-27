<template>
	<div id="app">
		<h1>TodoList 案例</h1>
		<TodoListV1></TodoListV1>
	</div>
</template>

<script>
	import TodoListV1 from './components/TodoListV1/TodoList.vue';
	export default {
		name: 'App',
		components: {
			TodoListV1
		}
	}
</script>

<style>



</style>