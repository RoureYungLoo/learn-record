import {defineStore} from "pinia";
import {ref} from "vue";
import axios from "axios";

export const useUserStore = defineStore('user', () => {

})

export const useSettingsStore = defineStore('settings', {
  state: () => ({
    preferences: null
  }),
  getters: {},
  actions: {
    async fetchPreferences() {
      /* 使用另外一个 store : useAuthStore */
      const authStore = useAuthStore();

      /* 模拟用户认证 */
      if (confirm("是否继续?")) {
        authStore.checkAuth()
      } else {
        console.log("用户取消认证")
      }

      if (authStore.authenticated) {
        this.preferences = await axios.get('http://localhost/preferences').then(res => {
          return res.data
        })
        console.log("已认证")
      } else {
        console.log("未认证")
        throw new Error('用户未认证')
      }
    }
  }
})


/* 这是另外一个 store */
export const useAuthStore = defineStore('auth', () => {
  const authenticated = ref(false)

  function checkAuth() {
    authenticated.value = true
    console.log("useAuthStore: checkAuth()")
  }

  return {
    authenticated, checkAuth
  }
})