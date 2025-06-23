import {defineStore} from "pinia";
import {ref} from "vue";

export const useUserStore = defineStore('user', () => {
  const username = ref('lisi')
  const age = ref(23)

  function $reset() {
    username.value = 'lisi'
    age.value = 23
    console.log('reset userStore')
  }

  return {
    username, age, $reset
  }
})