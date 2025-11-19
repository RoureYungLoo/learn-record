import axios from "axios"
const baseURL = 'http://localhost:80'
const instance = axios.create({
	baseURL
})

// 使用拦截器
instance.interceptors.response.use(
	res => {
		return res.data
	},
	err => {
		console.log(err)
		return Promise.reject(err)
	}
)

export default instance;