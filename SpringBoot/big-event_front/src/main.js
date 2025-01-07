// import "./assets/main.css";

import { createApp } from "vue";
import App from "./App.vue";
import ElementPlus from "element-plus";
import locale from "element-plus/dist/locale/zh-cn.js";
import "element-plus/dist/index.css";
import router from "@/router/index.js";

import { createPinia } from "pinia";
import { createPersistedState } from "pinia-persistedstate-plugin";

const app = createApp(App);
const pinia = createPinia();

const persist = createPersistedState();
pinia.use(persist);

app.use(ElementPlus, { locale });
app.use(router);
app.use(pinia);
app.mount("#app");
