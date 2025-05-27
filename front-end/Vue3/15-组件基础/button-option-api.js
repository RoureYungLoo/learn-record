import {ref} from "vue";

/* 不使用脚手架构建步骤, 组件定义: 导出js对象  */
export default {
    name: "ButtonOptionApi",
    setup() {
        const counter = ref(0)
        return {
            counter
        }
    },
    template: `
      <button @click="counter++">点击了{{ counter }}次</button>
    `
}