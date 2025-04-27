<template>
	<div>
		<div>组件1</div>
		<button @click="onClick">给组件2传递参数</button>
	</div>
</template>

<script>
	export default {
		name: "Cpt1",
		data: function() {
			return {
				obj: {
					cmp: "cpt1",
					time: Date.now()
				}
			}
		},
		methods: {
			updateObj(){
				this.obj.time = Date.now()
			},
			onClick() {
				this.updateObj()
				// 触发组件x的hello事件
				// this.x.$emit('hello', this.obj)
				this.$bus.$emit('hello', this.obj)
			}
		}


	}
</script>

<style lang="scss" scoped>

</style>