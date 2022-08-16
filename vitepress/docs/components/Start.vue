<template>
  <button @click="run">点击我</button>
</template>

<script>
export default {
  methods: {
    run() {
      alert("vue 组件");
    },
  },
};
</script>

<style lang="scss" scoped>
button {
  text-decoration: underline;
}
</style>
