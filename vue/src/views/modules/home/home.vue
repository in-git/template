<template>
  <div>
    <!-- 侧边导航栏 -->
    <v-navigation-drawer app v-model="drawer" dark>
      <v-list>
        <v-list-item-group v-model="model" >
          <v-list-item v-for="(item, i) in items" :key="i"  :to="item.href">
            <v-list-item-icon>
              <v-icon v-text="item.icon"></v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title v-text="item.text"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

    <!-- tabbar -->
    <v-app-bar app dark>
      <v-icon @click="drawer=!drawer">mdi-format-list-bulleted</v-icon>
      <v-spacer></v-spacer>
      <div v-text="bannerTitle"></div>
    </v-app-bar>
 <v-container class="">
    <v-row>
      <v-col>
        <router-view></router-view>
      </v-col>
    </v-row>
  </v-container>
  </div>

</template>
<script>
import data from "./home"
export default data
</script>

<style>
</style>