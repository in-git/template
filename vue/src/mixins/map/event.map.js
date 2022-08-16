
import { EventUtil } from "../../utils/event.utils"

export const keydown = function (evt) {
    const map = {
        // 重置帮助键
        F1: (evt) => {
            evt.preventDefault()
            console.log("F1打开帮助");
        },
        F2: (evt) => {
            evt.preventDefault()
            console.log("F2打开菜单");
        },
        F3: (evt) => {
            evt.preventDefault()
            console.log("F3联系方式");
        },
        // 重置保存键
        s: (evt) => {
            if (evt.ctrlKey) {
                console.log("保存");
                evt.preventDefault()
            }
        },
        // 重置取消键
        Escape: () => {
            console.log("Escape");
            // 关闭设置页面
            this.$store.dispatch("app/closePageSetting", false)
        },
        Delete: () => {
            console.log("delete");
        }
    }
    !!map[evt.key] && map[evt.key].call(this, evt);
    return
}

export const wheel = function (evt) {
    var direction = EventUtil.getWheelDelta(evt);
    // 解决滑动不够快的问题
    var to = document.scrollingElement.scrollTop;
    if (direction > 0) {
        document.scrollingElement.scrollTo({
            behavior: "smooth",
            top: to - 100
        })
    } else {
        document.scrollingElement.scrollTo({
            behavior: "smooth",
            top: to + 100
        })
    }

}