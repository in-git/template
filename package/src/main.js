import Vue from 'vue'
import App from './App.vue'
import wui from "../packages/button/index"
Vue.use(wui)
Vue.config.productionTip = false

new Vue({
  render: function (h) { return h(App) },
}).$mount('#app')
