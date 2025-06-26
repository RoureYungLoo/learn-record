import {createStore} from "vuex";

/* 创建 store  */
export const store = createStore({
  /* store 的 state */
  state() {
    return {
      count: 0,
      age: 45,
      address: 'zhengzhou'
    }
  },
  mutations: {
    increment(state) {
      state.count++
    },
    decrement(state) {
      state.count--
    },
  }
});