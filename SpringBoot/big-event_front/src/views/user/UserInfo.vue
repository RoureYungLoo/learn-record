<script setup>
import { ref } from "vue";
import { Email, Nickname } from "@/components/icons";
import { ElMessage, ElMessageBox } from "element-plus";

import { useUserInfoStore } from "@/stores/userInfo.js";
import { userUpdateService, userInfoService } from "@/api/user.js";

// 表单模型

const userInfoStore = useUserInfoStore();
const userInfoFormData = ref({
  id: userInfoStore.info.id,
  username: userInfoStore.info.username,
  nickname: userInfoStore.info.nickname,
  email: userInfoStore.info.email,
});

const rules = ref({
  nickname: [
    {
      required: true,
      message: "请输入用户昵称",
      trigger: "blur",
    },
    {
      min: 1,
      max: 10,
      message: "用户昵称在1~10个长度之间",
      trigger: ["blur", "change"],
    },
  ],
  email: [
    {
      required: true,
      message: "请输入邮箱地址",
      trigger: "blur",
    },
    {
      type: "email",
      message: "请输入正确的邮箱地址",
      trigger: ["blur", "change"],
    },
  ],
});

const handleUpdate = () => {
  console.log(userInfoFormData.value);
  ElMessageBox.confirm("确认提交修改吗?", "温馨提示", {
    confirmButtonText: "确认",
    cancelButtonText: "取消",
    type: "warning",
  })
    .then(async () => {
      let res = await userUpdateService(userInfoFormData.value);
      //   console.log("----", res);
      if (res.code === 0) {
        ElMessage({
          type: "success",
          message: res.msg ? res.msg : "更新成功",
        });
        // 重新获取接口数据
        let res2 = await userInfoService();
        console.log("222222", res2);
        userInfoStore.setInfo(res2.data);
      } else {
        ElMessage({
          type: "error",
          message: res.msg ? res.msg : "更新失败",
        });
      }
    })
    .catch(() => {
      ElMessage({
        type: "info",
        message: "用户取消",
      });
    });

  // 跳转到哪里?
};
</script>

<template>
  <el-card>
    <template #header>
      <div class="card-header">
        <span>基本资料</span>
      </div>
    </template>
    <el-form :model="userInfoFormData" style="max-width: 400px" :rules="rules">
      <el-form-item label="登录名称">
        <el-input v-model="userInfoFormData.username" disabled></el-input>
      </el-form-item>
      <el-form-item prop="nickname" label="用户昵称" clearable>
        <el-input
          :prefix-icon="Nickname"
          v-model="userInfoFormData.nickname"
        ></el-input>
      </el-form-item>
      <el-form-item prop="email" label="用户邮箱" clearable>
        <el-input
          :prefix-icon="Email"
          v-model="userInfoFormData.email"
        ></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-button type="primary" @click="handleUpdate">提交修改</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>
