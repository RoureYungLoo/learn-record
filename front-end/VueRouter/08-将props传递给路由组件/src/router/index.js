import {createWebHistory, createRouter} from 'vue-router'
import User from '@/views/User.vue'
import SideBar from '@/views/Sidebar.vue'
import SearchUser from '@/views/SearchUser.vue'
import App from "@/App.vue";

// 创建一个返回 props 的函数
const getProps = function (route) {
    console.log(route)
    const queryObj = route.query;
    return {
        // query: route.query.q   //URL /search?q=vue 将传递 {query: 'vue'} 作为 props 传给 SearchUser 组件
        // query: route.query.city  // /search?city=zhengzhou     {query: 'zhengzhou'}

        /* 把查询字符串封装成对象 */
        // /search?city=zhengzhou&name=lisi&age=24&ts=1234566778890
        // city: queryObj.city,
        // age: Number(queryObj.age),
        // ts: Number(queryObj.ts)
        queryObj: {
            city: queryObj.city,
            age: Number(queryObj.age),
            ts: Number(queryObj.ts)
        },
        city: queryObj.city,
        age: Number(queryObj.age),
        ts: Number(queryObj.ts)
    }
}

/*  */
const userInfo = {
    username: "zhangsan",
    password: "123456",
    birthday: Date.now().toLocaleString()
}

const routes = [
    {
        path: "/",
        component: App
    },
    {
        path: '/users/:id',
        component: User,
        // props: true //设置 props: true 来配置路由, 将 id 参数作为 prop 传递给组件

        /* 对象模式 */
        props: {
            myProp: userInfo // 会直接将userInfo对象以aaa作为props传递给User组件
        }

        // /* 命名视图 */
        // components: {
        //     default: User,
        //     sidebar: SideBar
        // },
        // /* 分开设置 */
        // props: {
        //     default: true, // 分别设置对应的命名视图
        //     // sidebar: false,
        //     sidebar: true
        // }
    },
    {
        path: '/search',
        component: SearchUser,
        // props: route => ({queryStr: route.query.city}) // 访问 /search?city=zhengzhou&name=lisi&age=24&ts=1234566778890
        // props: route => ({queryObj: route.query}) // 访问 /search?city=zhengzhou&name=lisi&age=24&ts=1234566778890

        props: route => getProps(route)
    }

]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router