import {defineStore} from "pinia";
import {computed, ref} from "vue";

/* 使用 setup 语法定义 store */
export const useCountStore = defineStore('count', () => {
  const count = ref(0)
  const name = ref('lisi')
  const doubleCount = computed(() => count.value * 2)
  const doubleName = computed(() => name.value.repeat(2))

  const increment = () => count.value++
  const upperName = () => {
    console.log("upperName")
    name.value.toUpperCase()
  }

  /* 由于没有语法糖,需要手动返回出去 */
  return {
    count, name, doubleCount, doubleName, increment, upperName
  }
})