<template>
  <div class="white--text h-100 bgimg" :style="{backgroundImage:`url(${bgimg})`}">
    <v-container fill-height>
      <v-row justify="center">
        <v-col cols="12" lg=6 md="8" xl="4" class="_maintenance_shadow">
          <v-card elevation="0">
            <v-card-title primary-title>
              <v-icon class="pr-3" color="blue-grey">mdi-flash-alert</v-icon>
              错误页面
            </v-card-title>
            <v-card-text>
              错误提示信息
            </v-card-text>
            <v-card-actions>
              <div class="text-right w-100 py-2">
                <v-btn small elevation="" color="success">返回首页</v-btn>
              </div>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import config from "@/global/config/webConfig";
export default {
  data() {
    return {
      bgimg: "assets/background/" + config.errorImg,
    };
  },
  computed: {
    com_notice() {
      return this.notice;
    },
  },
};
</script>

<style>
.bgimg {
  position: fixed;
  z-index: 0;
  background-color: rgba(0, 0, 0, 0.1);
  height: 100%;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}
</style>