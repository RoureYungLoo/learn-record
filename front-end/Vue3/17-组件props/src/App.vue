<script setup>
	import {
		ref,
		reactive
	} from 'vue';
	import ComponentA from './components/ComponentA.vue'

	const name = ref("组件3A")
	const age = ref(66)
	const person = reactive({
		name,
		age
	})

	const tom = ref("Tom")
	const post = reactive({
		id: 234,
		title: "文章标题",
		author: {
			name: "作者",
			age:55,
			desc:"这是一个小说作者"
		},
		likes: "500", //点赞数
		isPublished: false,
		commentIds: [2, 43, 185]
	})
</script>

<template>
<!-- 	<ComponentA name="组件" age="55" />
	<ComponentA :name="person.name" :age="age" />
	<ComponentA greetingMessage="你好1" />
	<ComponentA greeting-message="你好2" /> -->

	<!-- 动态props -->
	<!-- <ComponentA :greeting-message="tom" /> -->
	
	<!-- Number -->
	<!-- <ComponentA :likes="34"/> -->
	<!-- <ComponentA :likes="post.id"/> -->
	<!-- Boolean -->
	<!-- <ComponentA is-published /> -->
	<!-- <ComponentA :is-published="true" /> -->
	<!-- <ComponentA :is-published="post.isPublished"/> -->
	<!-- Array -->
	<!-- <ComponentA :commentIds="post.commentIds" /> -->
	<!-- <ComponentA :commentIds="[234,1234,5443,]" /> -->

	<!-- Object -->
	<!-- <ComponentA :author="post.author" /> -->
	<ComponentA v-bind="post.author" />
</template>

<style scoped>

</style>