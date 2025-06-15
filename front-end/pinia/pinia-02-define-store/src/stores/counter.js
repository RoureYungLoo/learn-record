import {defineStore} from "pinia";

/* 选项式API */
const useCounterStore = defineStore('counter', {
  state: function () {
    return {
      counter: 0
    }
  },
  getters: {
    doubleCounter(state) {
      return state.counter * 2
    }
  },
  actions: {
    grow(step = 1) {
      this.counter += step
    }
  }
})

export default useCounterStore