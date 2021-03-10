<template>
  <div>
    <v-app>
      <v-main :dark="theme.dark">
        <v-container fluid fill-height align-start class="bgimg pa-0">
          <router-view class="w-100"></router-view>
          <!-- 联系方式 -->

          <v-speed-dial v-model="fab" right fixed bottom>
            <template v-slot:activator>
              <v-btn small v-model="fab" color="blue darken-2" dark fab>
                <v-icon v-if="fab">
                  mdi-close
                </v-icon>
                <v-icon v-else>
                  mdi-account-circle
                </v-icon>
              </v-btn>
            </template>
            <!-- 点击后显示的按钮 -->
            <v-btn fab dark small color="green">
              <v-icon>mdi-wechat</v-icon>
            </v-btn>
            <v-btn fab dark small color="indigo">
              <v-icon>mdi-penguin</v-icon>
            </v-btn>
            <v-btn fab dark small color="red">
              <v-icon>mdi-email</v-icon>
            </v-btn>
          </v-speed-dial>
        </v-container>

      </v-main>
      <!-- 底部备案友链 -->
      <v-footer :dark="theme.dark" app>
        <div class="d-flex justify-around w-100 records">
          <div class="text-center">
            <span>备案号</span>
            <a class="white--text pl-2" target="_blank" href="https://beian.miit.gov.cn/" v-text="record.info"></a>
            <div>
              <span>Copyright</span>
              <span v-text="record.copyright"></span>
            </div>
          </div>
        </div>
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