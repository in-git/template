module.exports = {
  env: {
    browser: true,
    es2021: true,
    node: true
  },
  endOfLine: "auto",
  // .vue文件的ESLint自定义解析器。
  parser: "vue-eslint-parser",
  extends: [
    "eslint:recommended",
    "plugin:vue/vue3-recommended",
    "plugin:@typescript-eslint/recommended",
    "plugin:prettier/recommended" // 插件约束规范 解决eslint和prettier的冲突问题
  ],
  parserOptions: {
    ecmaVersion: "latest",
    parser: "@typescript-eslint/parser",
    sourceType: "module",
    // 支持jsx
    ecmaFeatures: {
      jsx: true
    }
  },
  // eslint-plugin-vue @typescript-eslint/eslint-plugin 的缩写
  plugins: ["vue", "@typescript-eslint"],
  rules: {},
  // 这里vue3的配置我们要特别说一下，因为vue3很多新的特性，例如defineProps会直接在eslint报错。所以，如果是使用vue3的小伙伴，就需要针对vue3进行一些配置。
  // 首先，我们需要添加对defineProps、defineEmits、defineExpose、withDefaults的支持。
  globals: {
    defineProps: "readonly",
    defineEmits: "readonly",
    defineExpose: "readonly",
    withDefaults: "readonly"
  }
};
