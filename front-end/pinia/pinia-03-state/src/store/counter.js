import {defineStore} from "pinia";
import {ref} from "vue";

const useCounterStore = defineStore('counter', () => {
  const count = ref(100)
  const nickname = ref('lisi')
  const weight = ref(20.5)
  const height = ref(175.5)

  function $reset() {
    count.value = 38
    nickname.value = 'zhangsan'
    weight.value = 38.5
    height.value = 155.6
    console.log("$reset执行了")
  }

  return {
    count, nickname, weight, height, $reset
  }
})

/*const useCounterStore = defineStore('counter', {
  state: () => ({
    count: 100,
    nickname: "lisi",
    weight: 20.5,
    height: 175.5,
    items:[]
  })
});*/

export default useCounterStore