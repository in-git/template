<template>
  <v-app id="inspire">

    <v-app>
      <v-navigation-drawer app v-model="drawer">
      </v-navigation-drawer>

      <v-app-bar app>
      </v-app-bar>

      <v-main>

        <v-container fluid>
          <v-container>
            <v-row>
              <v-col>
                <v-btn>Click</v-btn>
                <v-alert type="success">消息传动</v-alert>
              </v-col>
            </v-row>
          </v-container>

        </v-container>
      </v-main>

      <v-footer app>
      </v-footer>
    </v-app>
  </v-app>
</template>

<script>
export default {
  //
  data() {
    return {
      drawer: true,
    };
  },
};
</script>