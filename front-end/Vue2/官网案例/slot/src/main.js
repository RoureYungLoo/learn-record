import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false


// const AlertBox = "AlertBox"

/* You are using the runtime-only build of Vue where the template compiler is not available. */
// const options = {
//     template: `
//   <div>
//     <strong>Error!</strong>
//     <slot></slot>
//   </div>
//   `
// }


// Vue.component(AlertBox, options)

new Vue({
    render: h => h(App),
}).$mount('#app')
