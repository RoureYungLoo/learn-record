import {createMemoryHistory, createRouter, createWebHashHistory, createWebHistory} from "vue-router";
import Page1 from "@/views/Page1.vue";
import Page2 from "@/views/Page2.vue";
import Page3 from "@/views/Page3.vue";
import Page4 from "@/views/Page4.vue";
import Home from "@/views/Home.vue";
import NotFound from "@/views/NotFound.vue";

const routes = [
    {
        path: "/",
        component: Home,
        children: [
            {
                path: "/page1",
                component: Page1
            },
            {
                path: "/page2",
                component: Page2
            },
            {
                path: "/page3",
                component: Page3
            },
            {
                path: "/page4",
                component: Page4
            }
        ]
    },
    /* 配置 404 路由 */
    {
        path: "/:notFound(.*)",
        component: NotFound
    }

]

export const router = createRouter({
    history: createWebHistory(), // 推荐使用H5模式
    // history: createWebHashHistory(),
    // history: createMemoryHistory(),
    routes
})