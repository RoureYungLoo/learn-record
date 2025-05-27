import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
  proxy:{
    '/api':{
      target:"http://localhost:8080/", //跨域地址
      changeOrigin:true, //支持跨域
      rewrite:(path) => path.replace(/^\/api/, "")//重写路径,替换/api
    }
  }
})
