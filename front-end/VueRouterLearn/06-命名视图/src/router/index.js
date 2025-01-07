import {createRouter, createMemoryHistory} from 'vue-router'
import LeftSidebar from '@/components/LeftSidebar.vue'
import RightSidebar from '@/components/RightSidebar.vue'
import MainContent from '@/components/MainContent.vue'
import UserSettings from '@/components/UserSettings.vue'
import UserEmail from '@/components/UserEmail.vue'
import UserProfile from '@/components/UserProfile.vue'
import UserProfilePreview from '@/components/UserProfilePreview.vue'
import Home from '@/components/Home.vue'

const routes = [
    // {
    //     path: '/',
    //     // component: ()=>import('@/components/Home.vue')
    //     components: {
    //         // default: ()=>import('@/components/Home.vue'),
    //         default: MainContent,
    //         LeftSidebar: LeftSidebar,
    //         RightSidebar: RightSidebar
    //     }
    //
    // }

    {
        path: "/",
        component: Home
    },
    {
        path: '/settings',
        component: UserSettings,
        children: [
            {
                path: 'emails',
                component: UserEmail
            },
            {
                path: 'profile',
                components:{
                    default:UserProfile,
                    helper: UserProfilePreview
                }
            }
        ]


    }
]

const router = createRouter({
    history: createMemoryHistory(),
    routes: routes
})
export default router