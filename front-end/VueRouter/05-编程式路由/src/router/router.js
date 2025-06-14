import {createRouter, createMemoryHistory, createWebHistory} from 'vue-router'

import Home from '@/components/Home.vue'
import User from '@/components/User.vue'
import Register from '@/components/Register.vue'

const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/users/:username',
        name: 'user', // 命名路由
        component: User
    },
    {
        path: '/register',
        name: 'reg',
        component: ()=>import('@/components/Register.vue')
    },
    // {
    //     path: '/register',
    //     component: Register
    // }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router