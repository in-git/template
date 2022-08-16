const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: [
    'vuetify'
  ],
  pluginOptions: { //添加成功后，保证electron中remote对象正常使用
    electronBuilder: {
      nodeIntegration: true,
      builderOptions: {
        "appId": "com.xxx",
        "productName": "coc",//项目名，也是生成的安装文件名，即aDemo.exe
        "copyright": "Copyright © 2021",//版权信息
        "directories": {
          "output": "./out"//输出文件路径
        },
        "win": {//win相关配置
          // "icon":"./coc.ico",//图标，当前图标在根目录下，注意这里有两个坑, 文件要求256x256，不设置则使用默认图标
          "target": [
            {
              "target": "nsis",//利用nsis制作安装程序
              "arch": [
                "x64",//64位
                // "ia32"//32位
              ]
            }
          ]
        }
      }
    }
  }
})
