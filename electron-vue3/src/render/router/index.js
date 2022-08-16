// import { staticRouter } from "./static.router.js"
export const routes = [
  {
    path:"/",
    redirect:"/welcome"
  },
  { path: '/', component: () => import('../views/home/index.vue'), meta: { title: 'Home' } },
  {
    path:"/welcome",
    component:()=>import('../views/welcome/index.vue'),
  }
]
import { createRouter, createWebHistory } from 'vue-router'

export const routerInstall = app => {
  console.log(app);
  const router = createRouter({
    history: createWebHistory(),
    routes,
    mode: 'hash',
  })
  app.use(router)
}