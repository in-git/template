import { createApp } from 'vue'
import App from './App.vue'
import { routerInstall } from './router'
import { storeInstallation } from "./store/index"
import '@purge-icons/generated';//iconify installation
import 'normalize.css/normalize.css';//normalize installation
const app = createApp(App)
routerInstall(app);
storeInstallation(app)
app.mount('#app')
