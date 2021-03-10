## 安装流程

- 安装流程
  - npm install
  - npm run serve

1. 相关依赖

   ```
   npm install axois					//网络
   npm install echarts @4.9.0			//echarts表格
   npm i wangeditor --save				//富文本编辑器
   ```

2. 重要文件详解

   ```
    - global					全局文件,用于整个项目配置和样式
    	- config					+全局配置
    		* bus						公共传输文件
    		* import					统一引入use文件
    		* vuetify					vuetify框架
    		* webConfig					项目配置文件
    	- css
    		* reset						界面样式重构
    		* style						自定义样式库
    	- request					+网络请求
    		* api						统一api管理
    		* axios						axios封装
    	- router					+路由管理
    		*index						统一路由管理
    - utils					全局工具函数
    		*utils						通用工具文件
    -  views
    	 - components				 + 自定义组件
    	 	*index						组件统一注册文件
    	 - extend					 + 自定义扩展组件
    	 	*index						扩展组件统一挂载文件
    	 - modules					 +	项目文件夹
    	 	- common						+公共页面
    	 	- home							+主页
    	 - repository				 + vue插件使用案列,入门demo
   ```

   