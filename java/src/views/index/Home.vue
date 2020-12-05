<template>
  <div>
    <a-col :span="12" class="mx-auto">
      <a-input placeholder="名字" v-model="username"></a-input>
      <a-input placeholder="密码" v-model="passwd"></a-input>
      <a-button @click="submit">提交</a-button>
      <a-button @click="permission">校验登陆</a-button>
    </a-col>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      username: "",
      passwd: "",
      token: "",
    };
  },
  mounted() {
    const jwt = require("jsonwebtoken");
  },
  methods: {
    submit() {
      let params = {
        username: this.username,
        passwd: this.passwd,
      };
      this.$get("/login", params).then((data) => {
        const jwt = require("jsonwebtoken");
        let str = jwt.decode(data);
        console.log(data);
        console.log(str);
        window.localStorage.setItem("token", data);
      });
    },
    permission() {
    this.$get('test').then(data=>{
      console.log(data);
    })
    },
  },
};
</script>
