import {defineStore} from "pinia";
import {ref} from "vue";
import axios from "axios";

export const useArticleStore = defineStore('article', () => {
  const articles = ref(null)

  const fetchArticles = async function () {
    await axios.get('http://localhost/articles').then(res => {
      articles.value = res.data
      return res.data
    }).catch(err => {
      articles.value = null
      return err
    })
  }

  const removeById = (articleId) => {
    articles.value = articles.value.filter(article => article.id !== articleId)
  }

  return {
    articles, fetchArticles, removeById
  }
})