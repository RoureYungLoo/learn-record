import {createApp} from 'vue'
import App from './App.vue'
import 'ant-design-vue/dist/reset.css'
import Antd from 'ant-design-vue'
import router from "@/router/router.js";
import {createPinia} from "pinia";


const app = createApp(App);
const pinia = createPinia();

app.use(Antd)
app.use(router)
app.use(pinia)

app.provide('user', {
  username: "lisi",
  password: "123456",
  address: "zhengzhou"
})

app.mount('#app')
