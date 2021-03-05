module.exports = {
  title: "资料驿站",
  description: "编程就是复制粘贴",
  // base: "/md/",
  markdown: {
    lineNumbers: true, // 代码块显示行号
  },
  plugins: [
    "autobar", //自动菜单
    [
      "vuepress-plugin-nuggets-style-copy",
      {
        copyText: "复制代码",
        tip: {
          content: "复制成功!",
        },
      },
    ],
  ],
};
