<script setup>


import axios from "axios";
import {onMounted, ref} from "vue";

let url = "http://127.0.0.1/article/getAll"
const data = ref([])

function loadData() {
  axios.get(url).then((res) => {
    console.log(res.data)
    data.value = res.data
  }).catch(err => {
    // console.log(err)
  }).finally(() => {
    // console.log('finally')
  })
}


const columns = [
  {
    title: "编号",
    dataIndex: "id",
    key: "id",
    align:'center'
  },
  {
    title: "标题",
    dataIndex: "title",
    align:'center',
    key: "title",
  }, {
    title: "分类",
    dataIndex: "category",
    align:'center',
    key: "category",
  }, {
    title: "时间",
    dataIndex: "time",
    align:'center',
    key: "time",
  }, {
    title: "封面",
    dataIndex: "coverImg",
    align:'center',
    key: "coverImg",
  }, {
    title: "创建时间",
    dataIndex: "createTime",
    align:'center',
    key: "createTime",
  }, {
    title: "更新时间",
    dataIndex: "updateTime",
    align:'center',
    key: "updateTime",
  }, {
    title: '操作',
    align:'center',
    key: 'action',
  },
]
onMounted(() => {
  loadData()
})
</script>

<template>

  <a-table   :columns="columns" :data-source="data">
    <template #bodyCell="{ column, record }">
      <template v-if="column.key === 'coverImg'">
        <img :src="record.coverImg" width="80px"/>
      </template>
    </template>
  </a-table>

</template>

<style scoped>

</style>