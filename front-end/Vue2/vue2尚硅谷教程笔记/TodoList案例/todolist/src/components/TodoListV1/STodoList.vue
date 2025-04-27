<template>
	<div>
		<input type="text" v-model="iptValue" @keydown.enter="onConfirm(iptValue)" />
		
		
		
		<div v-for="(todo,index) in todoList" :key="todo.id">
			<input type="checkbox" :checked="todo.status" :value="todo"
				@change="onItemChange(todo)" />{{todo.content}}<button @click="onDelete(index)">删除</button>
		</div>
		
		
		<div>
			<input type="checkbox" @change="onSelectAll" :checked="selected===todoList.length" />
			已选择{{selected}}/全部{{todoList.length}} <button type="button" @click="removeDone">清除已完成</button>
		</div>
	</div>
</template>

<script>
	export default {
		name: "STodoList",
		data: function() {
			return {
				iptValue: "",
				todoList: [{
						id: 0,
						status: false,
						content: '写代码',
					},
					{
						id: 1,
						status: true,
						content: '跑步',
					},
					{
						id: 2,
						status: false,
						content: '游泳'
					}
				],

			}
		},
		computed: {
			selected() {
				let n = 0;
				this.todoList.forEach(item => {
					if (item.status) n++
				})
				return n;
			}
		},
		methods: {
			onConfirm(iptValue) {
				this.todoList.push({
					status: false,
					content: iptValue
				})
				this.iptValue = ""
				console.log(this.todoList);
			},
			onDelete(index) {
				this.todoList.splice(index, 1)
				console.log(index)
			},
			onItemChange(item) {
				item.status = !item.status

			},
			onSelectAll() {
				if (this.selected === this.todoList.length) {
					this.todoList.map(item => item.status = false)
				} else {
					this.todoList.map(item => item.status = true)
				}
			},
			removeDone() {
				this.todoList = this.todoList.filter(item => !item.status)
			},

		},

	}
</script>

<style lang="scss" scoped>
</style>