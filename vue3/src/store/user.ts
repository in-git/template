import { userConfig } from './../data/user';
import { defineStore } from "pinia";
/* 当组件修改这里值时,会存储到本地 */
export const userStore = defineStore("user", {

    state: () => {
        return {
            user: userConfig
        };
    },
    persist: {
        enabled: true,
        strategies: [
            { storage: localStorage, }
        ],
    },
});
