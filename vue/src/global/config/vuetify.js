import Vue from "vue";
import Vuetify from "vuetify/lib/framework";

Vue.use(Vuetify);
const vuetifyOpts = {
  // 文字翻转
  rtl: false,
  theme: {
    dark: false,
  },
};

export default new Vuetify(vuetifyOpts);
