<script setup>
import { ref } from "vue";
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
  Notebook,
  Position,
  User,
  EditPen,
} from "@element-plus/icons-vue";

import Profile from "@/components/icons/Profile.vue";
import Change from "@/components/icons/Change.vue";

const handleOpen = () => {};
const handleClose = () => {};

// 搜索条件
const searchOptions = ref({
  category: "",
  state: "",
});

// 文章列表
const articleList = ref([
  {
    title: "title",
    category: "category",
    time: "time",
    state: "state",
    id: 1,
  },
]);

/* 分页 */
const currentPage = ref(1);
const pageSize = ref(10);
const pageSizes = ref([10, 20, 30, 40, 50, 60]);
const size = ref("default");
const total = ref(200);
const handleSizeChange = () => {};

const handleCurrentChange = () => {};

// 点击搜索
const searchHandler = () => {
  console.log(searchOptions.value);
};

// 清空条件
const clearOptions = () => {
  searchOptions.value = {
    category: "",
    state: "",
  };
  console.log(searchOptions.value);
};

// 编辑
const EditHandler = (id) => {
    console.log(id)
};

// 删除
const deleteHandler = (id) => {
    console.log(id)

};

// 发布文章
const postHandler = () => {};
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px">
        <el-row class="tac">
          <el-col>
            <el-menu
              default-active="2"
              active-text-color="#ffd04b"
              background-color="#545c64"
              class="el-menu-vertical-demo"
              text-color="#fff"
              @open="handleOpen"
              @close="handleClose"
            >
              <el-menu-item><h1>大事件</h1> </el-menu-item>

              <el-menu-item index="1">
                <template #title>
                  <el-icon><Notebook /></el-icon>
                  <span>文章分类</span>
                </template>
              </el-menu-item>
              <el-menu-item index="2">
                <template #title>
                  <el-icon><Position /></el-icon>
                  <span>文章管理</span>
                </template>
              </el-menu-item>
              <el-sub-menu index="3">
                <template #title>
                  <el-icon><User /></el-icon>
                  <span>个人中心</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="3-1">
                    <el-icon><Profile /></el-icon>
                    <span>基本资料</span>
                  </el-menu-item>
                  <el-menu-item index="3-2">
                    <el-icon><Change /></el-icon>
                    <span>更换头像</span>
                  </el-menu-item>

                  <el-menu-item index="3-3">
                    <el-icon><EditPen /></el-icon><span>重置密码</span>
                  </el-menu-item>
                </el-menu-item-group>
              </el-sub-menu>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-container>
        <el-header>
          <el-menu mode="horizontal" :ellipsis="false" class="el-menu-demo">
            <el-menu-item index="0">
              <h3>当前用户</h3>
            </el-menu-item>
            <el-sub-menu index="1">
              <template #title>
                <el-icon><User /></el-icon>
              </template>
              <el-menu-item index="1-1">111</el-menu-item>
              <el-menu-item index="1-2">333</el-menu-item>
            </el-sub-menu>
          </el-menu>
        </el-header>
        <el-main>
          <el-card style="max-width: 100%">
            <template #header>
              <div class="card-header">
                <span>文章管理</span>
                <el-button type="primary">发布文章</el-button>
              </div>
            </template>
            <el-form :inline="true" :mode="searchOptions">
              <el-form-item label="文章分类" class="category">
                <el-select
                  v-model="searchOptions.category"
                  placeholder="请选择文章分类"
                >
                  <el-option label="分类1" value="分类1" />
                  <el-option label="分类2" value="分类2" />
                </el-select>
              </el-form-item>
              <el-form-item label="文章状态" class="state">
                <el-select
                  v-model="searchOptions.state"
                  placeholder="请选择文章状态"
                >
                  <el-option label="状态1" value="状态1" />
                  <el-option label="状态2" value="状态2" />
                </el-select>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="searchHandler"
                  >搜索</el-button
                >
                <el-button type="info" @click="clearOptions"
                  >重置</el-button
                ></el-form-item
              >
              <el-form-item></el-form-item>
            </el-form>
            <el-table :data="articleList">
              <el-table-column prop="title" label="标题" />
              <el-table-column prop="category" label="分类" />
              <el-table-column prop="time" label="时间" />
              <el-table-column prop="state" label="状态" />
              <el-table-column label="操作" prop="id">
                <el-button type="primary" @click="EditHandler(id)"
                  >编辑</el-button
                >
                <el-button type="danger" @click="deleteHandler(id)"
                  >删除</el-button
                >
              </el-table-column>
            </el-table>
            <div class="pagination">
              <el-pagination
                v-model:current-page="currentPage"
                v-model:page-size="pageSize"
                :page-sizes="pageSizes"
                :size="size"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total"
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
              />
            </div>
          </el-card>
        </el-main>
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<style>
.el-menu-vertical-demo {
  height: 600px;
}

.card-header {
  display: flex;
  justify-content: space-between;
}

.el-menu--horizontal > .el-menu-item:nth-child(1) {
  margin-right: auto;
}

.category,
.state {
  width: 220px;
}

.pagination {
  display: flex;
  justify-content: center;
  margin-top: 10px;
  margin-bottom: 16px;
}
</style>
