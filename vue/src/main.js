import App from "./App.vue";
import router from "./router/router.js";
import Vue from "vue";
import axios from "./http/module/index.js";
import store from "./store";
import components from "./components/index";
import directives from "./components/directives";

Vue.use(components);
Vue.use(directives);
Vue.use(router);
Vue.prototype.$http = axios;
Vue.prototype.$store = store;
Vue.prototype.$bus = new Vue();
import "in-less";
Vue.config.productionTip = false;

new Vue({
  router,
  $vue: Vue,
  store,
  render: (h) => h(App),
}).$mount("#app");
