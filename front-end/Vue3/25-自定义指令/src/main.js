import {createApp} from 'vue'
import App from './App.vue'

const app = createApp(App)

/* 全局注册自定义指令 */
app.directive('mydirective', {
    mounted: el => el.focus()
})

/* 简化形式, 针对于 mounted 和 updated,  v-color */
app.directive('color', (el, binding) => {
    el.style.color = binding.value
})

app.directive('object', (el, binding, vnode) => {
    let obj = binding.value
    el.style.color = obj.mycolor.value
    el.style.fontSize = obj.mysize.value + "px"
    el.title = obj.mytitle.value
    // console.log(binding.value)
})

app.mount('#app')
// createApp(App).mount('#app')
