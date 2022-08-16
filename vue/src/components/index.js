import showToast from './toast'
import showKeyBoard from './keyboard'
import contextMenu from "./contextmenu/index.vue"
const components = [showToast, showKeyBoard, contextMenu]

export default {
    install(Vue) {
        components.forEach(component => {
            Vue.component(component.name, component)
        })
    }
}