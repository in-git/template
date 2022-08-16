import { EventUtil } from "../utils/event.utils.js"
import { keydown, wheel } from "./map/event.map.js";
import { bus } from '../utils/enum.js';
import { importAll } from '../utils/utils.js';

export default {

    data() {
        return {
            // 向子组件传值
            contextmenu: {
                // 水平坐标
                x: 0,
                // 垂直坐标
                y: 0,
                // 显示右键菜单
                show: false,
                // 菜单标题
                title: "全局配置",
                events: [
                    {
                        text: "Real-Time",
                        icon: "fa-gear",
                        event: () => {
                            this.selectDrawer("pageSetting")
                            this.contextmenu.show = false;
                        },
                    },
                ]
            },
            // 全局弹出菜单
            drawer: undefined,
        }
    },
    methods: {
        // 选择子组件
        selectDrawer(componentName) {
            var drawers = importAll(require.context('../views/drawers', true, /\.vue$/))
            for (const key in drawers) {
                if (drawers[key].default.name === componentName) {
                    this.drawer = drawers[key].default
                    this.$store.dispatch("app/openPageSetting", true)
                }
            }
        },
        //    鼠标按下响应不同事件
        eventSelection() {
            // 按键事件
            EventUtil.addHandler(window, "keydown", (evt) => {
                keydown.call(this, evt)
                this.$bus.$emit(bus.WIN_KEYDOWN_EVENT, evt)
                this.$keyBoard(evt.code)
            })

            // 点击事件
            EventUtil.addHandler(window, "click", (evt) => {
                this.$bus.$emit(bus.WIN_CLICK_EVENT, evt)
                var contextmenu = document.querySelector(".contextmenu")
                if (!contextmenu) return
                if (!contextmenu.contains(evt.target))
                    this.contextmenu.show = false
            })

            // 滚轮事件
            EventUtil.addHandler(window, "wheel", (evt) => {
                wheel.call(this, evt)
            })

            // 鼠标右键事件，取消默认
            EventUtil.addHandler(window, "contextmenu", (evt) => {
                evt.preventDefault()
                this.contextmenu.x = evt.x
                this.contextmenu.y = evt.y
                var dataContextmenus = document.querySelectorAll("[data-contextmenu]")
                if (dataContextmenus.length === 0) return
                Array.from(dataContextmenus).forEach(node => {
                    if (node.contains(evt.target)) return
                    this.contextmenu.show = true
                })
                if (!dataContextmenus) this.contextmenu.show = true

            })
        },
        close() {
            this.contextmenu.show = false
        },
    }
}