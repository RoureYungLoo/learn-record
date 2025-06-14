import {createMemoryHistory, createRouter, createWebHistory} from 'vue-router'

import HomeView from '@/components/HomeView.vue'
import AboutView from '@/components/AboutView.vue'
import UserVue from '@/components/User.vue'
import NotFound from '@/components/NotFound.vue'

const routes = [
    {
        path: '/', component: HomeView
    },
    {
        path: '/about',
        component: AboutView
    },
    {
        path: '/users/:id', // 动态路由参数
        component: UserVue
    },
    {
        path: '/users/:username/posts/:postId',
        component: UserVue
    },
    {
        path: '/:pathMatch(.*)*', name: 'NotFound', component: NotFound
    },
    {
        path: '/user-:afterUser(.*)',component: UserVue
    }
]

const router = createRouter({
    // history: createMemoryHistory(),
    history: createWebHistory(),
    routes
})

export default router