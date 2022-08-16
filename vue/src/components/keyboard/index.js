import vue from 'vue'

// 导入自定义到Toast组件
import KeyBoard from './index.vue'


// 生成一个扩展实例构造器
const KeyBoardConstructor = vue.extend(KeyBoard);

// 定义弹出组件的函数 接收三个参数 消息  显示时间
function showKeyBoard(message, duration = 1000) {
    const keyBoard = new KeyBoardConstructor({
        data() {
            return {
                showKeyBoard: true,
                message,
                duration
            }
        }
    });

    let element = keyBoard.$mount().$el;
    document.body.appendChild(element);

    // duration时间到了后隐藏
    setTimeout(() => {
        keyBoard.showKeyBoard = false
    }, duration)
}
vue.prototype.$keyBoard = showKeyBoard

// 导出
export default showKeyBoard