<template>
	<!-- 	<BlogPost :title="mytitle" />
	<BlogPost title="标题1" />
	<BlogPost title="标题2" />
	<BlogPost title="标题3" /> -->
	<div :style="{fontSize: postFontSize+'em'}">
		<!-- <BlogPost v-for="post in posts" :key="post.id" :title="post.title" /> -->
		
		
		<BlogPost @shrink-text="postFontSize-=0.1" v-on:enlarge-text="postFontSize+=0.1" v-for="post in posts" :key="post.id" :title="post.title" />
	</div>
</template>

<script >
	import BlogPost from "./BlogPost.vue"


	export default {
		data() {
			return {
				mytitle: "我的文章标题",
				posts: [{
						id: 1,
						title: "this is a title 1"
					},
					{
						id: 2,
						title: "this is a title 2"
					},
					{
						id: 3,
						title: "this is a title 3"
					},
				],
				postFontSize: 1,
			}
		},
		components: { // 注册子组件
			BlogPost
		}
	}
</script>

<style>
</style>