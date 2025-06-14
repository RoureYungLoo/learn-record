import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('@/views/Home.vue')
        }, {
            path: "/article/:articleName",
            name: 'article',
            component: () => import('@/views/Article.vue')
        }, /*{
            path: "/about/:id",
            name: "about",
            component: () => import('@/views/About.vue')
        },*/
        {
            path: "/about",
            name: "about",
            component: () => import('@/views/About.vue')
        }
    ],
})


function exist(to) {
    let b = router.hasRoute(to.name);
    // console.log("myHasRoute: ", to)
    console.log("gen(to): ", generateRoute(to))
    console.log(b ? "路由已存在" : "路由不存在")
    return b;
}

/* 生成路由信息对象 */
function generateRoute(to) {
    let name = to.fullPath.substring(1)
    return {
        path: to.fullPath,
        name,
        component: () => import('/src/views/' + name + '.vue')
    };
}

router.beforeEach(to => {
    // console.log("beforeEach： ", to)
    // if (!exist(to)) {
    //     router.addRoute(generateRoute(to))
    //     return to.fullPath
    // }

    return true
})
export default router
