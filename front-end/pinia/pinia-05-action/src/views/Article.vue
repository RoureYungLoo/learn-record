<script setup>

import {useArticleStore} from "@/store/store.js";
import {ref} from "vue";
import {useSettingsStore} from "@/store/user.js";

const articleStore = useArticleStore();

const articles = ref(null)
const loadData = async () => {
  // articles.value = await articleStore.getArticles()
  // articles.value = await articleStore.getArticleByMande()
  articles.value = await articleStore.getArticleByAxios()
  console.log("loadData: articles", articles.value)
}

const prefer = ref(null)
const settingsStore = useSettingsStore();
const loadPerfer = async () => {
  await settingsStore.fetchPreferences()
  prefer.value = settingsStore.preferences
}

</script>

<template>
  <div>
    <h3>Article</h3>
    <button @click="articleStore.increment()">+1</button>
    <p>{{ articleStore.count }}</p>
    <!--    <el-button type="primary" @click="loadData()">加载</el-button>-->
    <el-button type="primary" @click="articleStore.getArticleByAxios()">加载</el-button>
    <el-table :data="articles" stripe border>
      <el-table-column prop="id" label="编号" width="80"></el-table-column>
      <el-table-column prop="title" label="标题"></el-table-column>
      <el-table-column prop="state" label="状态"></el-table-column>
      <el-table-column prop="category" label="分类"></el-table-column>
      <el-table-column label="封面">
        <template #default="{row}">
          <el-image style="width: 60px" :src="row.coverImg" fit="contain"/>
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间"></el-table-column>
      <el-table-column prop="updateTime" label="更新时间"></el-table-column>
      |
      <el-table-column fixed="right" label="操作" min-width="80">
        <template #default>
          <el-button link type="primary" size="small">
            编辑
          </el-button>
          <el-button link type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <hr/>
    <el-button type="primary" @click="loadPerfer"> load prefer</el-button>
    <p v-if="prefer">{{prefer}}</p>
  </div>
</template>

<style scoped>

</style>