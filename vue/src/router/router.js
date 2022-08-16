import Vue from "vue";
import VueRouter from "vue-router";
import commonRouter from "./common.js"; //公共路由
Vue.use(VueRouter);
const routes = [...commonRouter];

export default new VueRouter({
  mode: "history",
  // mode: "hash",
  base: process.env.BASE_URL,
  routes,
});
