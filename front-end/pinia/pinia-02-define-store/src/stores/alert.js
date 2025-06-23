import {defineStore} from "pinia";

/* 选项式API */
const useAlertStore = defineStore('alert', {
  // state: function () {
  //   return {
  //     msg: "Warning!"
  //   }
  // },
  state: () => ({msg: "Warning!"}),
  getters: {
    doubleMsg(state) {
      return state.msg.repeat(2)
    }
  },
  actions: {
    toUpper() {
      this.msg = this.msg.toUpperCase()
    },
    toLower() {
      this.msg = this.msg.toLowerCase()
    },
    double() {
      this.msg = this.msg.repeat(2)
    },
    reverse() {
      this.msg = [...this.msg].reverse().join('')
    }
  }
});

export default useAlertStore