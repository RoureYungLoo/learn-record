import {defineStore} from "pinia";

export const useTodos = defineStore('todos', {
    state: () => ({
        todos: [],
        filter: "all",
        nextId: 0
    }),
    getters: {
        finishedTodos(state) {
            return state.todos.filter((todo => todo.isFinished))
        },
        unfinishedTodos(state) {
            return state.todos.filter((todo => !todo.isFinished))
        },
        filteredTodos(state) {
            if (this.filter === 'finished') {
                return this.finishedTodos
            } else if (this.filter === 'unfinished') {
                return this.unfinishedTodos
            }
            return this.todos
        },
    },
    actions: {
        addTodo(text) {
            this.todos.push({
                text,
                id: this.nextId++,
                isFinished: false
            })
        },
        updateTodo(id) {
            this.todos.filter(todo => {
                if (todo.id === id) {
                    todo.isFinished = !todo.isFinished
                }
            })
        },
        removeTodo(id) {
            this.todos = this.todos.filter(todo => todo.id != id)
        }
    }
})