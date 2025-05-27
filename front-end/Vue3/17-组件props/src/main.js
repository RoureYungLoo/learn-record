import './assets/main.css'

import {createApp} from 'vue'
import App from './App.vue'
import dayjs from 'dayjs'

var app = createApp(App);
app.use(dayjs)

app.mount('#app')
