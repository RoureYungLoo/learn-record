import {createStore} from "vuex";
import {ElMessage} from "element-plus";
import {getData, getOtherData} from "@/store/data.js";

export const store = createStore({
  state() {
    return {
      count: 0
    }
  },
  getters: {
    dbCount: (state) => {
      return state.count * 2
    }
  },
  mutations: {
    increment(state) {
      state.count++
      console.log("call mutations.increment()")
    },
    decrement(state, payload) {
      // state.count -= payload
      // state.count -= payload.delta
      state.count -= payload.payload.delta
      console.log(`call mutations.decrement() with payload ${JSON.stringify(payload)}`)
    },
    gotData(state, payload) {
      console.log(`call mutations.gotData() with payload ${JSON.stringify(payload)}`)
    },
    gotOtherData(state, payload) {
      console.log(`call mutations.gotOtherData() with payload ${JSON.stringify(payload)}`)
    }

  },
  /* 1. 可以是异步的
  * 2. action 提交 mutation, 不直接改变 state */
  actions: {
    addOne(context) {
      console.log("context", context)
      context.commit('increment')
    },
    addOne2({commit}) {
      console.log("context", commit)
      // commit('increment')

      /* 异步分发 */
      setTimeout(() => {
        // commit('increment')

        /* 传递简单参数 */
        // commit('decrement', 10)

        /* 传递对象参数 */
        // commit('decrement', {delta: 10})

        /* 对象形式commit */
        commit({
          type: 'decrement',
          payload: {
            delta: 10,
            others: [{}]
          }
        })
      }, 1000)
    },
    /* 异步Action, 组合Action */
    actionA({commit}) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          commit('increment')
          resolve(`-- in actionA commit('increment') success `)
        }, 1000)
      })
    },
    actionB({commit, dispatch}) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          dispatch('actionA').then(res => {
            commit('decrement', {payload: {delta: 2}})
            resolve(`- in actionC, dispatch('actionA') success`)
          })
        }, 1000)
      })
    },
    actionC({dispatch, commit}) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          dispatch('actionB').then(res => {
            ElMessage({
              type: "primary",
              message: "all is done"
            })
            resolve(`-- in actionC ,  dispatch(actionB) success`)
          })
        }, 1000)
      })
    },

    /*使用 async await */
    async actionD({commit}) {
      commit('gotData', await getData())
    },
    async ActionE({dispatch, commit}) {
      await dispatch('actionD') // 等待actionD完成
      commit('gotOtherData', await getOtherData())
    }
  }
})
