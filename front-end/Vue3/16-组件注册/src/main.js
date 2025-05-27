import {
	createApp
} from 'vue'
import App from './App.vue'
import ComponentA from './components/ComponentA.vue'
// import ComponentB from './components/ComponentB.vue'
// import ComponentC from './components/ComponentC.vue'


const app = createApp(App)

/* 全局注册组件 */
app.component(
	'MyComponent', {
		data() {
			return {
				msg: "全局注册组件"
			}
		},
		template: `<div><h3>{{msg}}</h3></div>`
	}
)

/* 全局注册组件 */
app.component('ComponentA',ComponentA)
	// .component("ComponentB",ComponentB)
// app.component('ComponentB',ComponentB)
// app.component('ComponentC',ComponentC)

app.mount('#app')