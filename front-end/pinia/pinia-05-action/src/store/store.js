import {defineStore} from "pinia";
import {mande} from "mande";
import axios from "axios";

export const useArticleStore = defineStore('article', {
  state: () => {
    return {
      count: 0,
      articles: null
    }
  },
  /* actions可以是异步的 */
  actions: {
    increment() {
      this.count++
    },
    /*decrement() {
      this.count--
    },*/
    decrement: (state) => (state.count--),
    randomCounter() {
      this.count = Math.round(100 * Math.random())
    },
    async getArticles() {
      this.articles = await fetch('http://localhost/articles',
        {
          method: "get",
        }).then((res) => {
        // console.log(res)
        if (res.status >= 200 && res.status < 300) {
          return res.json()
        }
      }).then((articles) => {
        return articles
      })

      console.log(this.articles)
      return this.articles
    },
    async getArticleByMande() {
      const api = mande('http://localhost/articles')
      this.articles = await api.get()
      console.log("-------- use mande")
      return this.articles
    },
    async getArticleByXMLHTTPRequest() {

    },
    async getArticleByAxios() {
      this.articles = await axios.get('http://localhost/articles').then((res) => {
        console.log('---------use axios', res.data)
        // this.articles = res.data
        return res.data
      })
      return this.articles
    }
  }
})