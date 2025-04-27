<template>
	<div>
		<!-- <h1>{{person.name}} - {{person.age}} - {{person.job.pm.salary}}</h1>
		<button @click="changeName">changeName</button>
		<button @click="changeAge">changeAge</button>
		<button @click="changeSalary">changeSalary</button> -->
		<Suspense>
			<template v-slot:default>
				<Child></Child>
			</template>
			<template v-slot:fallback>
				<el-skeleton :rows="5" animated />
			</template>
		</Suspense>
	</div>
</template>



<script>
	// import { defineAsyncComponent } from "vue";
	// const Child = defineAsyncComponent(()=>import('./Child.vue'))

	import Child from './Child.vue'
	export default {
		name: "HelloWorld",
		components: {
			Child
		}
	}


	// <script setup>
	// import Child from './Child'
	// import {
	// defineAsyncComponent
	// } from 'vue';

	// const Child = defineAsyncComponent(() => import('./Child.vue'))
	// import {
	// 	reactive,
	// 	watch,
	// 	watchEffect
	// } from 'vue';


	// const person = reactive({
	// 	name: "fhapfhe",
	// 	age: 33,
	// 	job: {
	// 		pm: {
	// 			salary: 5000
	// 		}
	// 	}
	// })

	// watch(
	// 	person,
	// 	(newValue, oldValue) => {
	// 		console.log(newValue,oldValue);
	// 	}, {
	// 		// immediate: true,
	// 		// deep:true
	// 	}
	// )
	// watchEffect(() => {
	// 	console.log(person.name);
	// })

	// const changePerson = () => {}

	// const changeName = () => {
	// 	person.name = Date.now().toString(34)
	// }
	// const changeAge = () => {
	// 	person.age = Math.floor(Math.random() * 100)
	// }
	// const changeSalary = () => {
	// 	person.job.pm.salary = Math.floor(Math.random() * 10000)
	// }
</script>

<style scoped>

</style>