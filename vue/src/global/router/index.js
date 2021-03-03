import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    redirect: "/login",
  },
  // 主页
  {
    path: "/home",
    name: "home",
    component: () => import("@/views/modules/home/home.vue"),
  },
  // 登陆页面
  {
    path: "/login",
    name: "login",
    component: () => import("@/views/modules/common/login/login.vue"),
  },
  // 图片vue库
  {
    path: "/echarts",
    name: "echarts",
    component: () => import("@/views/modules/repository/echarts/echarts.vue"),
  },
  // 测试页面,所有适应所有环境
  {
    path: "/test",
    name: "test",
    component: () => import("@/views/modules/common/test/test.vue"),
  },
  // 统一错误处理页面
  {
    path: "*",
    name: "error",
    component: () => import("@/views/modules/common/error/error.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
