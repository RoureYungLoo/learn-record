import axios from "axios";

/* 创建 axios 实例 */
const instance = axios.create({
  baseURL: 'http://localhost',
  timeout: 1000,
  headers: {'X-Custom-Header': 'foobar'}
})

/* 全局默认配置 */
instance.defaults.headers.common['Authorization'] = Math.floor(Math.random() * 1000_0000_0000).toString(16).toUpperCase()


/* 请求拦截器 */

export const requestInterceptor = instance.interceptors.request.use((config) => {
  console.log("请求拦截器", config)
  return config
}, (err) => {
  return Promise.reject(err)
})

/* 响应拦截器 */
export const responseInterceptor = instance.interceptors.response.use((resp) => {
  console.log("响应拦截器:", resp)
}, (err) => {
  return Promise.reject(err)
})


export default instance