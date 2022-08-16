import { createPinia } from "pinia";
// 创建store实例

export const storeInstallation = app => {
    const store = createPinia();
    app.use(store);
};
