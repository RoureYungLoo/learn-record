import {createRouter, createWebHistory} from 'vue-router'
import {inject} from "vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('@/views/Home.vue'),
        },
        {
            path: '/home',
            component: () => import('@/views/Home.vue'),
        },
        {
            path: '/about',
            name: 'about',
            component: () => import('@/views/About.vue'),
        },
        {
            path: '/user',
            component: () => import('@/views/User.vue')
        }
    ],
})


router.beforeEach(async (to, from) => {
    console.log("beforeEach loading...")
    let inject1 = inject('loading');
    inject1.value = true
    return await new Promise((resolve, reject) => {
        setTimeout(() => {
            if (to.fullPath === '/home') {
                resolve({
                    path: '/user',
                    query: {
                        name: '张三',
                        age: 26,
                        ts: Date.now()
                    }
                })
            } else {
                resolve(true)
            }
        }, 1500)
    })
})

/*全局导航故障*/
router.afterEach((to, from, failure) => {
    let inject1 = inject('loading');
    inject1.value = false

    /*监测全局导航故障*/
    if (failure) {
        console.log(`路由失败了从${from.fullPath}到${to.fullPath}`)
    } else {
        console.log(`路由成功了从${from.fullPath}到${to.fullPath}`)
    }
})


export default router
