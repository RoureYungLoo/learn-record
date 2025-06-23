import {defineStore} from "pinia";

/* 使用选项式 API 定义 store */
export const useCounterStore = defineStore('counter', {
  state: () => ({
    count: 0
  }),
  getters: {
    doubleCount: (state) => state.count * 2,
    doubleCount2(state) {
      return state.count * 2
    },

    /**
     * @returns {number} 指定返回值类型为 number
     */

    /* 在getter中访问其他getter需要指明返回值类型 */
    doublePlusOne() {
      return this.doubleCount + 1
    }

  }
})

export const useUserListStore = defineStore('userlist', {
  state: () => ({
    users: [
      {
        id: 1001,
        name: "lisi1",
        active: true,
      }, {
        id: 1002,
        name: "lisi2",
        active: true,

      }, {
        id: 1003,
        name: "lisi3",
        active: true,

      }, {
        id: 1004,
        name: "lisi4",
        active: false,

      }, {
        id: 1005,
        name: "lisi5",
        active: false,

      },
    ]
  }),
  getters: {
    /* 向getter传参, 通过返回一个接收参数的函数实现
    * 这种方式将不会再缓存getter
    *  */
    getUserById: (state) => {
      return (userId) => {
        return state.users.find((user) => user.id === userId)
      }
    },

    getActiveUserById: (state) => {

      /* 缓存中间结果 */
      const activeUsers = state.users.filter((user) => user.active);
      return (userId) => {
        return activeUsers.find((user) => user.id === userId)
      }
    }
  }
})

/* 使用其他 store 的 getter */
export const useOtherStore = defineStore('other', {
  state: () => ({
    source: 'otherStore'
  }),
  getters: {
    getInfo(state) {
      const counterStore = useCounterStore();
      const userListStore = useUserListStore();
      return `from ${state.source}, count: ${counterStore.doublePlusOne}, userInfo: ${JSON.stringify(userListStore.getUserById(1003))}`
    }
  }
})

/* 使用 setup 语法 */
