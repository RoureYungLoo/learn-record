<template>
  <el-card>
    <div class="card-header">
      <span>文章管理</span>
      <el-button type="primary">发布文章</el-button>
    </div>
    <el-divider />

    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="文章分类">
        <el-select v-model="formInline.category" placeholder="请选择" clearable>
          <el-option label="小说" value="小说" />
          <el-option label="时事" value="时事" />
        </el-select>
      </el-form-item>
      <el-form-item label="发布状态">
        <el-select v-model="formInline.state" placeholder="请选择" clearable>
          <el-option label="草稿" value="草稿" />
          <el-option label="已发布" value="已发布" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">搜索</el-button>
        <el-button type="default" @click="onReset">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="title" label="标题" />
      <el-table-column prop="category" label="分类" />
      <el-table-column prop="state" label="状态" />
      <el-table-column prop="time" label="时间" />
      <el-table-column label="操作" width="180">
        <el-button type="primary" :icon="Edit" circle />
        <el-button type="danger" :icon="Delete" circle />
      </el-table-column>
    </el-table>

    <el-pagination
      class="el-pagination"
      v-model:current-page="currentPage4"
      v-model:page-size="pageSize4"
      :page-sizes="[5, 10, 15, 20]"
      :size="size.default"
      :disabled="disabled"
      :background="background"
      layout="jumper,total, sizes, prev, pager, next, "
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </el-card>
</template>

<script setup>
import {
  Check,
  Delete,
  Edit,
  Message,
  Search,
  Star,
} from "@element-plus/icons-vue";
import { ref } from "vue";
import { reactive } from "vue";

const formInline = reactive({
  state: "",
  category: "",
});
const currentPage1 = ref(5);
const currentPage2 = ref(5);
const currentPage3 = ref(5);
const currentPage4 = ref(4);
const pageSize2 = ref(100);
const pageSize3 = ref(100);
const pageSize4 = ref(10);
const background = ref(false);
const disabled = ref(false);
const total = ref(40);
const size = ref({
  large: "large",
  small: "small",
  default: "default",
});

const handleSizeChange = (val) => {
  console.log(`${val} items per page`);
};
const handleCurrentChange = (val) => {
  console.log(`current page: ${val}`);
};

const onSearch = () => {
  console.log("search");
  console.log(formInline);
};
const onReset = () => {
  console.log("reset");
  formInline.state = "";
  formInline.category = "";
};
const tableData = [
  {
    time: "2024-05-03",
    title: "标题1这是一段标题标题标题标题标题",
    state: "草稿",
    category: "小说",
  },
  {
    time: "2024-05-03",
    title: "标题1",
    state: "草稿",
    category: "小说",
  },
  {
    time: "2024-05-03",
    title: "标题1",
    state: "草稿",
    category: "小说",
  },
  {
    time: "2024-05-03",
    title: "标题1",
    state: "草稿",
    category: "小说",
  },
];
</script>
<style scoped>
.el-pagination {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}

.demo-form-inline .el-input {
  --el-input-width: 220px;
}

.demo-form-inline .el-select {
  --el-select-width: 220px;
}

.card-header {
  display: flex;
  justify-content: space-between;
}
</style>
