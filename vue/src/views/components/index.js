import component from "./component/component.vue";
const components = [component];

const install = function(Vue) {
  // 判断是否安装
  if (install.installed) return;
  // 遍历注册全局组件
  components.map((component) => Vue.component(component.name, component));
};

if (typeof window !== "undefined" && window.Vue) {
  install(window.Vue);
}
//第一个参数是用于安装所有组件，第二个参数是用于单个组件引入
export default {install,component};
