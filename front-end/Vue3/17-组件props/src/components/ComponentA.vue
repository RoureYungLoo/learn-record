<template>
	<!-- <h1>{{name}}</h1> -->
	<!-- <h1>{{age}}</h1> -->
	<!-- <h1>{{greetingMessage}}</h1> -->
	<p>
		{{id}},<br>
		{{likes}},<br>
		{{isPublished}},<br>
		{{commentIds}},<br>
		{{author}} <br>

		{{name}} - {{age}} - {{desc}}
	</p>
</template>

<script setup>
	/* 定义组件props */
	// const props=defineProps([
	// 	'name','age'
	// ])

	// 使用对象定义组件props
	const props = defineProps({
		id: Number,
		name: String,
		age: Number,
		desc: String,
		greetingMessage: String,
		likes: Number,
		isPublished: Boolean,
		commentIds: Array,
		author: Object
	})
</script>

<style>
</style>