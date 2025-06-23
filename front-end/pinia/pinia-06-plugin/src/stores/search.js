import {defineStore} from "pinia";

/* 选项式API */
/*export const useSearchStore = defineStore('search', {
  actions: {
    searchContacts() {
      console.log("searchContacts 被调用 了")
    }
  },

  /!* 定义新的选项 *!/
  debounce: {
    searchContacts: 300
  }
})*/

/* 组合式API */
export const useSearchStore = defineStore(
  'search',
  () => {
    function searchContacts() {
      console.log("searchContacts 被调用 了")
    }

    return {
      searchContacts
    }
  },
  { // 第三个参数是自定义选项
    debounce: {
      searchContacts: 300, // 防抖300ms
    }
  })