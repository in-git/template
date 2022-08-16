<template>
  <div class="text-center">
    <v-dialog fullscreen v-model="pageSetting.show">
      <v-card>
        <v-card-text>
          Lorem ipsum dolor sit amet consectetur adipisicin
          g elit. Similique unde tenetur temporibus ullam doloremque id reiciendis libero au
          t. Ab maxime doloremque offic
          <v-btn text color="pink" @click="close">close</v-btn>res esse sae
          pe sit, aliquam assumenda quibusdam et.
        </v-card-text>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import {mapGetters} from "vuex"
export default {
  name: "pageSetting",
  computed:{
    ...mapGetters(["pageSetting"])
  },
  watch:{
    pageSetting:{
      deep:true,
      handler(){
        console.log("the attribute has been changed");
      }
    }
  },
  data: () => ({
  }),
  methods: {
    close() {
     this.$store.dispatch("app/closePageSetting",false)
    },
    open() {
      this.dialog=true;
    },
  },
  mounted() {
    console.log("强制刷新");
  },
};
</script>