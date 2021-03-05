<template>
  <div class="white--text h-100 bgimg" :style="{backgroundImage:`url(${bgimg})`}">
    <v-container fill-height>
      <v-row justify="center">
        <v-col cols="12" lg=6 md="8" xl="4" class="_maintenance_shadow">
          <v-card elevation="0">
            <v-card-title primary-title>
              <v-icon class="pr-3" color="blue-grey">mdi-saw-blade</v-icon>
              页面维护中...
            </v-card-title>

            <v-card-text>
              <v-row>
                <!-- 左侧卡片背景图 -->
                <v-col cols="12" order="12" xl="6" lg="6" md="6" order-xl="1" order-lg="1" order-md="1">
                  <v-img src="assets/background/maintenance-card-bgimg.webp" max-height="400"></v-img>
                </v-col>
                <!-- 维护通知界面 -->
                <v-col class="h-100" cols="12" order="1" xl="6" lg="6" md="6" order-xl="2" order-lg="2" order-md="2">
                  <v-card elevation="0" min-height="100">
                    <div class="text--primary" v-text="com_notice">
                    </div>
                  </v-card>
                </v-col>
                <div class="position-absolute b-0 r-0 pa-4">
                  <v-icon color="green">mdi-wechat</v-icon>
                  <v-icon color="pink" class="px-4">mdi-email</v-icon>
                  <v-icon color="blue">mdi-penguin</v-icon>
                </div>
              </v-row>
            </v-card-text>
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
      bgimg: "assets/background/" + config.maintenanceImg,
      cardBgimg: "assets/background/" + config.maintenanceCardImg,
      notice: config.notification.maintenance, //系统维护通知
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