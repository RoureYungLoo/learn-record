<script lang="ts" setup>
import { ref, watch, toRaw } from "vue";
import {
  articleListService,
  articlecCategoryService,
  articlecAddService,
  articleDeleteService,
  articlecUpdateService,
} from "@/api/article.js";
import { Plus } from "@element-plus/icons-vue";
import { ElMessage, ElMessageBox } from "element-plus";
import type { UploadProps } from "element-plus";
import { QuillEditor } from "@vueup/vue-quill";
import "@vueup/vue-quill/dist/vue-quill.snow.css";
import { useTokenStore } from "@/stores/token.js";

// 文章列表模型
const articleList = ref([
  {
    id: "1",
    title: "测试标题",
    category: "测试分类",
    createdTime: "2022-09-09 12:04:23",
    state: "已发布",
  },
]);

// 条件搜索模型
const searchOptions = ref({
  pageNum: 1,
  pageSize: 5,
  categoryId: null,
  state: null,
});

// 分页插件模型
const total = ref(30);
const categories = ref({
  // categoryId: categoryName
});

//
const drawVisiable = ref(false);

//
const articleAddFormData = ref({
  title: "",
  categoryId: "",
  coverImg: "",
  content: "",
  state: "",
});

// 正在添加文章？
const isAdding = ref(true);
const myQuillEditor = ref();
// 获取文章分类列表
const getArticleCategoryList = async () => {
  let result = await articlecCategoryService();
  //   console.log("result:", result);
  if (result && result.data) {
    result.data.forEach((item, index) => {
      categories.value[item.id] = item.categoryName;
    });
  }
};

getArticleCategoryList();

// 获取文章列表
const getArticleList = async () => {
  let res = await articleListService(searchOptions.value);
  //   console.log(res.data);
  if (res && res.data) {
    articleList.value = res.data.items;
    total.value = res.data.total;
  }
  articleList.value.forEach((item, index) => {
    // console.log("item: ", item.categoryId);
    // console.log(categories.value.categoryId);
    item.categoryName = categories.value[item.categoryId];
  });
  // console.log(articleList.value);
};

getArticleList();

// 搜索按钮事件
const handleSearch = () => {
  console.log(searchOptions.value);
  getArticleList();
};
// 重置搜索条件
const handleReset = () => {
  searchOptions.value.categoryId = null;
  searchOptions.value.state = null;
  getArticleList();
};

// handleClosed
const handleClosed = () => {
  console.log("清空数据");
  articleAddFormData.value = {};
};
// 添加文章事件
const handleArticleAdd = () => {
  isAdding.value = true;
  drawVisiable.value = true;
  articleAddFormData.value.content = "";
};
// 删除文章事件
const handleDelete = (row) => {
  ElMessageBox.confirm("确认删除?", "温馨提示", {
    confirmButtonText: "确认",
    cancelButtonText: "取消",
    type: "warning",
  })
    .then(async () => {
      let res = await articleDeleteService(row.id);
      if (res.code === 0) {
        ElMessage({
          type: "success",
          message: res.msg ? res.msg : "删除成功",
        });
        getArticleList();
      } else {
        ElMessage({
          type: "error",
          message: res.msg ? res.msg : "删除失败",
        });
      }
    })
    .catch(() => {
      ElMessage({
        type: "info",
        message: "用户取消删除",
      });
    });
};
// 编辑文章事件
const handleEdit = async (row) => {
  isAdding.value = false;
  drawVisiable.value = true;

  // 数据回显
  getArticleCategoryList();
  articleAddFormData.value = {
    id: row.id,
    title: row.title,
    categoryId: row.categoryId,
    coverImg: row.coverImg,
    content: row.content,
    state: row.state,
    categoryName: categories.value[row.categoryId],
  };
  console.log("回显数据：", articleAddFormData.value);
};

// 页大小改变
const handleSizeChange = () => {
  getArticleList();

  console.log("handleSizeChange: ", searchOptions.value);
};
// 页码改变
const handleCurrentChange = () => {
  getArticleList();
  console.log("handleCurrentChange: ", searchOptions.value);
};

// 保存
const handleCommit = async (state) => {
  articleAddFormData.value.state = state;
  console.log(articleAddFormData.value);

  let res, msg;
  if (isAdding.value) {
    res = await articlecAddService(articleAddFormData.value);
    msg = "添加文章成功";
  } else {
    res = await articlecUpdateService(articleAddFormData.value);
    msg = "更新文章成功";
  }

  console.log("保存：", res);
  if (res && res.code == 0) {
    ElMessage.success(res.msg ? res.msg : msg);

    articleAddFormData.value = {};

    drawVisiable.value = false;
  } else {
    ElMessage.error(res.msg);
  }
  getArticleList();
};
// 草稿
// const handleDraft = async () => {
//   articleAddFormData.value.state = "草稿";
//   console.log(articleAddFormData.value);
//   let res = await articlecAddService(articleAddFormData.value);
//   console.log("草稿：", res);
//   if (res && res.code == 0) {
//     ElMessage.success(res.msg);

