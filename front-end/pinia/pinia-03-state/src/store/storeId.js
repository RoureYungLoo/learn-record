import {defineStore} from "pinia";

/* 使用 选项式 store */
const useStoreIdStore = defineStore('storeId', {
  state: () => {
    return {
      count: 0,
      name: Math.floor(Math.random() * 10000000000).toString(16),
      isAdmin: true,
      items: [],
      hasChanged: true
    }
  },
});
export default useStoreIdStore
