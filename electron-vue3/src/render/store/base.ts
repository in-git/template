import { defineStore } from 'pinia'

export const baseInfo = defineStore({
    id: 'baseInfo',  // 命名，唯一
    state: () => {
        return {
            data: "baseInfo"
        }
    },
    actions: {
        setUserInfo(data) {
            // 可直接通过this访问state属性
            this.data = data;
        },
    }
})
