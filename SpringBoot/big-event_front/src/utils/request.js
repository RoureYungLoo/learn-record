import axios from "axios";
import { ElMessage } from "element-plus";

// const baseURL = 'http://localhost:80'
const baseURL = "/api";
const instance = axios.create({
  baseURL,
});

import router from "@/router/index.js";


// 使用拦截器
instance.interceptors.response.use(
  (res) => {
    // console.log("response interceptor res.data: ", res.data);
    if (res.data.code === 0) {
      return res.data;
    }

    // alert(res.data.msg ? res.data.msg : "服务异常");
    ElMessage.error(res.data.msg);
    return Promise.reject(res.data).catch((e)=>{
      // console.log(e)
    });
  },
  (err) => {
    // console.log("err: ", err);
    ElMessage.error("请求出错了");
    router.push("/login")
    return Promise.reject(err).catch((e) => {
      // console.log(e);
    });
  }
);

import { useTokenStore } from "@/stores/token.js";
// 请求拦截器
instance.interceptors.request.use(
  (config) => {
    const tokenStore = useTokenStore();
    if (tokenStore.token) {
      config.headers.Authorization = tokenStore.token;
    }
    return config;
  },
  (err) => {
    return Promise.reject(err);
  }
);

export default instance;
