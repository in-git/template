<template>
  <div>
    <v-app>
      <v-navigation-drawer app v-model="drawer" :dark="theme.dark"></v-navigation-drawer>
      <v-app-bar app :dark="theme.dark">
        <v-icon @click="drawer=!drawer">mdi-format-list-bulleted</v-icon>
        <v-spacer></v-spacer>
        <div v-text="bannerTitle"></div>
      </v-app-bar>
      <v-main :dark="theme.dark">
        <v-container fluid fill-height align-start class="bgimg pa-0">
          <router-view class="w-100"></router-view>
        </v-container>
      </v-main>
      <v-footer app>
      </v-footer>
    </v-app>
  </div>
</template>

<script>
import data from "./global/config/app";
export default data;
</script>
<style>
@import url("./global/css/style.css");
@import url("./global/css/reset.css");
</style>