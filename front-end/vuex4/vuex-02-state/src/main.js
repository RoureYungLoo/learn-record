
import {createApp} from 'vue'
import App from './App.vue'

import {store} from "@/store/count.js";

const app = createApp(App);
app.use(store)
app.mount('#app')

store.commit('increment')
console.log(store)