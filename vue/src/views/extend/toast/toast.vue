<template>
  <div>
    <div class="app-toast black--text" v-if="isShow" :class="{'info': type=== 'info','success': type=== 'success','wraning': type=== 'wraning','danger': type=== 'danger'}">{{text}}</div>
  </div>
</template>

<style scoped>
.app-toast {
  position: fixed;
  min-width: 100px;
  max-width: 300px;
  overflow: hidden;
  word-break: keep-all; /* 不换行 */
  white-space: nowrap; /* 不换行 */
  overflow: hidden; /* 内容超出宽度时隐藏超出部分的内容 */
  text-overflow: ellipsis; /* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/
  top: 10%;
  right: 0;
  background: rgb(255, 255, 255);
  border-radius: 5px;
  transform: translate(-10%, -50%);
  padding: 10px;
}
.info {
  background: #00aaee;
}
.success {
  background: #00ee6b;
}
.wraning {
  background: #eea300;
}
.danger {
  background: #ee000c;
}
</style>
