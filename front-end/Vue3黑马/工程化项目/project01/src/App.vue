 <!-- <script >
	 // 选项式API
	export default {
		data(){
			return{
				msg:"上海"
			}
		}
	}
</script> -->

<!-- <script setup>
	 // 组合式API (语法糖)
	import { ref } from 'vue'
	const msg = ref("南京")
	
</script> -->

<script>
	import {ref} from 'vue'
	import ApiVue from './Api.vue'
	import Article from './Article.vue'
	
	export default {
		setup(){    // 组合式API setup()函数
			const count = ref(5)
			const msg = ref("漳州")
			
			const addCount = ()=>{
				count.value++
			}
			
			// console.log("setup 函数执行")
			return {
				count,
				msg,
				addCount
			}
		},
		mounted(){
			// console.log(this.count)
		},
		beforeCreate(){
			// console.log("beforeCreated")
		},
		/* 局部注册组件 */
		components:{
			ApiVue:ApiVue,
			Article:Article
		}
	}
	
</script>



<template>
<!--  <h1>北京</h1>
  <h1>{{msg}}</h1>
  <br>
  <ApiVue /> -->
  <Article/>
</template>

<style scoped>

	h1 {
		color: red;
	}
</style>
