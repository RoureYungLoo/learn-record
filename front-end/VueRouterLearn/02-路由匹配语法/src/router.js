import {createRouter, createMemoryHistory} from 'vue-router'

import UserUve from './components/User.vue'
import BookVue from './components/Book.vue'
import HomeVue from './components/Home.vue'

const routes = [
    {path: '/', component: HomeVue},
    // {path: '/users', component: UserUve},
    // {path: '/books', component: BookVue},
    // {path: '/o/:orderId', component: BookVue},
    // {path: '/:orderId(\\d+)', component: BookVue},
    // {path: '/p/:productName', component: BookVue}
    // {path: '/:productName', component: BookVue},

    // {path: '/:chapters+', component: BookVue,name:'ctrs'},
    // {path: '/:chapters*', component: BookVue},

    // {path: '/users', component: UserUve},

    // {path: '/users/:id', component: UserUve,sensitive:false}, // 大小写敏感
    // {path: '/users/:id?', component: UserUve},

    // * 匹配0个及以上，+ 匹配1个及以上
    // ? 匹配0个或1个
    // {path:'/users/:userId?',component: UserUve},
    {path: '/users/:userId(\\d+)?', component: UserUve},
]

/* 默认是非严格匹配、且大小写不敏感 */
const router = createRouter({
    history: createMemoryHistory(),
    routes: routes,
    strict: false // 严格匹配，不会匹配多余/缺少的尾部斜线
})

export default router
