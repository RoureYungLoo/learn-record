import Home from "@/views/Home.vue";
import {createRouter, createWebHistory} from "vue-router";
import Post from "@/views/Post.vue";
import Article from "@/views/Article.vue";

const routes = [
    {
        path: "/",
        component: Home
    },
    {
        path: "/home",
        component: Home,
        /* 在路由元信息中配置过渡效果 */
        meta: {
            // transition: "fade"
        }
    }, {
        path: "/post",
        component: Post,
        meta: {
            // transition: "slide-up"
        }
    }, {
        path: "/article/:id",
        component: Article,
        meta: {
            // transition: "slide-fade"
        }
    },
]

const router = createRouter({
    history: createWebHistory(
    ),
    routes
})

/* 路由守卫 */
router.afterEach((to, from, failure) => {
    // console.log("from", from)
    /* 根据路由动态配置过渡效果 */
    const toDepth = to.path.split("/").length
    const fromDepth = from.path.split("/").length
    if (toDepth < fromDepth) {
        to.meta.transition = "slide-up"
    } else {
        to.meta.transition = "slide-fade"
    }

    console.log("to", to)

})

export default router