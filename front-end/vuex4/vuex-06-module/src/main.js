import {createApp} from 'vue'
import App from './App.vue'
import store from "@/store/store.js";
import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'

const app = createApp(App);
app.use(store)
app.use(ElementPlus)
app.mount('#app')
