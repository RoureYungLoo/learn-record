<script setup lang="ts">
import { ref } from "vue";
import type { UploadInstance } from "element-plus";
import { useTokenStore } from "@/stores/token.js";
import { useUserInfoStore } from "@/stores/userInfo.js";
import { userUpdateAvatar, userInfoService } from "@/api/user.js";
import { ElMessage, ElMessageBox } from "element-plus";

const imgUrl = ref("");
const uploadRef = ref<UploadInstance>();
const submitUpload = () => {
  ElMessageBox.confirm("确认更新头像?", "Warning", {
    confirmButtonText: "确认",
    cancelButtonText: "取消",
    type: "warning",
  })
    .then(() => {
      uploadRef.value!.submit();
    })
    .catch(() => {
      ElMessage({
        type: "info",
        message: "操作取消",
      });
    });
};

// 从pinia获取token
const tokenStore = useTokenStore();
const headers = ref({
  Authorization: tokenStore.token,
});

//
const userInfoStore = useUserInfoStore();
console.log("=== userinfo: ", userInfoStore.info);
imgUrl.value = userInfoStore.info.userPic;

const handleUploadSuccess = async (res) => {
  console.log(res);
  imgUrl.value = res.msg;
  const res2 = await userUpdateAvatar(res.msg);
  if (res2.code === 0) {
    let res3 = await userInfoService();
    userInfoStore.setInfo(res3.data);
    ElMessage.success("头像更新成功");
  } else {
    ElMessage.error("头像更新失败");
  }
};
</script>

<template>
  <el-card>
    <el-image
      fit="cover"
      style="width: 200px; height: 200px"
      :src="imgUrl"
    ></el-image>
    <el-upload
      ref="uploadRef"
      action="/api/upload"
      :headers="headers"
      :on-success="handleUploadSuccess"
      :auto-upload="false"
    >
      <template #trigger>
        <el-button type="primary">选择图片</el-button>
      </template>
      <el-button type="success" @click="submitUpload">点击上传 </el-button>
    </el-upload>
  </el-card>
</template>
