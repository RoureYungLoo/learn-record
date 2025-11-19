<template>
	文章分类：<input type="text" v-model="searchOptions.category" />
	发布状态：<input type="text" v-model="searchOptions.state" />
	<button @click="search">搜索</button>
	<table border="1" colspa="0" cellspacing="0">
		<tr>
			<th>文章标题</th>
			<th>分类</th>
			<th>发表时间</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<tr v-for="(article,index) in articleList" :key="article.id">
			<td>{{article.title}}</td>
			<td>{{article.category}}</td>
			<td>{{article.time}}</td>
			<td>{{article.state}}</td>
			<td>
				<button @click="editHandler(article.id)">编辑</button>
				<button @click="deleteHandler(article.id)">删除</button>
			</td>
		</tr>
	</table>
</template>

<script setup>
	import {
		ref,
		onMounted
	} from 'vue'
	// import axios from 'axios'
	import {
		searchService,
		initDataService,
		deleteHandlerService,
		editHandlerService
	} from '@/api/article.js'

	/* 响应式数据 */
	const articleList = ref([])

	/* 定义了一个service */
	const getAllService = async ()=>{
		articleList.value = await initDataService()
	}
	

	/* 表单绑定 */
	const searchOptions = ref({
		category: "",
		state: ""
	})



	/* 按钮事件 */
	/* 	const editHandler = (id) => {
			console.log("editHandler")
		}

		const deleteHandler = (id) => {
			console.log("deleteHandler")
			axios.delete(`http://localhost:80/article/${id}`).then(res => {
				console.log(res.data)
				initData()
			}).catch(err => {

			})
		} */

	/* 	const search = () => {
			axios.get('http://localhost:80/article/search', {
				params: {
					// ...searchOptions.value
					category: searchOptions.value.category,
					state: searchOptions.value.state,
				}
			}).then(res => {
				articleList.value = res.data
			}).catch(err => {
				console.log(err)
			})
		} */

	/* 按钮事件 */
	const search = async ()=>{
		console.log(searchOptions)
		articleList.value = await searchService(searchOptions)
	}
	
	const deleteHandler = async(id)=>{
		let data = await deleteHandlerService(id)
		console.log(data)
		getAllService()
	}
	
	const editHandler = async (id)=>{
		let data = await editHandlerService()
		console.log("editHandler: "+data)
		getAllService()
	}
	
	/* 初始化表格 */
	/* 	const initData = function() {
			axios.get('http://localhost:80/article/getAll').then(
				res => {
					articleList.value = res.data
				}
			).catch(err => {
				console.log(err)
			})
		} */



	/* 生命周期函数 */
	onMounted(() => {
		// initData()
		getAllService()
	})
</script>

<style>
</style>