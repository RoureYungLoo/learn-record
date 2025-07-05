
import {createApp} from 'vue'
import App from './App.vue'
import {createStore} from "vuex";

const store = createStore({
  state() {
    return {
      count: 0
    }
  },
  mutations: {
    increment(state) {
      state.count++
    }
  }
})

// import {store} from "@/store/counter.js";

const app = createApp(App);
app.use(store)
app.mount('#app')

console.log(store)
