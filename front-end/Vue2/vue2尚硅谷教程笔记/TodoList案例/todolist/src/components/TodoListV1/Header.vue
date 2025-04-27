<template>
	<div class="headerLayout">
		<input type="text" v-model="item" @keydown.enter="onClick" placeholder="请输入待办事项,回车键添加" />
	</div>
</template>

<script>
	export default {
		name: "Header",
		props:['todoList','addTodoItem'],
		data:function(){
			return{
				item:""
			}
		},
		methods: {
			onClick() {
				this.addTodoItem(this.item)
				this.item=""
			}
		},
		

	};
</script>

<style lang="scss" scoped>
	.headerLayout {
		padding: 10px;

		input {
			padding: 5px;
			width: 100%;
			border: 1px solid lightgray;
		}
	}
</style>