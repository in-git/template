import { defineConfig } from "vitepress";

export default defineConfig({
  // 全局设置
  lang: "zh-CH",
  lastUpdated: true,
  markdown: {
    theme: "material-palenight",
    lineNumbers: true,
  },
  // 主题配置
  themeConfig: {
    // 顶部导航栏设置：左侧
    logo: "/favicon.ico",
    siteTitle: "标题",
    // 顶部导航栏设置：右侧
    nav: [
      // {
      //   text: "前端",
      //   items: [
      //     // 单一菜单
      //     // {text: 'JavaScript', link: '/01FE/JavaScript', activeMatch: '/01FE/'},
      //     // 下拉菜单
      //     {
      //       items: [
      //         { text: "JavaScript", link: "/01FE/JavaScript" },
      //         { text: "TypeScript", link: "/01FE/TypeScript" },
      //         { text: "Vue", link: "/01FE/Vue" },
      //         { text: "React", link: "/01FE/React" },
      //         { text: "工程化", link: "/01FE/Engineering" },
      //       ],
      //     },
      //   ],
      // },
      { text: "URL", link: "http://localhost:3000/" },
    ],
    // 侧边栏配置
    sidebar: [
      {
        text: "文档",
        items: [
          { text: "标题A", link: "/start" },
        ],
      },
    ],
    // sidebar: {
    //   '/01FE/': [
    //   	{
    //   		items: [
    //   			{ text: 'JavaScript', link: '/01FE/JavaScript', activeMatch: '/01FE/' },
    //   			{ text: 'TypeScript', link: '/01FE/TypeScript' },
    //   			{ text: 'Vue', link: '/01FE/Vue' },
    //   			{ text: 'React', link: '/01FE/React' },
    //   			{ text: '工程化', link: '/01FE/Engineering' },
    //   		]
    //   	},
    //   ]
    // },
    // 页脚
    footer: {
      message: "Released under the MIT License.",
      copyright: "Copyright © Elliot Knight",
    },
  },
});
