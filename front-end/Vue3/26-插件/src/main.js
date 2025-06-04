import {createApp} from 'vue'
import App from './App.vue'

let app = createApp(App);
/* 使用插件 */
import myPlugin from '@/plugins/myPlugin.js'
app.use(myPlugin, {
    opt1: "value1",
    opt2: {
        username: "lisi",
        age: 24
    },
    opt3: [
        {
            count: 23,
            level: "high"
        }, {
            count: 18,
            level: "low"
        }
    ]
})
import i18nPlugin from '@/plugins/i18n.js'
app.use(i18nPlugin,{
    greetings:{
        hello: "你好",
        cxk:"蔡徐坤"
    }
})

app.mount('#app')