//     for (const key in articleAddFormData.value) {
//       articleAddFormData[key] = "";
//     }
//     articleAddFormData.value.content=""

//     drawVisiable.value = false;
//   } else {
//     ElMessage.error(res.msg);
//   }

//   getArticleList();
// };

const handleAvatarSuccess = (res) => {
  console.log("图片上传结果：", res);
  articleAddFormData.value.coverImg = res.msg;
};
const beforeAvatarUpload = () => {};

const tokenStore = useTokenStore();

const headers = ref({
  Authorization: tokenStore.token,
});

// // 抛出更改内容，此处避免出错直接使用文档提供的getHTML方法
// const setValue = () => {
//   const text = toRaw(myQuillEditor.value).getHTML()
// }

// watch(
//   () => articleAddFormData.value.content, // 监听哪个变量/对象
//   (val) => { // 回调函数
//     toRaw(myQuillEditor.value).setHTML(val);
//   },
//   { deep: true } // 深度监听
// );
</script>

<template>
  <el-card style="max-width: 100%">
    <template #header>
      <div class="card-header">
        <span>文章管理</span>
        <el-button type="primary" @click="handleArticleAdd">添加文章</el-button>
      </div>
    </template>

    <el-form :inline="true" :model="searchOptions" class="demo-form-inline">
      <el-form-item label="文章分类">
        <el-select
          v-model="searchOptions.categoryId"
          placeholder="请选择"
          clearable
        >
          <el-option
            v-for="(cname, cid, index) in categories"
            :key="index"
            :label="cname"
            :value="cid"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="发布状态">
        <el-select v-model="searchOptions.state" placeholder="请选择" clearable>
          <el-option label="草稿" value="草稿" />
          <el-option label="已发布" value="已发布" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleSearch">搜索</el-button>
        <el-button type="default" @click="handleReset">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="articleList" style="width: 100%">
      <el-table-column prop="title" label="文章标题" />
      <!-- <el-table-column prop="categoryId" label="文章分类" /> -->
      <el-table-column prop="categoryName" label="文章分类" />
      <el-table-column prop="createdTime" label="发表时间" />
      <el-table-column prop="state" label="状态" />
      <el-table-column label="操作">
        <template #default="{ row }">
          <el-button type="danger" size="small" @click="handleDelete(row)">
            删除
          </el-button>
          <el-button type="primary" size="small" @click="handleEdit(row)"
            >编辑</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      class="el-pagination"
      v-model:current-page="searchOptions.pageNum"
      v-model:page-size="searchOptions.pageSize"
      :page-sizes="[5, 10, 15, 20]"
      size="small"
      layout="jumper,total, sizes, prev, pager, next, "
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
    <!-- <template #footer>Footer content</template> -->
  </el-card>

  <el-drawer
    v-model="drawVisiable"
    :title="isAdding ? '添加文章' : '编辑文章'"
    direction="rtl"
    :show-close="true"
    class="demo-drawer"
    size="50%"
    @closed="handleClosed"
  >
    <div class="demo-drawer__content">
      <el-form :model="articleAddFormData">
        <el-form-item label="文章标题">
          <el-input
            v-model="articleAddFormData.title"
            autocomplete="off"
            placeholder="请输入文章标题"
          />
        </el-form-item>
        <el-form-item label="文章分类">
          <el-select
            v-model="articleAddFormData.categoryId"
            placeholder="请选择文章分类"
          >
            <el-option
              v-for="(cname, cid, index) in categories"
              :label="cname"
              :value="cid"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="文章封面">
          <el-upload
            class="avatar-uploader"
            action="/api/upload"
            :on-success="handleAvatarSuccess"
            :headers="headers"
            name="file"
            :auto-upload="true"
            :show-file-list="false"
          >
            <img
              v-if="articleAddFormData.coverImg"
              :src="articleAddFormData.coverImg"
              class="avatar"
            />
            <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
          </el-upload>
        </el-form-item>
        <el-form-item label="文章内容">
          <div class="editor">
            <quill-editor
              ref="myQuillEditor  "
              theme="snow"
              v-model:content="articleAddFormData.content"
              contentType="html"
            >
            </quill-editor>
          </div>
        </el-form-item>
        <el-form-item label="">
          <div class="demo-drawer__footer">
            <el-button type="primary" @click="handleCommit('已发布')"
              >发布</el-button
            >
            <el-button type="info" @click="handleCommit('草稿')">
              保存到草稿
            </el-button>
          </div>
        </el-form-item>
      </el-form>
    </div>
  </el-drawer>
</template>
<style lang="scss">
.demo-form-inline .el-input {
  --el-input-width: 220px;
}

.demo-form-inline .el-select {
  --el-select-width: 220px;
}

.el-pagination {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}
.demo-drawer__content .demo-drawer {
}

.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}

.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}

.editor {
  width: 100%;
  //height: 100px;
  :deep(.ql-editor) {
    //
  }
}
</style>
