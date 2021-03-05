<template>
  <div class="white--text h-100 bgimg" :style="{backgroundImage:`url(${bgimg})`}">
    <v-container fill-height class="" fluid c>
      <v-row justify="center" align="center" >
        <v-col xl="3" lg="4" md="5" cols="11">
          <v-card elevation="0" width="100%"  >
            <v-card-text class="text-center display-1 ">
              管理员登陆界面
            </v-card-text>
            <v-card-text class="pb-0">
              <v-row>
                <v-col class="pb-0">
                  <v-text-field prepend-inner-icon="mdi-account" dense label="请输入账号" outlined color></v-text-field>
                  <v-text-field prepend-inner-icon="mdi-lock" dense label="请输入密码" outlined color></v-text-field>
                </v-col>
              </v-row>
            </v-card-text>
            <v-card-text>
              <v-row>
                <v-col class="py-0 ma-0 justify-end d-flex" dense>
                  <v-checkbox class="py-0 ma-0" hide-details dense v-model="rememberMe" label="记住密码"></v-checkbox>
                </v-col>
                <v-col cols="12">
                  <v-btn outlined color="blue lighten-1" block to="/home">登陆</v-btn>
                </v-col>
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
      bgimg: "assets/background/" + config.bgimg,
      rememberMe: false,
    };
  },
  mounted() {},
};
</script>

<style scoped>
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