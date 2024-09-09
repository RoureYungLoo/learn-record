import axios from "axios";
import { ElMessage } from 'element-plus'

// const baseURL = 'http://localhost:80'
const baseURL = "/api";
const instance = axios.create({
  baseURL,
});

// 使用拦截器
instance.interceptors.response.use(
  (res) => {
    if (res.data.code === 0) {
      return res.data;
    }

    // alert(res.data.msg ? res.data.msg : "服务异常");
	ElMessage.error(res.data.msg)
    return Promise.reject(res.data);
  },
  (err) => {
    // console.log(err);
	ElMessage.error("请求出错了")
    return Promise.reject(err);
  }
);

export default instance;
