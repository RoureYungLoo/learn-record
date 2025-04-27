<template>
	<div class="todolayout">
		<Header :todoList="todoList" :addTodoItem="addTodoItem"></Header>
		<List v-if="todoList.length>0" :todoList="todoList" :removeTodoItem="removeTodoItem" :onItemChange="onItemChange"></List>
		<Footer v-if="todoList.length>0" :todoList="todoList" :onClearDone="onClearDone" :onSelectAll="onSelectAll">
		</Footer>
	</div>
</template>

<script>
	import Header from './Header.vue';
	import List from './List.vue';
	import Footer from './Footer.vue';

	export default {
		name: "TodoList",
		components: {
			Header,
			List,
			Footer
		},
		data: function() {
			return {
				todoList: [],
			}
		},
		methods: {
			addTodoItem(item) {
				const todoObj = {
					id: new Date().getTime().toString(36) + Math.floor(Math.random() * 1000000),
					status: false,
					content: item
				}
				this.todoList.push(todoObj)
			},
			onItemChange(todo) {
				todo.status = !todo.status
			},
			removeTodoItem(id) {
				this.todoList = this.todoList.filter(item => item.id !== id)
			},
			onSelectAll(status) {
				this.todoList.map(item => item.status = status)
			},

			onClearDone() {
				this.todoList = this.todoList.filter(item => !item.status)
			}

		},
		watch: {
			todoList: {
				deep: true,
				handler: function(NewValue, OldValue) {
					localStorage.setItem("storageTodoList", JSON.stringify(NewValue))
				}
			}
		},
		mounted() {
			this.todoList = JSON.parse(localStorage.getItem("storageTodoList")) || []
			console.log(this.todoList);
		}
	}
</script>

<style lang="scss" scoped>
	.todolayout {
		max-width: 350px;
		border: 1px solid lightgrey;
		border-radius: 3px;
		box-shadow: 5px 5px 25px 1px lightgray;
	}

	// 
</style>