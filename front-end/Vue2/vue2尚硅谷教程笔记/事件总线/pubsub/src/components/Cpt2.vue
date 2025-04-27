<template>
	<div>
		<div>组件2接收到的消息：</div>
		<div>{{msg}}</div>
	</div>
</template>

<script>
	import pubsub from 'pubsub-js'
	export default {
		name: "Cpt2",
		data: function() {
			return {
				msg: ""
			}
		},
		methods: {
			cb(p) {
				console.log(p);
				this.msg = p.time
			}
		},
		mounted() {
			// 绑定组件x的hello事件监听器
			// this.x.$on('hello', this.cb)
			// this.$bus.$on('hello', this.cb)

			this.subscribeId = pubsub.subscribe("msg001", (msgName, msgContent) => {
				this.cb(msgContent)
			})

		},
		beforeDestroy() {
			// this.$bus.$off('hello')
			pubsub.unsubscribe(this.subscribeId)
		}

	}
</script>

<style lang="scss" scoped>

</style>