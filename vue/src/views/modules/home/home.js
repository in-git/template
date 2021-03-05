import config from "@/global/config/webConfig";
let _data = {
  data() {
    return {
      drawer: false, //是否打开侧边导航栏
      bannerTitle: config.bannerTitle, //配置导航栏标题
      theme: {
        dark: config.theme.dark, //配置是否为黑暗主题
      },
      isLoginIn: false, //是否已经登陆,
      model: 1,
      // 菜单列表
      items: [
        {
          icon: "mdi-home",
          text: "主页",
          href: "/home",
        },
      ],
    };
  },
};
export default _data;
