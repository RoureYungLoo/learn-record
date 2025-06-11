import {createRouter, createWebHashHistory, createWebHistory} from "vue-router";
import PostLayout from "@/views/PostLayout.vue";
import PostNew from "@/views/PostNew.vue";
import PostsDetail from "@/views/PostsDetail.vue";

const routes = [
    {
        path: "/posts",
        component: PostLayout,
        meta: {
            attr: "Post布局页面",
            data: [
                {attr1: "value1"},
                {attr2: "value2"},
            ]
        },
        children: [
            {
                path: "new",
                component: PostNew,
                /* 路由元信息 */
                meta: {
                    requiresAuth: true,
                    currentPage: "新建页面"
                }
            },
            {
                path: ":id",
                component: PostsDetail,
                meta: {
                    requiresAuth: false,
                    currentPage: "详情页"
                }
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach((to, from) => {
    console.log("from", from)
    console.log("to", to)

})

export default router