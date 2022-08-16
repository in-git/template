import vue from 'vue'

// 导入自定义到Toast组件
import Toast from './index.vue'


// 生成一个扩展实例构造器
const ToastConstructor = vue.extend(Toast);

// 定义弹出组件的函数 接收三个参数 消息 toast类型 显示时间
function showToast(message,  duration = 3000) {
    // 实例化一个 CustToast.vue
    const _toast = new ToastConstructor({
        data() {
            return {
                showToast: true,
                type,
                message: message,
                duration: duration
            }
        }
    });

    // 把实例化的 CustToast.vue 添加到 body 里
    let element = _toast.$mount().$el;
    document.body.appendChild(element);
    // duration时间到了后隐藏
    setTimeout(() => { _toast.showToast = false }, duration)
}
var type={
    info:showToast
}
vue.prototype.$message = type

// 导出
export default Toast