import { fileURLToPath, URL } from "node:url";

import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", import.meta.url)),
    },
  },
  server: {
    proxy: {
      // 配置代理，解决跨域
      "/api": {
        changeOrigin: true,
        target: "http://localhost:80",
        rewrite: (path) => path.replace(/^\/api/, ""),
      },
    },
  },
});
