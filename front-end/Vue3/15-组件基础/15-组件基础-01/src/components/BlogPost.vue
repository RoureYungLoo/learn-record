<template>
	<h3>{{title}}</h3>
	<button @click="$emit('enlarge-text')">字体放大</button>
	<button @click="$emit('shrink-text')">字体缩小</button>
</template>

<script>
	export default {
		// 这个组件的特殊 attributes
		props: [
			'title'
		],
		// 子组件可能会抛出的事件
		emits:[
			'enlarge-text',
			'shrink-text'
		]
	}
</script>

<style>
</style>