import {createRouter, createWebHistory} from 'vue-router'
import Home from '../views/Home.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
        },
        {
            path: "/home",
            component: Home
        },
        {
            path: '/about',
            name: 'about',
            component: () => import('@/views/About.vue'),
        },
    ],
    /* 路由切换时, 页面如何滚动 */
    scrollBehavior: function (to, from, savedPosition) {
        // return {
        //     // top: 0 // 始终滚动到顶部
        //
        //     el: "#testId",
        //     top: 80
        // }

        /* 保存原生滚动条位置 */
        // if (savedPosition) {
        //     return savedPosition
        // } else {
        //     return {
        //         top:0
        //     }
        // }

        /* 滚动到锚点 */
        // if (to.hash) {
        //     return {
        //         el: to.hash,
        //         behavior:'smooth' // 平滑滚动
        //     }
        // }

        /* 延迟滚动 */
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                resolve({
                    top: 0,
                    left: 0,
                    el:'#testId',
                    behavior:'smooth'
                })
            },1500)
        })

        /* 高级偏移量 () */
        // 暂时跳过
    }
})

export default router
