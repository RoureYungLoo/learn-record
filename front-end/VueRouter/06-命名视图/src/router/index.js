import {createRouter, createMemoryHistory, createWebHistory} from 'vue-router'
import LeftSidebar from '@/components/LeftSidebar.vue'
import RightSidebar from '@/components/RightSidebar.vue'
import MainContent from '@/components/MainContent.vue'
import UserSettings from '@/components/UserSettings.vue'
import UserEmail from '@/components/UserEmail.vue'
import UserProfile from '@/components/UserProfile.vue'
import UserProfilePreview from '@/components/UserProfilePreview.vue'
import Home from '@/components/Home.vue'

const routes = [
    {
        path: '/',
        // component: ()=>import('@/components/Home.vue')
        components: {
            // default: ()=>import('@/components/Home.vue'),
            default: MainContent,
            LeftSidebar: LeftSidebar,
            RightSidebar: RightSidebar
            // router view name: 组件
        }

    },

    // {
    //     path: "/",
    //     component: Home
    // },

    /* 嵌套的命名视图 */
    {
        path: '/settings',
        component: UserSettings,
        children: [
            {
                path: 'emails',
                component: UserEmail //  /settings/emails
            },
            {
                path: 'profile',  // /settings/profile
                components:{
                    default:UserProfile,
                    helper: UserProfilePreview
                }
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})
export default router