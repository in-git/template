import copy from './copy'
import longpress from './longpress'
import debounce from './debounce'
import tips from './tips'
// 自定义指令
const directives = {
  copy,
  longpress,
  debounce,
  tips
}

export default {
  install(Vue) {
    Object.keys(directives).forEach((key) => {
      Vue.directive(key, directives[key])
    })
  },
}
