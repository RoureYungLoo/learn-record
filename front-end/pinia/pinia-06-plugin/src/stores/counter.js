import {defineStore} from "pinia";
import {ref} from "vue";

export const useCounterStore = defineStore('counter', () => {
  const count = ref(11)
  const increment = () => {
    count.value++
  }

  function $reset() {
    count.value = 11
  }

  return {
    count, increment, $reset
  }
})