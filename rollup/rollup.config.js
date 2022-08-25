import pkg from './package.json';
import resolve from '@rollup/plugin-node-resolve';
import commonjs from '@rollup/plugin-commonjs';
import babel from 'rollup-plugin-babel';
import { terser } from 'rollup-plugin-terser';
export default [
  {
    input: 'src/index.js',
    external: ['ms'],
    output: [
      {
        name: 'Test',
        file: pkg.main,
        format: 'umd',
      },
    ],
    plugins: [
      resolve(), // 这样 Rollup 能找到 `ms`
      commonjs(), // 这样 Rollup 能转换 `ms` 为一个ES模块
      babel(),
      terser(),
    ],
  },
];
