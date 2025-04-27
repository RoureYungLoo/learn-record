<template>
	<div class="itemLayout">
		<div class="left"><input type="checkbox" :value="todo.content" :checked="todo.status"
				@change="onItemChange(todo)" />{{todo.content}}</div>

		<!-- <div class="left"><input type="checkbox" :value="todo.content" v-model="todo.status" />{{todo.content}}</div> -->
		<div class="right"><button @click="removeTodoItem(todo.id)">删除</button></div>

	</div>
</template>

<script>
	export default {
		name: "Item",
		props: ['todo', 'removeTodoItem', 'onItemChange'],
	};
</script>

<style lang="scss" scoped>
	.itemLayout {
		padding: 10px;
		display: flex;
		align-items: center;
		justify-content: space-between;
		border: 1px solid lightgrey;

		.left {
			width: 80%;
		}


		.right {
			width: 20%;

			button {
				color: #fff;
				background: red;
				border: none;
				border-radius: 2px;
				padding: 5 10px;
				display: none;
			}

		}
	}

	.itemLayout:hover {
		.right {
			button {
				display: block;
			}
		}
	}
</style>