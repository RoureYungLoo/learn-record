<script>
	// import MyHello from './components/MyHello.vue';

	// 这是一个父组件，它导入了子组件
	import ButtonCounter from './components/ButtonCounter.vue'
	import Blog from './components/Blog.vue'
	import AlertBox from './components/AlertBox.vue'
	import Tab1 from './components/Tab1.vue'
	import Tab2 from './components/Tab2.vue'
	import Tab3 from './components/Tab3.vue'

	export default {
		components: { // 注册已经导入的组件，以便模板使用
			ButtonCounter,
			Blog,
			AlertBox,
			Tab1, // 注册的组件名 是Tab1
			Tab2,// 注册的组件名 是Tab2
			Tab3,// 注册的组件名 是Tab3
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
	<!-- <ButtonCounterCounter></ButtonCounterCounter> -->
	<Blog />

	<!-- 父组件里使用子组件 -->
	<AlertBox>
		不好的事发生了
	</AlertBox>

	<!-- 动态组件 -->
	<button v-for="tab in Tabs" :key="tab" @click="curTab=tab">{{tab}}</button>
	<component :is="curTab"></component>



</template>