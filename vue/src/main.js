import Vue from 'vue'
import App from './App.vue'
import router from './plugins/router'

/* ------ ············ ------ */
/* -------- Vuetify ---------*/
import vuetify from '@/plugins/vuetify.js'
Vue.use(vuetify)
/* ------ ············ ------ */
/* ------ ············ ------ */

/* ------ ············ ------ */
/* ------- Axios依赖
/* ------ ············ ------ */
import {
	post,
	get,
	patch,
	put
} from '@/plugins/axios.js'
Vue.prototype.$post = post;
Vue.prototype.$get = get;
Vue.prototype.$patch = patch;
Vue.prototype.$put = put;



Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
