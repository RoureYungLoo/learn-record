import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import RootView from '@/views/RootView.vue'
import SearchView from '@/views/SearchView.vue'
import UserView from '@/views/UserView.vue'

// 重定向字符串
const redirect_str = '/home' // 重定向字符串

// 目标命名路由对象
const redirect_obj = {
    name: 'home',
    params: {
        username: 'lisi',
        password: 'g8976gre67'
    }
}

// 动态返回路由对象
const func = (to) => {
    return {
        path: '/search',
        query: {
            q: to.params.text
        }
    }
}

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        // {
        //     path: '/',
        //     name: 'root',
        //     component: RootView,
            // redirect: redirect_str // 路由重定向配置
            // redirect: redirect_obj // 路由重定向配置

            // 将 '/' 别名为 '/home'，意味着当用户访问 '/home' 时，
            // URL 仍然是 '/home'，但会被匹配为用户正在访问 '/'
            // alias:'/home'

        // }, {
        //     path: '/home',
        //     name: 'homeName',
        //     component: HomeView
        //
        // },
        // {
        //     path: '/search/:text',
        //     component: SearchView, // 配置重定向而又没有子路由的情况下可以省略
        //     redirect: func, // 路由重定向配置:
        // redirect: (to) => {
        //     return {
        //         path:'/search',
        //         query:{
        //             q: to.params.text
        //         }
        //     }
        // } // 路由重定向配置
        // }, {
        //     path: '/search',
        //     component: RootView
        // },
        // {
        //     path: '/users/:id/posts',
        //     // component:UserView,
        //     redirect: to => { // 相对重定向
        //         return 'profile'
        //         // return {
        //         //     path:'profile'
        //         // }
        //     }
        // },
        // {
        //     path: '/users/:id/profile',
        //     component: UserView
        // }

        {
            // path: '/users',
            path: '/users/:id',
            component: UserView,
            children: [
                {
                    path:'profile',
                    component:HomeView,
                    // 可以设置多个别名
                    alias: [
                        '/:id',
                        '',
                    ]
                }
            ]

        }
    ],
})

export default router
