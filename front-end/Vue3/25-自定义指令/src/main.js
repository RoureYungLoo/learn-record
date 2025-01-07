import {createApp} from 'vue'
import App from './App.vue'

const app = createApp(App)

app.directive('mydirective',{
    mounted: el => el.focus()
})
app.mount('#app')
// createApp(App).mount('#app')
