import {createRouter, createMemoryHistory} from 'vue-router'
import User from '@/components/User.vue'
import Welcome from '@/components/TheWelcome.vue'

const routes = [
    {
      path: '/',
      component: Welcome
    },
    {
        path: '/user/:username',
        name: 'profile', // 命名路由
        component: User
    }
]

const router = createRouter({
    history: createMemoryHistory(),
    routes: routes
})

export default router