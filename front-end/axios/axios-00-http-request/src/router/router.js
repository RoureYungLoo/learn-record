import {createRouter, createWebHistory} from "vue-router";

export const router = createRouter(
  {
    history: createWebHistory(),
    routes: [
      {
        path: '/',
        component: () => import('@/views/Home.vue')
      },
      {
        path: '/home',
        component: () => import('@/views/Home.vue')
      },
      {
        path: '/user',
        component: () => import('@/views/User.vue')
      },
      {
        path: '/article',
        component: () => import('@/views/Article.vue')
      }

    ]
  }
)