import { join } from 'path'
import vue from '@vitejs/plugin-vue'
import PurgeIcons from 'vite-plugin-purge-icons'

export default {
  root: join(__dirname, './src/render'),
  base: './',
  outDir: join(__dirname, './dist'),
  plugins: [
    vue(),
    PurgeIcons(),
  ],
}

