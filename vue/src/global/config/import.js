// 此文件用于挂载自定义vue插件
import Vue from 'vue'
import toastRegistry from '@/views/extend/index'
Vue.use(toastRegistry)
export default Vue