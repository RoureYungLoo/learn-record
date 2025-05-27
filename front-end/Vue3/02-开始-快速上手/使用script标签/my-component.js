import {ref} from 'vue'

/* Vue 选项配置 */
// const options = {
export default {
    setup() {
        // const message = ref("Hello Vue")
        const count = ref(0)

        /* 返回一个对象 */
        return {
            // message
            count
        }
    },
    template: `
      <div @click="count++">Count is: {{ count }}</div>`
}