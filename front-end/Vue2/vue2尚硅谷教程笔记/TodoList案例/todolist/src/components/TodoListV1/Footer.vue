<template>
	<div class="footerLayout">
		<div class="left">
			<!-- 			<input type="checkbox" :checked="isAllDone" @change="onSelectAll(!isAllDone)" /> 已完成{{todoDone}} /全部 {{todoTotal}} -->
			<input type="checkbox" v-model="isAllDone" /> 已完成{{todoDone}} /全部
			{{todoTotal}}
		</div>
		<div class="right">
			<button @click="onClearDone">清除已完成</button>
		</div>
	</div>
</template>

<script>
	export default {
		name: "Footer",
		props: ['todoList', 'onClearDone', 'onSelectAll'],
		computed: {
			todoTotal() {
				return this.todoList.length
			},
			todoDone() {
				return this.todoList.reduce((previous, current) => {
					return previous + (current.status ? 1 : 0)
				}, 0)
			},
			// isAllDone() {
			// 	return this.todoTotal === this.todoDone && this.todoTotal > 0
			// },
			isAllDone: {
				get() {
					return this.todoTotal === this.todoDone && this.todoTotal > 0
				},
				set(value) {
					console.log(value);
					this.onSelectAll(value)
				}
			}

		}
	}
</script>

<style lang="scss" scoped>
	.footerLayout {
		padding: 10px;
		display: flex;
		align-items: center;
		justify-content: space-between;
		border: 1px solid lightgrey;
		
		.left {
			width: 70%;
		}
		
		
		.right {
			width: 30%;
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
	.footerLayout:hover{
		.right{
			button{
				display: block;
			}
		}
	}
</style>