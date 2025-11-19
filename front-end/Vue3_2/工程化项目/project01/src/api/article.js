// import axios from "axios"
// const baseURL = 'http://localhost:80'
// const instance = axios.create({
// 	baseURL
// })

import request from '@/util/request.js'

// export const searchService = async (searchOptions) => {
// 	// axios.get('http://localhost:80/article/search', {
// 	return await instance.get('/article/search', {
// 		params: {
// 			// ...searchOptions.value
// 			category: searchOptions.value.category,
// 			// category: searchOptions.category,
// 			state: searchOptions.value.state,
// 			// state: searchOptions.state,
// 		}
// 	}).then(res => {
// 		// articleList.value = res.data
// 		return res.data
// 	}).catch(err => {
// 		console.log(err)
// 	})
// }

// 使用拦截器
export const searchService = (searchOptions) => {
	return request.get("/article/search")
}

/* export const initDataService = async function() {
	// axios.get('http://localhost:80/article/getAll').then(
	return await instance.get('/article/getAll').then(
		res => {
			// articleList.value = res.data
			return res.data
		}
	).catch(err => {
		console.log(err)
	})
} */

// 使用拦截器
export const initDataService = () => {
	return request.get('/article/getAll')
}

/* 按钮事件 */
/* export const editHandlerService = async (id) => {
	console.log("editHandler")
} */
/* 使用拦截器 */
export const editHandlerService = (id) => {
	let article = {
		title: "测试标题",
		category: "测试类别",
		time: "2024-09-04",
		state: "草稿",
	}
	return request.put('/article',article)
}

/* export const deleteHandlerService = async (id) => {
	console.log("deleteHandler")
	// axios.delete(`http://localhost:80/article/${id}`).then(res => {
	return await instance.delete(`/article/${id}`).then(res => {
		// console.log(res.data)
		// initData()
		return res.data
	}).catch(err => {

	})
} */

// 使用拦截器
export const deleteHandlerService = async (id) => {
	return request.delete(`/article/${id}`)
}

// export {
// 	// searchService,
// 	// initDataService,
// 	// editHandlerService,
// 	// deleteHandlerService,
// }


// 使用拦截器