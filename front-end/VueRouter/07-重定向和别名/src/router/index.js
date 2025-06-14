import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import RootView from '@/views/RootView.vue'
import SearchView from '@/views/SearchView.vue'
import UserView from '@/views/UserView.vue'

// 重定向字符串
const redirect_str = '/home' // 重定向字符串

// 目标是命名路由对象
/*const redirect_obj = {
    name: 'home', // 路由名
    params: { // 参数
        username: 'lisi',
        password: 'g8976gre67'
    }
}*/

// 动态返回路由对象 , to 是目标路由, 返回重定向的路由对象
/*const func = (to) => {
    return {
        path: '/search',
        query: {   // query string 参数
            q: to.params.text,
            param2: to.params.aaa,
            ts : Date.now()
        }
    }
}*/

const router = createRouter({
    // history: createWebHistory(import.meta.env.BASE_URL),
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'root',
            component: RootView,
            // redirect: redirect_str // 路由重定向配置
            // redirect: redirect_obj // 路由重定向配置
            //
            // 将 '/' 别名为 '/home'，意味着当用户访问 '/home' 时，
            // URL 仍然是 '/home'，但会被匹配为用户正在访问 '/'
            alias: '/home'
            //
        },
        // , {
        //     path: '/home',
        //     name: 'homeName',
        //     component: HomeView
        // }, {
        //     path: '/home/:username/:password',
        //     name: 'home',
        //     component: HomeView
        // },
        // {
        //     path: '/search/:text/:aaa',
        //     component: SearchView, // 配置重定向而又没有子路由的情况下可以省略
        //     // redirect: func // 路由重定向配置:
        //     /* 访问'/search/xxx' 会被重定向到 '/search?q=xxx' */
        //     redirect: (to) => {
        //         return {
        //             path: '/search',
        //             query: {
        //                 q: to.params.text,
        //                 ts: Date.now(),
        //                 token: Date.now().toString(36)
        //             }
        //         }
        //     } // 路由重定向配置
        // }, {
        //     path: '/search',
        //     component: SearchView
        // },
        // {
        //     path: '/users/:id/posts',
        //     // component:UserView,
        //     redirect: to => { // 相对重定向
        //         // return 'profile'
        //         // return {
        //         //     path:'profile'
        //         // }
        //         console.log(to.path)
        //         /* 相对重定向 */
        //         return to.path.replace(/posts$/,'profile')
        //
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
                    path: 'profile',
                    component: HomeView,
                    // 可以设置多个别名
                    /*
                    /123
                    /people
                    /users/123/list
                    /users/123/aaa */
                    alias: [
                        '/:id',  //  匹配跟路由 /xxx
                        'aaa',
                        '/people', // 绝对路径
                        'list',
                        ':age',
                        ':ts/:type',
                        ''
                    ]
                }
            ]

        }
    ],
})

export default router
