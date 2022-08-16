<template>
  <div class="text-center ma-2 keyboard" v-if="showKeyBoard">{{ message }}</div>
</template>
<script>
export default {
  name: "keyboard",
  data() {
    return {
      showKeyBoard: true,
      message: "",
      duration: 3000,
    };
  },
  computed: {
    iconSrc() {},
  },
};
</script>

<style scoped>
.keyboard {
  position: fixed;
  left: 0;
  bottom: 0;
  background: rgb(233, 233, 235);
  padding: 10px;
  border-radius: 5px;
  background-color: rgba(12, 12, 12, 0.829);
  text-align: center;
  color: white;
}

.success {
  color: #67c23a;
  background: rgb(225, 243, 216);
}

.warning {
  color: #e6a23c;
  background: rgb(250, 236, 216);
}

.fail {
  color: #f56c6c;
  background: rgb(253, 226, 226);
}

.icon img {
  width: 20px;
  height: 20px;
  margin-top: 3px;
  margin-right: 4px;
}
.v-application--wrap {
  height: fit-content;
}
</style>
