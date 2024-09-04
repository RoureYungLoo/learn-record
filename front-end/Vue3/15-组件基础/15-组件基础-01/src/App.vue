<script>
	// import MyHello from './components/MyHello.vue';
	import ButtonCounter from './components/ButtonCounter.vue'
	import Blog from './components/Blog.vue'
	import AlertBox from './components/AlertBox.vue'
	import Tab1 from './components/Tab1.vue'
	import Tab2 from './components/Tab2.vue'
	import Tab3 from './components/Tab3.vue'

	export default {
		components: {
			ButtonCounter,
			Blog,
			AlertBox,
			Tab1,
			Tab2,
			Tab3,
		},
		data() {
			return {
				curTab: "Tab1",
				Tabs: [
					"Tab1",
					"Tab2",
					"Tab3",
				]
			}
		}
	}
</script>

<template>
	<!-- 	<MyHello />
	<MyHello />
	<MyHello />
	<my-hello></my-hello> -->
	<!-- <ButtonCounter></ButtonCounter> -->
	<Blog />

	<!-- 父组件里使用子组件 -->
	<AlertBox>
		不好的事发生了
	</AlertBox>

	<!-- 动态组件 -->
	<button v-for="tab in Tabs" :key="tab" @click="curTab=tab">{{tab}}</button>
	<component :is="curTab"></component>


</template>