<template>
  <div>
    <!-- 挂载节点 -->
    <v-container>
      <!-- 响应式外栏 -->

      <v-row justify="center">
        <v-col xl="6">
          <v-row>
            <v-col>
              <div class="display-1">
                文本编辑器
              </div>
            </v-col>
          </v-row>
          <!-- 内容 -->
          <v-row justify="center">
            <!-- 文章信息栏 -->
            <v-col cols="12">
              <v-row>
                <v-col>
                  <v-text-field dense prepend-inner-icon="mdi-map" label="文章标题"></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field dense prepend-inner-icon="mdi-account-circle" name="name" label="作者名称"></v-text-field>
                </v-col>
              </v-row>
            </v-col>
            <!-- 富文本编辑器主栏 -->
            <v-col>
              <div id="editor"></div>
            </v-col>
          </v-row>

          <v-row>
            <v-col cols="12">
              <v-textarea dense outlined rows="3" placeholder="请输入内容" no-resize label="文章备注"></v-textarea>
            </v-col>
            <v-col>
              <!-- 操作内容栏 -->
              <div class="text-right">
                <v-btn small class="mx-4" color="pink" outlined>清空</v-btn>
                <v-btn small elevation="" color="green">提交</v-btn>
              </div>
            </v-col>
          </v-row>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import E from "wangeditor";
export default {
  mounted() {
    const editor = new E("#editor");
    editor.create();
  },
};
</script>

<style>
</style>