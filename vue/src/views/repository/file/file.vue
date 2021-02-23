/*  
阿里云文件上传
*///
<template>
  <div>
    <v-card min-height="50vh" class="scroll-y">
      <v-banner sticky>文本提示信息</v-banner>

      <v-card elevation="0">
        <v-card-text>
          <span>
            上传文件
          </span>
          <v-file-input v-model="files" @change="change" single-line hide-input prepend-icon="mdi-package" background-color="grey" filled accept="*"></v-file-input>
        </v-card-text>

        <v-card-text>
          <v-btn text @click="send">测试全局提示信息SnackBar</v-btn>
          <v-btn @click="getPolicy" color="primary">获取信息</v-btn>
        </v-card-text>
      </v-card>

    </v-card>

  </div>
</template>

<script>
import bus from "@/global/bus/bus.js";
import axios from "axios";
export default {
  methods: {
    send() {
      bus.$emit("onSnackBar", "文本信息");
    },
    getPolicy() {},
    change() {
      this.upload();
    },
    upload() {
      this.$api.filePolicy().then((res) => {
        //    构造参数,必须
        let forms = new FormData();
        forms.append("ossaccessKeyId", res.accessKeyId);
        forms.append("policy", res.policy);
        forms.append("key", res.dir + "/" + "${filename}");
        forms.append("signature", res.signature);
        forms.append("success_action_status", "200");
        forms.append("file", this.files);
        axios
          .post(res.host, forms, {
            "Content-Type": "multipart/form-data",
          })
          .then((data) => {
            if (data.statusText !== "OK" || data.status !== 200) {
              bus.$emit("onSnackBar", "返回错误", "red");
            }
            bus.$emit("onSnackBar", "成功上传", "green");
          });
      });
    },
  },
  data() {
    return {
      files: null,
    };
  },
  uploadFile() {},
};
</script>

<style>
</style>