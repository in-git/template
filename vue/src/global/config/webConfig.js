// 此js用于页面全局配置
let config = {
  title: "网页标题", //网页标题
  //背景图片名,必须放在assets文件夹下,填写文件名即可
  bgimg: "background.png",
  bannerTitle: "导航栏标题", //导航栏标题

  /* 服务器配置 */
  host: "http://localhost:4000", //主机地址
  port: 4000, //后台端口,
  // 前端端口
  devServe: {
    vuePort: 8080,
    open: true,
  },
  theme: {
    dark: true, //主题为dark
  },
  // 是否在控制台打印配置
  outputSetting: true,
};
module.exports = config;
