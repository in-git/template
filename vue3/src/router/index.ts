import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/home",
    name: "home",
    component: () => import(/* webpackChunkName: "Home" */ "@/views/Home.vue")
  },
  { path: "/", redirect: { name: "home" } }
];

const router = createRouter({
  // history 模式,hash模式:createWebHashHistory()
  history: createWebHashHistory(),
  routes
});

export default router;
