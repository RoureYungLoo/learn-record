/* 模块分割, 防止状态树过于庞大复杂 */

import {createStore} from "vuex";

const moduleA = {
  state: () => {
    return {
      msg: "module a",
      count: 10
    }
  },
  getters: {
    dbCount: (state) => {
      console.log("dbCount", state)
      return state.count * 2
    }
  },
  mutations: {
    increment(state) {
      console.log("increment", state)
      state.count++
    },
    testMutationInA(state) {
      console.log("call testMutationA")
    },
    sameMutation(state) {
      console.log("sameMutation in mudule A")
    }
  },
  actions: {
    incrementOnOdd(context) {
      console.log(context)
      if ((context.state.count + context.rootState.rootCount) % 2 === 1) {
        context.commit('increment')
      }
    },
    testActionInA(state) {
      console.log("call testMutationA")
    },
    sameAction(state) {
      console.log("sameAction in module A")
    }
  },
}

const moduleB = {
  state: () => {
    return {
      msg: "module b"
    }
  },
  mutations: {
    testMutationInB(state) {
      console.log("call testMutationB")
    },
    sameMutation(state) {
      console.log("sameMutation in mudule B")
    }
  },
  actions: {
    testActionInB(state) {
      console.log("call testMutationB")
    },
    sameAction(state) {
      console.log("sameAction in module B")
    }
  },
  getters: {}
}

const store = createStore({
  state: () => ({
    rootCount: 999
  }),
  getters: {
    rootGetter(state) {
      console.log("rootGetter")
      return "root getter"
    }
  },
  mutations: {
    login() {
      console.log("root mutation login()")
    }
  },
  actions: {
    login() {
      console.log("root action login()")
    }
  },
  modules: {
    mA: moduleA,
    mB: moduleB,
    /* 命名空间 namespace */
    account: {
      namespaced: true,
      state: () => ({amount: 1000}),
      getters: {
        isAdmin() {
          console.log("isAdmin")
          return 'isAdmin' + Date.now()
        },
        someGetter(state, getters, rootState, rootGetters) {
          console.log("someGetter")
          console.log(state)
          console.log(getters)
          console.log(rootState) // 访问全局state
          console.log(rootGetters) // 访问全局 getter
          return Date.now().toString(16)
        }
      },
      actions: {
        login() {
          console.log("local action: login")
        },
        // someAction(context) {
        //   console.log("someAction")
        //   console.log(JSON.stringify(context))
        // }
        someAction({commit, dispatch, getters, rootGetters}) {
          console.log("someAction")
          /* dispatch 局部 action */
          dispatch('login')
          /* commit 局部 mutation */
          commit('login')
          /* dispatch 全局 action */
          dispatch('login', null, {root: true})
          /* commit 全局 mutation */
          commit('login', null, {root: true})
        },
        sayHi() {
          console.log("call sayHi ")
        },
        /* 在命名空间内注册全局 action */
        globalActionInAccount: {
          root: true,
          handler(namespaceCountext, payload) {
            console.log(namespaceCountext)
            console.log(payload)
          }
        }
      },
      mutations: {
        login() {
          console.log("local mutations: login")
        }
      },
      /* 嵌套模块 */
      modules: {
        /* 继承命名空间 */
        myPage: {
          state: () => ({}),
          getters: {
            profile() {
              console.log("myPage getters: profile()")
              return "myPage getters: profile()"
            }
          },
          actions: {
            pageAction() {
              console.log("pageAction")
            }
          },
          mutations: {
            pageMutation() {
              console.log("pageMutation")
            }
          }

        },
        /* 进一步嵌套 */
        posts: {
          namespaced: true,
          state: () => (
            {
              post_time: Date.now(),
              post_author: "lisi",
              stars: 12,
            }),
          getters: {
            popular() {
              console.log("posts getters popular")
              return "posts getters popular at " + new Date().toLocaleString()
            },
            dbStars(state) {
              return state.stars * 2
            }

          },
          actions: {
            postAction({commit}) {
              console.log("postAction")
              commit('postMutation')
            }
          },
          mutations: {
            postMutation() {
              console.log("postMutation")
            }
          }
        }
      }

    }

  }
})


/* 动态卸载模块 */
// store.unregisterModule()


export default store