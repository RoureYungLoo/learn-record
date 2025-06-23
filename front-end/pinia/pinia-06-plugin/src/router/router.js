import {createRouter, createWebHistory} from "vue-router";

export const router = createRouter(
  {
    history: createWebHistory(),
    routes: [
      {
        path: '/articles',
        component: () => import('@/views/Article.vue')
      }, {
        path: '/posts',
        component: () => import('@/views/Post.vue')
      }
    ]
  }
)