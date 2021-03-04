## 安装流程

1. vue add vuetify

2. 替换根目录下src + public + vueconfig 文件(先删除后复制)

3. 安装依赖

   ```
   npm install axois
   npm install echarts @4.9.0
   ```

4. 重要文件详解

   ```
    - global					全局文件,用于整个项目配置和样式
    	- config					+全局配置
    		* bus.js						公共传输文件
    		* import.js						统一引入use文件
    		* vuetify.js					vuetify框架
    		* webConfig.js					项目配置文件
    	- css
    		* reset.css						界面样式重构
    		* style.css						自定义样式库
    	- request					+网络请求
    		* api.js						统一api管理
    		* axios.js						axios封装
    	- router					+路由管理
    		*index.js						统一路由管理
    - utils					全局工具函数
    		*utils.js						通用工具文件
    -  views
    	 - components				 + 自定义组件
    	 	*index.js						组件统一注册文件
    	 - extend					 + 自定义扩展组件
    	 	*index.js						扩展组件统一挂载文件
    	 - modules					 +	项目文件夹
    	 	- common.vue					+公共页面
    	 	- home.vue						+主页
    	 - repository				 + vue插件使用案列,入门demo
   ```


## 故障处理

>故障描述:vue ui 打开空白
>
>处理:删除 C:\Users\Administrator\.vue-cli-ui  该文件夹  .vue-cli-ui 是一个文件夹

>echarts只能安装4.9的版本
>
>npm install echarts @4.9.0