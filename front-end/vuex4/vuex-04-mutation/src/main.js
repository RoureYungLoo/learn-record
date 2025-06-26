import {createApp} from 'vue'
import App from './App.vue'
import {createStore} from "vuex";
import store from "@/store/store.js";

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app = createApp(App);
app.use(store)
app.use(ElementPlus)
app.mount('#app')
