<template>
  <div>
    <v-btn small elevation="" color="" @click="data++">改变</v-btn>

  </div>
</template>

<script>
export default {
  mounted() {
    this.$api.test().then((data) => {
      console.log(data);
    });
  },
  data() {
    return {
      data: 0,
    };
  },
  watch: {
    $route(to, from) {
      console.log(to, from);
    },
  },
};
</script>

<style>
</style>