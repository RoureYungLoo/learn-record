import {createApp} from 'vue'
import App from './App.vue'
import 'ant-design-vue/dist/reset.css'
import Antd from 'ant-design-vue'
import router from "@/router/router.js";


createApp(App)
    .use(Antd)
    .use(router).mount('#app')
