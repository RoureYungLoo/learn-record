<template>
	<div>
		<Item v-for="todo in todoList" :key="todo.id" :todo="todo" :removeTodoItem="removeTodoItem" :onItemChange="onItemChange"></Item>
	</div>
</template>

<script>
	import Item from "./Item.vue"
	export default {
		name: "List",
		props: ['todoList','removeTodoItem','onItemChange'],
		components: {
			Item
		}
	}
</script>

<style lang="scss" scoped>
</style>