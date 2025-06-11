import {createRouter, createWebHistory} from "vue-router";
import Post from "@/components/Post.vue";
import Post2 from "@/components/Post2.vue";


const routes = [
    {
        path: "/post/:id",
        component: Post
    }, {
        path: "/post2/:id",
        component: Post2
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router