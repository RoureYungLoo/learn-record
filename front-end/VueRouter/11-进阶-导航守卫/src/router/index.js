import {createRouter, createWebHistory} from "vue-router";
import Home from "@/views/Home.vue";
import About from "@/views/About.vue";
import Login from "@/views/Login.vue";
import {inject} from "vue";
import UserDetails from "@/views/UserDetails.vue";
import TodoList from "@/views/TodoList.vue";

const removeQueryParams = (to) => {
    if (Object.keys(to.query).length) {
        return {
            path: to.path,
            query: {},
            hash: to.hash
        }
    }
}

const removeHash = (to) => {
    if (to.hash) {
        return {
            path: to.path,
            query: to.query,
            hash: ''
        }
    }

}

const routes = [
    {
        path: "/",
        component: Home
    },
    {
        path: "/about",
        // component: About,
        component: UserDetails,
        beforeEnter: [removeHash]

    }, {
        path: "/login",
        name: 'login',
        component: Login,
        beforeEnter: (to, from) => {
            console.log("路由独享守卫")
            console.log(to);
            console.log(from)
            return true;
        }
    },
    {
        path: "/users/:id",
        component: UserDetails,
        beforeEnter: [removeQueryParams, removeHash]
    },
    {
        path: "/todo/:id",
        component: TodoList
    }

]
const router = createRouter({
    history: createWebHistory(),
    routes
})

/* 全局前置守卫 */
router.beforeEach((to, from) => {
    // console.log("from", from)
    // console.log("to", to)

    // if (to.name != 'login') {
    //     return {
    //         name: 'login'
    //     }
    // }

    return true;
})

/* 错误处理 */
router.onError((err, to, from) => {
    console.log(err)
    console.log(to)
    console.log(from)
})

/* 全局解析守卫 */
router.beforeResolve(to => {
    // console.log(to)
    return true
})

/* 全局后置钩子 */
router.afterEach((to, from, failure) => {
    // console.log(to)
    // console.log(from)
    // console.log(failure)
})

/* 守卫内的全局注入依赖 */
router.beforeEach((to, from) => {
    const global = inject('global');
    // console.log(global)

    /* pinia 获取 */
})
router.beforeResolve((to, from) => {
    const global = inject('global');
    // console.log(global)
})
router.afterEach((to, from) => {
    const global = inject('global');
    // console.log(global)
})


export default router