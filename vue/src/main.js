import Vue from 'vue'
import App from './App.vue'
import router from './global/router'
import vuetify from './global/plugins/vuetify';
import api from './global/request/api'
import 'vuetify/dist/vuetify.min.css'
Vue.prototype.$api = api
Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
