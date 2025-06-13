import {createRouter, createWebHistory} from 'vue-router'

/* 动态导入 */
const Home = () => import('@/views/Home.vue')
const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
        },
        {
            path: "/home",
            component: () => import('@/views/Home.vue')
        }
    ],
})

export default router
