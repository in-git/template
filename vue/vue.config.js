const config = require("./src/global/config/webConfig");
// 是否为生产环境
const isProduction = process.env.NODE_ENV !== "development";

// 本地环境是否需要使用cdn
const devNeedCdn = true;

// cdn链接
const cdn = {
  // cdn：模块名称和模块作用域命名（对应window里面挂载的变量名称）
  //"模块文件名":"引入变量名"
  externals: {
    vue: "Vue",
    vuex: "Vuex",
    "vue-router": "VueRouter",
    vuetify: "vuetify",
    axios: "axios",
    wangeditor: "wangeditor",
    vuex: "vuex",
  },
  // cdn的css链接
  css: [
    "https://cdn.jsdelivr.net/npm/vuetify@2.x/dist/vuetify.min.css",
    "https://cdn.jsdelivr.net/npm/@mdi/font@4.x/css/materialdesignicons.min.css",
    "https://cdn.jsdelivr.net/npm/@mdi/font@4.x/css/materialdesignicons.min.css",
    "https://cdn.bootcdn.net/ajax/libs/material-design-icons/3.0.2/iconfont/material-icons.min.css",
  ],
  // cdn的js链接
  js: [
    "https://cdn.jsdelivr.net/npm/vue@2.x/dist/vue.js",
    "https://cdn.staticfile.org/vue-router/3.0.3/vue-router.min.js",
    "https://cdn.bootcdn.net/ajax/libs/axios/0.21.0/axios.min.js",
    "https://cdn.jsdelivr.net/npm/vuetify@2.x/dist/vuetify.js",
    "https://cdn.jsdelivr.net/npm/wangeditor@latest/dist/wangEditor.min.js",
    "https://cdn.bootcss.com/vuex/3.6.2/vuex.min.js",
  ],
};

module.exports = {
  devServer: {
    port: config.devServe.port === null ? 8080 : config.devServe.port, // 启动端口
    open: config.devServe.open, // 启动后是否自动打开网页
  },
  transpileDependencies: ["vuetify"],
  productionSourceMap: false,
  chainWebpack: (config) => {
    config.plugin("html").tap((args) => {
      if (isProduction || devNeedCdn) args[0].cdn = cdn;
      return args;
    });
  },
  configureWebpack: (config) => {
    if (isProduction || devNeedCdn) config.externals = cdn.externals;
  },
};
