import config from "./webConfig";
let _data = {
  mounted() {
    document.title = config.title;
    this.printSetting(config);
  },
  data() {
    return {
      drawer: false,
      bannerTitle: config.bannerTitle,
      theme: {
        dark: config.theme.dark,
      },
    };
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
