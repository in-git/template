import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';
import 'font-awesome/css/font-awesome.min.css';
import 'animate.css';
import "../css/import.scss";
Vue.use(Vuetify);

export default new Vuetify({
    icons: {
        iconfont: 'fa4',
    },
    theme: {
        themes: {
            light: {
                primary: '#3a0ca3',
                secondary: '#3f37c9',
                accent: '#4895ef',
                error: '#f72585',
                blue: "#3a86ff",
                grey: "#264653",
                dark: "#003049",
                green: "#00f5d4",
                pink: "#f15bb5",
                red: "#ef233c",
                purple: "#c77dff",
            },
        },
    },
});
