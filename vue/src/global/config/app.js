import config from "./webConfig";
let _data = {
  mounted() {
    document.title = config.title;
    this.printSetting(config);
  },
  data() {
    return {
      drawer: false, //是否打开侧边导航栏
      bannerTitle: config.bannerTitle, //配置导航栏标题
      theme: {
        dark: config.theme.dark, //配置是否为黑暗主题
      },
      isLoginIn: false, //是否已经登陆,
      record:{
        copyright:config.record.copyright,
        info:config.record.info
      },

      // 
      items: [
        {
          icon: 'mdi-inbox',
          text: 'Inbox',
        },
        {
          icon: 'mdi-star',
          text: 'Star',
        },
        {
          icon: 'mdi-send',
          text: 'Send',
        },
        {
          icon: 'mdi-email-open',
          text: 'Drafts',
        },
      ],
      model: 1,
    };

    // 
    
  },
  methods: {
    // 打印配置
    printSetting(config) {
      if (config.outputSetting)
        for (let key in config) {
          if (typeof config[key] === "object") this.printSetting(config[key]);
          else console.log(key + " = " + config[key]);
        }
    },
  },
};
export default _data;
