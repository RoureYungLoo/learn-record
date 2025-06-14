import {createApp, ref} from 'vue'
import App from './App.vue'
import router from './router'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/reset.css'

const app = createApp(App)
const loading = ref(true);
app.provide('loading', loading)

app.use(router)
app.use(Antd)

app.mount('#app')
