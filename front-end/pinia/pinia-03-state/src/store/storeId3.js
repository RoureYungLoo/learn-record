import {defineStore} from "pinia";
import {ref} from "vue";


const useStoreId3Store = defineStore('storeId3', () => {
  const count = ref(1)

  function $reset() {
    count.value = 0
    console.log("useStoreId3Store has been reset.")
  }

  return {
    count, $reset
  }
});

export default useStoreId3Store