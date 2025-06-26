import {createStore} from "vuex";

/* 定义 store */
export const store = createStore({
  /* store 的 state (类似响应式状态) */
  state() {
    let todos = []
    for (let i = 0; i < 15; i++) {
      todos.push(
        {
          id: 100000 + i,
          text: Math.floor(Math.random() * 1000000000).toString(16),
          done: true
        }
      )
    }
    return {
      todos
    }
  },
  /* store 的 getter (类似计算属性) */
  getters: {
    doneTodos(state) {
      return state.todos.filter(todo => todo.done)
    },
    doneCount(state, getters) {
      // return store.getters.doneTodos.length
      return getters.doneTodos.length
    },
    undoneCount(state) {
      return state.todos.filter(todo => !todo.done).length
    },
    // 给 getter 传参
    getTodoById: (state) => (todoId) => {
      return state.todos.find(todo => todo.id === todoId)
    }
  }
})