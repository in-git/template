// 此js用于页面全局配置
let config = {
  title: "我的新标题", //网页标题
  /* **********
  |   图片设置 |
  ************/
  // 必须放在assets文件夹下,填写文件名即可
  // 登陆--背景图片
  bgimg: "background.webp",
  // 维护--全屏背景图片
  maintenanceImg: "maintenance-bgimg.webp",
  // 维护--卡片背景图片
  maintenanceCardImg: "maintenance-card-bgimg",
  errorImg:'error-bgImg.webp',

  bannerTitle: "导航栏标题", //导航栏标题

  /* ************
  |   服务器配置  |
  ***************/
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
  outputSetting: false,
  // 系统维护界面提示信息
  notification: {
    maintenance: "系统正在维护中,请留意通知",
  },

  /* ************
  |   备案信息配置  |
  ***************/
  record: {
    // 版权标注
    copyright: "@1993-2018 北京新网数码信息技术有限公司 版权所有",
    //备案号
    info: "京ICP备 04000001号",
  },
};
module.exports = config;
