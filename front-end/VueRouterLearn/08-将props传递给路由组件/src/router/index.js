import {createWebHistory, createRouter} from 'vue-router'
import User from '@/views/User.vue'
import SideBar from '@/views/Sidebar.vue'
import SearchUser from '@/views/SearchUser.vue'

// 创建一个返回 props 的函数
const getProps = function (route) {
    return {
        //query: route.query.q   //URL /search?q=vue 将传递 {query: 'vue'} 作为 props 传给 SearchUser 组件
        query: route.query.city  // /search?city=zhengzhou     {queryStr: 'zhengzhou'}
    }
}

const routes = [
    {
        path: '/users/:id',
        // component: User,
        // props: true //设置 props: true 来配置路由, 将 id 参数作为 prop 传递给组件

        components: {
            default: User,
            sidebar: SideBar
        },
        props: {
            default: true, // 分别设置对应的命名视图
            sidebar: false
        }
    }, {
        path: '/search',
        component: SearchUser,
        props: route => ({queryStr: route.query.city})
        // props: getProps()
    }

]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router