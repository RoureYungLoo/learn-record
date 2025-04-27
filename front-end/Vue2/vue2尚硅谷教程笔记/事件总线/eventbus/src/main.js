import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

// const _switcher = Vue.extend({})
// const switcher = new _switcher()

// // x 作为中转组件，供Cpt1 Cpt2进行通信
// Vue.prototype.x = switcher

new Vue({
	render: h => h(App),
	mounted() {
		console.log("main.js:", this);
	},

	// 安装全局事件总线BUS
	beforeCreate() {
		Vue.prototype.$bus = this
	}
}).$mount('#app')