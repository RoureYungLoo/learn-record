<!-- 

<script setup>

// 使用import局部注册组件ComponentB
import ComponentB from './components/ComponentB.vue';

</script>-->

<script >
import ComponentB from './components/ComponentB.vue';
export default {
	components:{ // 使用components选项局部注册组件ComponentB
		// ComponentB: ComponentB  等价于 ComponentB ,这是ES6语法
		CPB: ComponentB,
		// 组件名：组件对象
	},
	setup() {
		// ...
	}
}

</script>

<template>
	<MyComponent></MyComponent>  <!-- 这个在main.js中全局注册过了 -->
	<ComponentA></ComponentA> <!-- 这个在main.js中全局注册过了 -->
	<!-- <ComponentB></ComponentB> -->
	<CPB></CPB>
	<!-- <ComponentC></ComponentC> -->
</template>

<style scoped>

</style>