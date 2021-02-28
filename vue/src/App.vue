<template>
  <v-app>
    <!-- 侧边栏 -->
    <v-navigation-drawer v-model="drawer" app>
      <!--  -->
      <v-tabs vertical>
        <!-- 必须用to,否则连接高亮失效 -->
        <v-tab exact link to="home">
          <v-row justify="space-between">
            <v-col>
              <v-icon color="grey">mdi-home</v-icon>
            </v-col>
            <v-col>
               <span>主页</span>
            </v-col>
          </v-row>
        </v-tab>
      </v-tabs>
    </v-navigation-drawer>

    <v-app-bar app>
      <v-app-bar-nav-icon @click="drawer = !drawer">
        <!-- 导航栏图标 -->
        <v-icon large color="green darken-2">
          mdi-domain
        </v-icon>
      </v-app-bar-nav-icon>
      <!-- 导航栏标题 -->
      <v-toolbar-title>导航栏</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <v-container>
        <!-- 实际内容 -->
        <router-view></router-view>
      </v-container>
    </v-main>

    <!-- 全局提示文本 -->
    <template>
      <div class="text-center ma-2">
        <v-snackbar v-model="snackbar.isShow" outlined light top right :color="snackbar.color">
          <div>
            {{snackbar.text}}
          </div>
        </v-snackbar>
      </div>
    </template>
  </v-app>
</template>

<script>
import bus from "@/global/bus/bus.js";

export default {
  data() {
    return {
      snackbar: {
        isShow: false,
        color: "green",
        text: "",
      },
      drawer: true,
      sidebarItems: [
        { text: "主页", icon: "mdi-home", href: "/home" },
        { text: "路由", icon: "mdi-clock", href: "/home1" },
      ],
      // 侧边导航栏默认高亮
      selectedItem: 0,
    };
  },
  mounted() {
    // 监听全局信息弹窗(snackbar)
    bus.$on("onSnackBar", (text, color = "green") => {
      this.snackbar.isShow = true;
      this.snackbar.color = color;
      this.snackbar.text = text;
    });
  },
};
</script>

<style>
@import url("./global/css/style.css");
@import url("./global/css/reset.css");
</style>