import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [{
		redirect: {name: 'home'},
		path: '/'
	},
	{
		path: '/home',
		name: 'home',
		component: () => import('@/views/index/Home.vue')
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

export default router
