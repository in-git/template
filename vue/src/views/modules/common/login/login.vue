<template>
  <div class="white--text h-100 bgimg" :style="{backgroundImage:`url(${bgimg})`}">
    <v-container fill-height class=" pa-0" fluid>
      <v-row justify="center" align="center">
        <v-col xl="3" lg="4" md="6" cols="11">
          <v-card elevation="0" width="100%">
            <v-card-text class="text-center display-1 grey white--text">
              管理员登陆界面
            </v-card-text>
            <v-card-text class="pb-0">
              <v-row>
                <v-col class="pb-0">
                  <v-text-field dense label="请输入账号" outlined color></v-text-field>
                  <v-text-field dense label="请输入密码" outlined color></v-text-field>
                </v-col>
              </v-row>
            </v-card-text>
            <v-card-text class="d-flex justify-space-around">
              <v-row>
                <v-col>
                  <v-btn outlined color="pink" block>注册</v-btn>
                </v-col>
                <v-col>
                  <v-btn outlined color="green" block to="/home">登陆</v-btn>
                </v-col>
              </v-row>
            </v-card-text>
            <v-card-text class="py-0">
              <v-row no-gutters>
                <v-col>
                  <v-switch class="mt-0" label="其他操作"></v-switch>
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