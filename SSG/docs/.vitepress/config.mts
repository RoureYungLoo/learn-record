import { defineConfig } from "vitepress";

// https://vitepress.dev/reference/site-config
export default defineConfig({
  locales: {
    root: {
      label: "简体中文",
      lang: "zh",
    },
  },
  title: "禄若阳的网站",
  description: "欢迎来到我的网站",
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: "我的首页", link: "/" },

      { text: "01-方法计划", link: "/01-方法计划" },

    ],

    sidebar: {
      "/01-方法计划/": [
        {
          text: "方法计划",
          collapsed:false,
          items: [
            { text: "电子日记", link: "/01-方法计划/电子日记" },
            { text: "接下来的规划", link: "/01-方法计划/接下来的规划" },
          ],
        },
      ],
    },

    socialLinks: [
      { icon: "github", link: "https://github.com/vuejs/vitepress" },
    ],
  },
});
