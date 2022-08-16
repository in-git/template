<template>
  <div class="text-center ma-2">
    <v-snackbar v-model="showToast" centered> {{ message }}</v-snackbar>
  </div>
</template>
<script>
export default {
  name: "Toast",
  data() {
    return {
      showToast: true,
      type: "normal",
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
.u-toast {
  position: fixed;
  left: 50%;
  top: 50%;
  background: rgb(233, 233, 235);
  padding: 10px;
  border-radius: 5px;
  transform: translate(-50%, -50%);
  animation: show-toast 0.2s;
  color: #909399;
  overflow: hidden;
  display: flex;
  align-items: center;
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
