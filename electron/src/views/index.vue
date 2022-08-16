<template>
  <div class="m-home h-100">
    <v-container fluid class="h-100">
      <v-row align-content="center" justify="center" class="h-100">
        <v-col cols="8">
          <v-card elevation="0">
            <v-card-title class="primary white--text">数据库登录</v-card-title>
            <v-card-text>
              <v-text-field label="输入库地址"></v-text-field>
              <v-text-field placeholder="输入库账号"></v-text-field>
              <v-text-field placeholder="输入库密码"></v-text-field>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
.m-home {
  color: black;
  background-image: url("https://api.uomg.com/api/rand.img1");
}
</style>