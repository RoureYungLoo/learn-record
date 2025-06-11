import {createRouter, createWebHistory} from "vue-router";
import Home from "@/views/Home.vue";
import Post from "@/views/Post.vue";

const routes = [
    {
        path: "/",
        component: Home
    },
    {
        path: "/posts/:id",
        component: Post,
        meta: {
            randomData: Math.floor(Math.random() * 10000).toString(32)
        }
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

/* 导航守卫 */


export default router