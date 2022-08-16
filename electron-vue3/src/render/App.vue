<template>
  <!-- 可拖动区域 -->
  <div class="p-8 can-be-drag h-screen bg-gray-200">
    <div class="forbidden-drag bg-white h-full">
      <router-view></router-view>
    </div>
  </div>
</template>
<style>
body,
html {
  height: 100px;
}
.can-be-drag {
  -webkit-app-region: drag !important;
}

.forbidden-drag {
  -webkit-app-region: no-drag !important;
}
</style>
