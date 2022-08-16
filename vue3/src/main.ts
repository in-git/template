import { createApp } from "vue";
import router from "./router";

import piniaPersist from 'pinia-plugin-persist'
import { createPinia } from "pinia";

import App from "@/App.vue";
import "normalize.css";

const pinia = createPinia()
const app = createApp(App);

app.config.globalProperties.test = "1232"
pinia.use(piniaPersist);

// 通用字体
import 'vfonts/Lato.css'
// 等宽字体
import 'vfonts/FiraCode.css'

/* 导入本地组件 */
import myComponent from "./components/index"

app.use(myComponent);
app.use(router);
app.use(pinia);
app.mount("#app");