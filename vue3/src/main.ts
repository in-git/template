import { createApp } from "vue";
import router from "./router";

import piniaPersist from 'pinia-plugin-persist'
import { createPinia } from "pinia";

import App from "@/App.vue";
import "in-less";

const pinia = createPinia()
const app = createApp(App);

pinia.use(piniaPersist);

/* 导入本地组件 */
import myComponent from "./components/index"

app.use(myComponent);
app.use(router);
app.use(pinia);
app.mount("#app");