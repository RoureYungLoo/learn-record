
import {createApp, provide} from 'vue'
import App from './App.vue'

const app = createApp(App)

/* 从应用层面注入依赖 */
app.provide('msg','I am provided in the whole life')

app.mount('#app')
