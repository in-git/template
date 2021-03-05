import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    redirect: "/login",
  },
  // 主页,该页面包含所有业务逻辑,通过菜单展示
  {
    path: "/home",
    name: "home",
    component: () => import("@/views/modules/home/home.vue"),
    children: [
      // 默认跳转
      {
        path: "/",
        redirect: "/home/index",
      },
      // 主业务界面
      {
        path: "/home/index",
        name: "index",
        component: () => import("@/views/modules/home/index/index.vue"),
      },

      // 页面配置
      {
        path: "/home/setting",
        name: "setting",
        component: () => import("@/views/modules/home/setting/setting.vue"),
      },
    ],
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
    component: () => import("@/views/repository/echarts/echarts.vue"),
  },
  // 富文本编辑器
  {
    path: "/editor",
    name: "editor",
    component: () => import("@/views/repository/editor/editor.vue"),
  },
  // 测试页面,所有适应所有环境
  {
    path: "/test",
    name: "test",
    component: () => import("@/views/modules/common/test/test.vue"),
  },
  // 系统维护界面
  {
    path: "/maintenance",
    name: "maintenance",
    component: () =>
      import("@/views/modules/common/maintenance/maintenance.vue"),
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
