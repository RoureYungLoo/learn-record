// import "./assets/main.css";

import { createApp } from "vue";
import App from "./App.vue";
import ElementPlus from "element-plus";
import locale from 'element-plus/dist/locale/zh-cn.js'
import "element-plus/dist/index.css";


const app = createApp(App);


app.use(ElementPlus,{locale});
app.mount("#app");

