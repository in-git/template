<template>
  <v-app>
    <router-view></router-view>
    <!-- 右键菜单 -->
    <d-contextmenu :contextmenu="contextmenu" v-if="contextmenu.show"></d-contextmenu>
    <div :is="drawer"></div>
  </v-app>
</template>

<script>
import appMixins from "./mixins/app.minxin";
export default {
  mixins: [appMixins],
  mounted() {
    this.eventSelection();
  },
};
</script>