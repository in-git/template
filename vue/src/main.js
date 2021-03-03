import Vue from '@/global/config/use.js'
import App from './App.vue'
import router from './global/router'
import vuetify from './global/config/vuetify';
import api from './global/request/api'
import 'vuetify/dist/vuetify.min.css'
import echarts from 'echarts'
Vue.prototype.$echarts = echarts;

Vue.prototype.$api = api
Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
