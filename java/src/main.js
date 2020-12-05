import Vue from 'vue'
import App from './App.vue'
import router from './plugins/router'


/* ------ ············ ------ */
/* ------- ant ui
/* ------ ············ ------ */
import Antd from 'ant-design-vue';
Vue.use(Antd);
import 'ant-design-vue/dist/antd.css';

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
