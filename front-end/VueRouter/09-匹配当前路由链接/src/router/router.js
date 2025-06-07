import {createRouter, createWebHashHistory, createWebHistory} from "vue-router";
import User from "@/components/User.vue";
import Role from "@/components/Role.vue";
import Home from "@/components/Home.vue";


const routes = [
    {
        path: "/",
        component: Home
    }
    ,
    {
        path: "/user/:username",
        component: User,
        children: [
            {
                path: "role/:roleId",
                component: Role
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
    /* 自定义激活的路由链接 CSS 类名 */
    linkActiveClass: 'current-link-active',
    linkExactActiveClass: 'current-link-active-active'
})

export default router