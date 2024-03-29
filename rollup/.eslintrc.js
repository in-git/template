module.exports = {
  env: {
    browser: true,
    es2021: true,
    node: true,
  },
  extends: ['eslint:recommended'],
  parserOptions: {
    ecmaVersion: 13,
    sourceType: 'module',
  },
  rules: {
    'no-console': 'error',
    'prefer-const': 'error',
    'no-var': 'error',
    'no-multi-assign': 'error',
    'no-plusplus': 'off',
    'no-new-object': 'error',
    'object-shorthand': 'error',
    'quote-props': ['error', 'as-needed'],
    'no-prototype-builtins': 'error',
    'no-array-constructor': 'error',
    'array-callback-return': 'error',
    'prefer-destructuring': 'error',
    quotes: ['error', 'single', { avoidEscape: true }],
    'prefer-template': 'error',
    'template-curly-spacing': 'error',
    'no-eval': 'error',
    'func-style': 'off',
    'wrap-iife': 'error',
    'no-loop-func': 'error',
    'prefer-rest-params': 'error',
    'no-new-func': 'error',
    'space-before-blocks': 'error',
    'no-param-reassign': 'error',
    'prefer-spread': 'error',
    'prefer-arrow-callback': 'error',
    'arrow-spacing': 'error',
    'arrow-parens': ['error', 'as-needed'],
    'no-confusing-arrow': ['error', { allowParens: true }],
    'no-useless-constructor': 'error',
    'no-duplicate-imports': ['error', { includeExports: true }],
    'no-iterator': 'error',
    'generator-star-spacing': ['error', { before: false, after: true }],
    'dot-notation': 'error',
    eqeqeq: 'error',
    'no-nested-ternary': 'error',
    'no-unneeded-ternary': 'error',
    'no-mixed-operators': [
      'error',
      {
        groups: [
          ['+', '-', '*', '/', '%', '**'],
          ['&', '|', '^', '~', '<<', '>>', '>>>'],
          ['==', '!=', '===', '!==', '>', '>=', '<', '<='],
          ['&&', '||'],
          ['in', 'instanceof'],
        ],
        allowSamePrecedence: true,
      },
    ],
    'nonblock-statement-body-position': ['error', 'beside'],
    'brace-style': 'error',
    'no-else-return': 'error',
    'spaced-comment': ['error', 'always'],
    'keyword-spacing': 'error',
    'space-infix-ops': 'error',
    'eol-last': 'error',
    'newline-per-chained-call': ['error', { ignoreChainWithDepth: 2 }],
    'padded-blocks': ['error', 'never'],
    'no-multiple-empty-lines': ['error', { max: 2, maxBOF: 1 }],
    'space-in-parens': 'error',
    'array-bracket-spacing': ['error', 'never'],
    'object-curly-spacing': ['error', 'always'],
    'max-len': [
      'error',
      {
        code: 80,
        comments: 80,
        ignoreTemplateLiterals: true,
        ignoreRegExpLiterals: true,
      },
    ],
    'block-spacing': 'error',
    'comma-spacing': 'error',
    'computed-property-spacing': 'error',
    'func-call-spacing': 'error',
    'key-spacing': 'error',
    'no-trailing-spaces': 'error',
    'comma-style': ['error', 'last'],
    'comma-dangle': [
      'error',
      {
        arrays: 'always-multiline',
        objects: 'always-multiline',
        imports: 'always-multiline',
        exports: 'always-multiline',
        functions: 'never',
      },
    ],
    semi: ['error', 'always'],
    'no-new-wrappers': 'error',
    radix: 'error',
    'id-length': 'off',
    camelcase: 'error',
    'new-cap': 'error',
    'no-underscore-dangle': 'error',
    'no-restricted-globals': [
      'error',
      'event',
      'fdescribe',
      'isNaN',
      'isFinite',
    ],
    'no-compare-neg-zero': 'error',
    'space-before-function-paren': 'off',
  },
};
