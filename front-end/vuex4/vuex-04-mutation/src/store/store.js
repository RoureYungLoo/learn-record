import {createStore} from "vuex";
import {ACCUMULATE_VER_TWO, ADD_ONE, SUB_ONE} from "@/store/mutaion-types.js";
import {ElMessage} from "element-plus";

const store = createStore({
  state: function () {
    return {
      count: 10
    }
  },
  getters: {
    doubleCount(state) {
      return state.count * 2
    }
  },
  /* commit mutation, store.commit('mutationName') */
  /*  mutation 必须是同步函数, 否则会导致devtools出现幻觉 */
  mutations: {
    increment(state) {
      state.count++
    },
    // accumulate: function (state, p1, p2, p3, ...p4) {
    accumulate: function (state, payload) {
      console.log("payload", payload)
      // state.count += p1 + p2 + p3
      console.log(typeof payload)
      // for (let i = 0; i < payload.length; i++) {
      //   state.count += payload[i]
      // }

      for (let i = 0; i < payload.asdf.length; i++) {
        state.count += payload.asdf[i]
      }
      console.log(state.count)
    },
    /* 使用常量定义mutation事件类型 */
    [SUB_ONE](state, delta) {
      state.count -= delta
    },
    [ADD_ONE](state, delta) {
      state.count += delta

    },
    [ACCUMULATE_VER_TWO](state, payload) {
      console.log("payload", payload)
      state.count += payload.age
      state.count += payload.score
    },

    ["forTest"](state, payload) {
      console.log(state)
      console.log(payload)
      ElMessage({
        type: "primary",
        message: "successs"
      })
    }
  }

});

export default store