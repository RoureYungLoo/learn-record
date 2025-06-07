import HomeView from "@/views/HomeView.vue";
import AboutView from "@/views/AboutView.vue";
import {createMemoryHistory, createRouter, createWebHashHistory, createWebHistory} from "vue-router";

const routes = [
    {
        path: '/', component: HomeView,
    },
    {
        path: "/about", component: AboutView
    }

]

const router = createRouter({
    history: createWebHistory(),
    // history: createWebHashHistory(),
    // history: createMemoryHistory(),
    routes
})

export default router