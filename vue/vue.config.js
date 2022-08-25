var config = {
  // host: "http://192.168.1.6:4000/", //主机地址
  host: "http://localhost:8080/",
  online_host: "http://134.175.79.33:8080/",
  port: 4000, //后台端口,
  // outputDir: "X:/deploy/vue/",//打包输出目录
  baseURL: "/base/",//根路径
  // 前端端口
  devServe: {
    vuePort: 8080,
    open: true,
  },
};


const isProduction = process.env.NODE_ENV !== "development";// 是否为生产环境

const devNeedCdn = false;// 本地环境是否需要使用cdn
/* 开启GZIP */
const CompressionWebpackPlugin = require("compression-webpack-plugin")
const productionGzipExtensions = /\.(js|css|json|txt|html|ico|svg)(\?.*)?$/i

// cdn链接
const cdn = {
  // cdn：模块名称和模块作用域命名（对应window里面挂载的变量名称）
  //"模块文件名":"引入变量名"
  externals: {
    /**
     *key: main.js中全局引入的路径
     *value: 全局暴露出来的对象名
     */
    Vue: "Vue",
    // "VueRouter": "vue-router",
    axios: "axios"

  },
  // cdn的css链接
  css: [
    "https://cdn.bootcdn.net/ajax/libs/normalize/8.0.1/normalize.min.css",
    "https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap-grid.min.css"
    // "https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css",
  ],
  // cdn的js链接
  js: [
    "https://cdn.bootcdn.net/ajax/libs/vue/2.6.11/vue.min.js",
    // "https://cdn.bootcdn.net/ajax/libs/vue-router/3.2.0/vue-router.min.js",
    "https://cdn.bootcdn.net/ajax/libs/axios/0.21.0/axios.min.js",

  ],
};

module.exports = {
  // 部署到gitee上需要配置
  publicPath: process.env.NODE_ENV === "production" ? config.baseURL : "/",

  // publicPath: config.baseURL,
  outputDir: config.outputDir,

  devServer: {
    port: config.devServe.port === null ? 8082 : config.devServe.port, // 启动端口
    open: config.devServe.open, // 启动后是否自动打开网页
    disableHostCheck: false, //跳过检查
  },

  productionSourceMap: false,

  chainWebpack: (config) => {
    if (process.env.NODE_ENV !== "production") {
    }
    config.plugin("html").tap((args) => {
      if (isProduction || devNeedCdn) args[0].cdn = cdn;
      return args;
    });
  },

  configureWebpack: (config) => {
    if (isProduction || devNeedCdn) config.externals = cdn.externals;
    const plugins = []
    // start 生成 gzip 压缩文件
    plugins.push(
      new CompressionWebpackPlugin({
        filename: "[path].gz[query]", //目标资源名称
        algorithm: "gzip",
        test: productionGzipExtensions, //处理所有匹配此 {RegExp} 的资源
        threshold: 10240,//只处理比这个值大的资源。按字节计算(楼主设置10K以上进行压缩)
        minRatio: 0.8 //只有压缩率比这个值小的资源才会被处理
      })
    );

    // End 生成 gzip 压缩文件
    config.plugins = [...config.plugins, ...plugins];
  },

  // 保证构建在cdn上的项目的安全性
  integrity: true,
};
