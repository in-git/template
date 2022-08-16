import { App } from 'vue';
const components = import.meta.globEager('./**/*.vue');

export default {
    install(app: App) {
        Object.keys(components).forEach(component => {
            /* 匹配 介于 / 和 . 之间的值 */
            var _match_ = component.match(/.*\/(.*)\./);
            if (_match_) {
                var componentsName = _match_[1]
                app.component(componentsName, components[component].default)
            }
        })
    }
}