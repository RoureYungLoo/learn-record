<script setup>


import instance, {requestInterceptor, responseInterceptor} from "@/request/request.js";

const articles = ref([])

/* 原生 XMLHttpRequest */
import {onMounted, ref, toValue, unref} from "vue";

const findList = function () {
  const request = new XMLHttpRequest();
  request.onreadystatechange = () => {
    if (request.readyState === 4 && request.status === 200) {
      // console.log(request.responseText)
      articles.value = JSON.parse(request.responseText)
    }
  }
  request.open('GET', 'http://localhost/articles')
  request.send()
}
const formData = ref({
  articleId: null,
  title: null,
  category: [],
  coverImg: null
})

/* 使用 Axios */
import axios from 'axios'
import {ElMessage} from "element-plus";

const article = ref(null)
const findById = (id) => {
  // axios.get(`http://localhost/articles/${formData.value.articleId}`, {
  //   params: {
  //     id: formData.value.articleId
  //   }
  // }).then((res) => {
  //   article.value = res.data
  //   ElMessage({
  //     message: 'msg',
  //     type: 'success'
  //   })
  // }).catch((err) => {
  //   ElMessage({
  //     message: err,
  //     type: "error"
  //   })
  // })
  instance.get(`/articles/${formData.value.articleId}`)
      .then(res => {
        console.log(res)
      }).catch(err => {
    console.log(err)
  }).finally(() => {
    console.log('finally')
  })
}

const saveArticle = () => {
  // console.log(formData.value)
  axios({
    method: "POST",
    url: "http://localhost/articles/add",
    data: formData.value
  }).then(res => {
    ElMessage({
      message: res.data,
      type: "success"
    })
  }).catch(err => {
    ElMessage({
      message: err,
      type: "warning"
    })
  })
}

const initData = function () {
  axios({
    method: "GET",
    url: 'http://localhost/articles'
  }).then(res => {
    articles.value = res.data
    ElMessage({
      message: 'success',
      type: "success"
    })
  }).catch(err => {
    ElMessage({
      message: err,
      type: "error"
    })
  })
}

onMounted(() => {
  initData()
})

const center = {
  textAlign: 'center'
}

const getImgUrl = (url) => {
  return `http://127.0.0.1:5500/${url}`
}

const cancelReqInterceptor = () => {
  instance.interceptors.request.eject(requestInterceptor)
}

const cancelRespInterceptor = () => {
  instance.interceptors.response.eject(responseInterceptor)
}
</script>

<template>
  <h1>Article</h1>
  <el-button @click="findList">查询文章</el-button>
  <el-table :data="articles" stripe border fit :header-cell-style="center
" :cell-style="center">
    <el-table-column prop="id" label="序号"></el-table-column>
    <el-table-column prop="title" label="标题"></el-table-column>
    <el-table-column prop="category" label="分类"></el-table-column>
    <el-table-column prop="time" label="发布时间"></el-table-column>
    <el-table-column prop="state" label="状态"></el-table-column>
    <el-table-column label="封面">
      <template #default="scope">
        <el-image :src="getImgUrl(scope.row.coverImg)" fit="contain"/>
      </template>
    </el-table-column>
    <el-table-column prop="createTime" label="创建时间"></el-table-column>
    <el-table-column prop="updateTime" label="更新时间"></el-table-column>
  </el-table>
  <input v-model.number="formData.articleId" type="text" name="articleId" id="articleId " placeholder="输入文章编号"/>
  <el-button @click="findById">搜索</el-button>
  <p>{{ article }}</p>
  <el-form :model="formData">
    <el-form-item label="标题">
      <el-input v-model="formData.title"/>
    </el-form-item>
    <el-form-item label="分类">
      <el-checkbox-group v-model="formData.category">
        <el-checkbox value="时政" name="category">
          时政
        </el-checkbox>
        <el-checkbox value="科技" name="category">
          科技
        </el-checkbox>
        <el-checkbox value="人文" name="category">
          人文
        </el-checkbox>
        <el-checkbox value="历史" name="category">
          历史
        </el-checkbox>
      </el-checkbox-group>
    </el-form-item>
    <el-form-item label="图片">
      <input v-model="formData.coverImg" type="text" name="coverImg" id="coverImg" placeholder="图片">
    </el-form-item>
  </el-form>
  <el-button @click="saveArticle">添加</el-button>
  <el-button @click="cancelReqInterceptor">取消请求拦截器</el-button>
  <el-button @click="cancelRespInterceptor">取消响应拦截器</el-button>

</template>

<style scoped>
.center {
  text-align: center;
}
</style>