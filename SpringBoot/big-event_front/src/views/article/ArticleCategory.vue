<script setup>
import { ref } from "vue";
import { ElMessage, ElMessageBox } from "element-plus";

// 表格数据
const categories = ref([
  {
    id: 1,
    categoryName: "name1",
    categoryAlias: "bieming1",
    createTime: "2024-04-23 12:03:23",
    updateTime: "2024-04-23 12:03:23",
  },
  {
    id: 2,
    categoryName: "name1",
    categoryAlias: "bieming1",
    createTime: "2024-04-23 12:03:23",
    updateTime: "2024-04-23 12:03:23",
  },
]);

// 控制弹窗显示
const dialogFormVisible = ref(false);
// 表单数据
const categoryFormData = ref({
  categoryName: "",
  categoryAlias: "",
});

// 表单校验
const rules = ref({
  categoryName: [
    { required: true, message: "分类名称不能为空", trigger: "blur" },
  ],
  categoryAlias: [
    { required: true, message: "分类别名不能为空", trigger: "blur" },
  ],
});

// 导入函数
import {
  articlecCategoryService,
  categoryAddService,
  categoryUpdateService,
  categoryDeleteService,
} from "@/api/article.js";

// 获取分类列表
const getArticleCategoryList = async () => {
  let result = await articlecCategoryService();
  //   console.log("result:", result);
  if (result && result.data) {
    categories.value = result.data;
  }
};
getArticleCategoryList();

// 确认按钮事件
const handleConfirm = async () => {
  switch (title.value) {
    case "添加分类":
      let res = await categoryAddService(categoryFormData.value);
      if (res && res.code === 0) {
        // 添加成功
        ElMessage.success(res.msg);
        getArticleCategoryList();
        dialogFormVisible.value = false;
      } else {
        ElMessage.error("添加失败");
      }
      break;

    case "修改分类":
      let res2 = await categoryUpdateService(categoryFormData.value);
      if (res2 && res2.code === 0) {
        // 修改成功
        ElMessage.success(res2.msg);
        getArticleCategoryList();
        dialogFormVisible.value = false;
      } else {
        ElMessage.error("修改失败");
      }
      break;
    default:
      //   console.log("出错了");
      break;
  }
};

// 弹窗复用
const title = ref("");
const handleAdd = () => {
  title.value = "添加分类";
  dialogFormVisible.value = true;
};

// 删除按钮事件
const handleDelete = (row) => {
  ElMessageBox.confirm("真的要删除吗？", "提示", {
    confirmButtonText: "确认",
    cancelButtonText: "取消",
    type: "warning",
  })
    .then(async () => {
      let resDelete = await categoryDeleteService(row.id);
    //   console.log("resDelete", resDelete);
      if (resDelete.code === 0) {
        ElMessage({
          type: "success",
          //   message: "删除成功",
          message: resDelete.msg,
        });
        getArticleCategoryList();
      } else {
        ElMessage({
          type: "error",
          //   message: "删除失败",
          message: resDelete.msg,
        });
      }
    })
    .catch(() => {
      //   ElMessage({
      //     type: "info",
      //     message: "用户取消删除",
      //   });
    });
};

// 编辑按钮事件
const handleEdit = (row) => {
  title.value = "修改分类";
  dialogFormVisible.value = true;
  //   console.log("row: ", row);
  categoryFormData.value.id = row.id;
  categoryFormData.value.categoryName = row.categoryName;
  categoryFormData.value.categoryAlias = row.categoryAlias;
};

// 弹窗关闭清空模型数据
const onDialogClose = () => {
  categoryFormData.value.id = "";
  categoryFormData.value.categoryName = "";
  categoryFormData.value.categoryAlias = "";
};
</script>
<template>
  <el-card style="max-width: 100%">
    <template #header>
      <div class="card-header">
        <span>文章分类</span>
        <el-button type="primary" @click="handleAdd">添加分类</el-button>
      </div>
    </template>
    <el-table :data="categories" style="width: 100%">
      <el-table-column prop="id" label="序号" />
      <el-table-column prop="categoryName" label="分类名称" />
      <el-table-column prop="categoryAlias" label="分类别名" />
      <el-table-column prop="createdTime" label="创建时间" />
      <el-table-column prop="updatedTime" label="修改时间" />
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

    <!-- <template #footer>Footer content</template> -->
  </el-card>

  <el-dialog
    v-model="dialogFormVisible"
    :title="title"
    width="30%"
    @close="onDialogClose"
  >
    <el-form :model="categoryFormData" :rules="rules">
      <el-form-item prop="categoryName" label="分类名称">
        <el-input v-model="categoryFormData.categoryName" />
      </el-form-item>
      <el-form-item prop="categoryAlias" label="分类别名">
        <el-input v-model="categoryFormData.categoryAlias"
      /></el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="handleConfirm"> 确认 </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>
.card-header {
  display: flex;
  justify-content: space-between;
}
</style>
