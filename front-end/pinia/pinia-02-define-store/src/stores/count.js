import {defineStore} from "pinia";
import {computed, inject, ref, toValue} from "vue";


// defineStore('count', () => {
//
// })


const useCountStore = defineStore('count', function () {
  const count = ref(0)
  const name = ref(genStr())
  const doubleCount = computed(() => count.value * 2)

  function increment() {
    count.value++
  }

  const decrement = function () {
    count.value++
  }

  const getNewName = () => {
    name.value = genStr()
  }

  const inject1 = inject('user');
  const user = computed(() => {
    return toValue(inject1)
  })

  return {
    name, count, doubleCount,user,
    increment, decrement, getNewName
  }
})

function genStr() {
  return Math.floor(Math.random() * 1000000).toString(16)
}

export default useCountStore