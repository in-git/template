import Vue from "vue";
import Vuetify from "vuetify/lib/framework";

Vue.use(Vuetify);
const vuetifyOpts = {
  // 文字翻转
  rtl: false,
  theme: {
    ///////////// 主题选择 /////////////
    
    // dark: false,
    // themes: {
    //   dark: {
    //     primary: '#B73BDC',
    //     accent: '#DC1B5D',
    //     secondary: '#FFE18D',
    //     success: '#4CAF50',
    //     info: '#2196F3',
    //     warning: '#FB8C00',
    //     error: '#FF5252'
    //   },
    //   light: {
    //     primary: '#1976D2',
    //     accent: '#E91E63',
    //     secondary: '#30b1dc',
    //     success: '#4CAF50',
    //     info: '#2196F3',
    //     warning: '#FB8C00',
    //     error: '#FF5252'
    //   }
    // }
  },
};

export default new Vuetify(vuetifyOpts);
