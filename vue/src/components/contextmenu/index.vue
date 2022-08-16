<template>
  <div class="contextmenu" :style="comContextmenuStyle">
    <div class="text-center">
      <v-card class="mx-auto" max-width="300" >
        <v-list >
          <v-subheader v-text="contextmenu.title"></v-subheader>
          <v-list-item-group v-model="selectedItem" color="primary">
            <v-list-item v-for="(v, i) in contextmenu.events" :key="i" @click="v.event">
              <v-list-item-icon>
                <v-icon v-text="v.icon"></v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title v-text="v.text"></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-card>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      selectedItem: 1,
      title: "全局配置",
    };
  },
  name: "d-contextmenu",
  props: {
    contextmenu: {
      x: undefined,
      y: undefined,
      title: undefined,
      events:undefined
    },
  },
  computed: {
    comContextmenuStyle() {
      return {
        left: this.contextmenu.x + "px",
        top: this.contextmenu.y + "px",
      };
    },
  },
  watch: {
    contextmenu: {
      handler() {
        console.log("contextmenu", this.contextmenu.x);
      },
      deep: true,
    },
  },
};
</script>
<style scoped>
.contextmenu {
  position: fixed;
}
</style>