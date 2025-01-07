
import {createApp, provide} from 'vue'
import App from './App.vue'

const app = createApp(App)
app.provide('msg','I am provided in the whole life')

app.mount('#app')
