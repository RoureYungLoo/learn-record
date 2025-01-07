<script setup>
import { ref } from "vue";
import { Lock } from "@element-plus/icons-vue";
import { ElMessage, ElMessageBox } from "element-plus";
import { userUpdatePasswordService } from "@/api/user.js";
import router from "@/router/index.js";

const formData = ref({
  old_pwd: null,
  new_pwd: null,
  re_pwd: null,
});

const offset = ref(4);

const validatePwd = (rule, value, callback) => {
  let reg =
    /^(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*.])[\da-zA-Z~!@#$%^&*.]{8,}$/;
  if (formData.value.old_pwd === "" || formData.value.old_pwd == null) {
    callback("请输入旧密码");
  }
  if (!reg.test(value)) {
    console.log("通用");
    callback(new Error("密码必须是8位以上、必须含有字母、数字、特殊符号"));
  } else {
    formData.value.new_pwd === formData.value.re_pwd
      ? callback()
      : callback("密码输入不一致");
  }
};

// const validateRePwd = (rule, value, callback) => {
//   let reg =
//     /^(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*.])[\da-zA-Z~!@#$%^&*.]{8,}$/;
//   if (!reg.test(value)) {
//     callback(new Error("密码必须是8位以上、必须含有字母、数字、特殊符号"));
//   } else {
//     callback();
//   }
// };
// 校验
const rules = ref({
  old_pwd: [
    {
      required: true,
      message: "不能为空",
      trigger: "change",
    },
  ],
  new_pwd: [
    {
      required: true,
      message: "不能为空",
      trigger: "blur",
    },
    {
      required: true,
      validator: validatePwd,
      trigger: ["change"],
    },
  ],
  re_pwd: [
    {
      required: true,
      message: "不能为空",
      trigger: "blur",
    },
    {
      required: true,
      validator: validatePwd,
      trigger: ["change"],
    },
  ],
});

const handleCommit = () => {
  ElMessageBox.confirm("确认修改密码?", "Warning", {
    confirmButtonText: "确认",
    cancelButtonText: "取消",
    type: "warning",
  })
    .then(async () => {
      let res = await userUpdatePasswordService(formData.value);
      ElMessage.success(res.msg);

      // 跳转登录
      ElMessageBox.alert("即将跳转登录", "提示", {
        confirmButtonText: "确认",
        center: true,
        callback: () => {
          router.push("/login");
          ElMessage({
            type: "success",
            message: "跳转成功",
          });
        },
      });
    })
    .catch(() => {
      ElMessage({
        type: "info",
        message: "操作取消",
      });
    });
};
</script>
<template>
  <el-row justify="center">
    <el-col :span="12">
      <el-form :rules="rules" :model="formData">
        <el-form-item prop="old_pwd" label="旧的密码" required>
          <el-input
            v-model="formData.old_pwd"
            type="password"
            show-password
            placeholder="请输入旧密码"
            clearable
            :prefix-icon="Lock"
            required
          >
          </el-input>
        </el-form-item>
        <el-form-item prop="new_pwd" label="新的密码">
          <el-input
            v-model="formData.new_pwd"
            type="password"
            show-password
            placeholder="请输入新密码"
            clearable
            :prefix-icon="Lock"
          ></el-input
        ></el-form-item>
        <el-form-item prop="re_pwd" label="再次输入">
          <el-input
            v-model="formData.re_pwd"
            type="password"
            show-password
            placeholder="请再次输入新密码"
            clearable
            :prefix-icon="Lock"
          ></el-input
        ></el-form-item>
        <el-form-item>
          <el-row style="width: 100%">
            <el-col :span="12" :offset="offset">
              <el-button type="primary" @click="handleCommit"
                >点击提交</el-button
              >
              <el-button type="info">清空输入</el-button>
            </el-col>
          </el-row>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>
