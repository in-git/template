<template>
  <div>
    <v-container>
      <v-row justify="center">
        <v-col cols="8">
          <!--  -->
          <v-card elevation="0" id="main" min-height="400" class="w-100"></v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import _echarts from "@/global/echarts/index";
export default {
  mounted() {
    _echarts.init("#main");
  },
};
</script>

<style>
</style>