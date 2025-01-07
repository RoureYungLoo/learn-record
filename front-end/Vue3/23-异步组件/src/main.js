import {createApp, defineAsyncComponent, hydrateOnIdle} from 'vue'
import App from './App.vue'
import LoadingComponent from './components/Loading.vue'
import ErrorComponent from './components/Error.vue'

const app = createApp(App)

// 全局注册异步组件
app.component('Home', defineAsyncComponent(() =>
    import('./components/Home.vue')
))

app.component('User',defineAsyncComponent({
    loader: ()=>import('./components/User.vue'),
    loadingComponent: LoadingComponent,
    delay:200,
    errorComponent: ErrorComponent,
    timeout:3000,
    hydrate: hydrateOnIdle(3000) // 惰性激活， 适用于 SSR
}))

app.mount('#app')
