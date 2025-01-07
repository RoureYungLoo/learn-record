import {createMemoryHistory, createRouter} from 'vue-router'
import User from '@/components/User.vue'
import Home from '@/components/Home.vue'
import UserProfile from "@/components/UserProfile.vue";
import UserPosts from "@/components/UserPosts.vue";
import UserHome from '@/components/UserHome.vue'

const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/user/:id',
        component: User, // v4.1+ 支持忽略父组件
        name:'userparent',
        children: [ // 子路由(嵌套路由)
            {
                path: 'profile',
                component: UserProfile,
                name:'userprofile' // 只有子路由具有名称
            },
            {
                path: 'posts',
                component: UserPosts,
                name:'userposts'
            },
            {
                path: '',
                component: UserHome,
                name:'userhome'     // 怎么导航到命名路由
            }
        ]
    },
]

const router = createRouter({
    history: createMemoryHistory(),
    routes: routes
})

export default router