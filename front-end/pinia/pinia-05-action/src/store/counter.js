import {defineStore} from "pinia";
import {computed, ref} from "vue";
import axios from "axios";

/* 使用选项式 API 定义 store */
export const useCounterStore = defineStore('counter', {
  state: () => ({
    count: 10
  }),
  getters: {
    double: (state) => state.count * 2
  },
  actions: {
    increment() {
      this.count++
    },
    decrement() {
      this.count--
    },
    plusANumber(number) {
      console.log("number ", number)
      this.count += number
    },
    async loadData(params) {
      return await axios.get('http://localhost/preferences').then((res) => {
        return res.data
      }).catch((err) => {
        return err
      })
    }
  }
})


/* 使用 组合式 API 定义store */
// export const useCounterStore = defineStore('counter', function () {
//   const count = ref(15)
//   const double = computed(() => count.value * 2)
//
//   function increment() {
//     count.value++
//   }
//   function decrement() {
//     count.value--
//   }
//
//   return {
//     count, double, increment
//   }
// })