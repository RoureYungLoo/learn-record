import {createApp} from 'vue'
import App from './App.vue'
import router from '@/router/router.js'

import json from 'highlight.js/lib/languages/json.js'

const app = createApp(App)
app.use(router)
app.use(json)

app.mount('#app')
