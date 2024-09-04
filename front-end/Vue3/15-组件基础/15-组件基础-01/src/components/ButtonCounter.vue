<script>
	import MyHello from './MyHello.vue'

	export default {
		// 本组件的子组件
		components: {
			MyHello
		}
	}
</script>

<template>
	<h3>计数器</h3>
	<div>
		<MyHello/>
		<my-hello></my-hello>
	</div>
</template>