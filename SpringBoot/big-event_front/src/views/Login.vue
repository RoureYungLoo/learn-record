<script setup>
import { ref, reactive } from "vue";
import { User, Lock, Right, Back } from "@element-plus/icons-vue";
import { userRegisterService, userLoginService } from "@/api/user.js";
import { ElMessage, ElMessageBox } from "element-plus";
import { useRouter } from "vue-router";

// 是否正在注册
const isRegistering = ref(false);

// 注册用户表单数据，和用户登录公用表单数据
const registerData = ref({
  username: "",
  password: "",
  repassword: "",
});

const router = useRouter();

const toLogin = () => {
  isRegistering.value = false;
  resetData();
};
const toRegister = () => {
  isRegistering.value = true;
  resetData();
};
// 自定义校验
const validatePass = (rule, value, callback) => {
  // if (value === "") {
  //   callback(new Error("必填项"));
  // }
  // if (value.length < 6 || value.length > 10) {
  //   callback(new Error("长度必须为5~10"));
  // }
  // console.log(isRegistering.value);
  // if (isRegistering.value && registerData.value.repassword.length > 0) {
  //   if (value !== registerData.value.repassword) {
  //     callback(new Error("密码输入不一致"));
  //   }
  // }
};

const validatePwd = (rule, value, callback) => {
  let reg =
    /^(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*.])[\da-zA-Z~!@#$%^&*.]{8,}$/;
  if (!reg.test(value)) {
    console.log("通用");
    callback(new Error("密码必须是8位以上、必须含有字母、数字、特殊符号"));
  } else {
    registerData.value.password === registerData.value.repassword
      ? callback()
      : callback("密码输入不一致");
  }
};
const validatePass2 = (rule, value, callback) => {
  // if (value === "") {
  //   callback(new Error("必填项"));
  // }
  // if (value.length < 6 || value.length > 18) {
  //   callback(new Error("长度必须为6~18"));
  // }
  // if (value !== registerData.value.password) {
  //   callback(new Error("密码输入不一致"));
  // } else {
  //   callback();
  // }
};

// 校验
const rules = reactive({
  username: [
    { required: true, message: "必填项", trigger: "blur" },
    { min: 5, max: 10, message: "长度必须为5~10", trigger: "blur" },
  ],
  password: [
    { required: true, message: "必填项", trigger: ["change", "blur"] },
    { min: 5, max: 18, message: "长度必须为5~18", trigger: "blur" },
    { validator: validatePwd, trigger: ["change"] },
    // { validator: validatePass, trigger: "change" },
  ],
  repassword: [
    {
      validator: validatePwd,
      trigger: ["change"],
    },
    { required: true, message: "必填项", trigger: ["change", "blur"] },
    { min: 5, max: 18, message: "长度必须为5~18", trigger: "blur" },
  ],
  //   repassword: [{ validator: validatePass2, trigger: "change" }],
});

const registerHandler = async () => {
  // console.log(registerData.value);
  let res = await userRegisterService(registerData.value);
  if (res) {
    ElMessageBox.alert(res.msg, "提示", {
      confirmButtonText: "OK",
      callback: (action) => {
        toLogin();
      },
    });
  }

  // console.log(res);
  // if (res.code === 0) {
  // alert(res.msg ? res.msg : "success");
  // } else {
  // alert(res.msg);
  // }
};

// 使用token, 登录成功需要维护token状态
import { useTokenStore } from "@/stores/token.js";
const tokenStore = useTokenStore();
// tokenStore.token
// tokenStore.setToken()

const loginHandler = async () => {
  // console.log(registerData.value);
  let res = await userLoginService(registerData.value);
  if (res) {
    ElMessage.success(res.msg ? res.msg : "登录成功");
    tokenStore.setToken(res.data);
  }

  // console.log(res);
  console.log(tokenStore.token);

  // if (res.code === 0) {
  // alert(res.msg ? res.msg : "登录成功");
  // } else {
  // alert(res.msg);
  // }

  router.push("/");
};

const resetData = () => {
  registerData.value = {
    username: "",
    password: "",
    repassword: "",
  };
};
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-main>
        <el-row justify="center" align="middle" style="height: 100%">
          <el-col :span="8" style="width: 1000px">
            <!-- 注册 -->
            <el-form
              v-if="isRegistering"
              :model="registerData"
              label-width="1"
              style="min-width: 200px; max-width: 400px"
              :rules="rules"
            >
              <h1>注册</h1>
              <el-form-item label="" prop="username">
                <el-input
                  v-model="registerData.username"
                  :prefix-icon="User"
                  placeholder="注册用户名"
                />
              </el-form-item>
              <el-form-item label="" prop="password">
                <el-input
                  v-model="registerData.password"
                  :prefix-icon="Lock"
                  placeholder="注册密码"
                  show-password
                />
              </el-form-item>

              <el-form-item label="" prop="repassword">
                <el-input
                  v-model="registerData.repassword"
                  :prefix-icon="Lock"
                  placeholder="确认密码"
                  show-password
                />
              </el-form-item>
              <el-form-item>
                <el-button
                  style="width: 100%"
                  type="primary"
                  @click="registerHandler"
                  >注册</el-button
                >
              </el-form-item>
              <el-form-item>
                <div>
                  <el-link :underline="false" @click="toLogin">
                    <el-icon><Back /></el-icon>返回
                  </el-link>
                </div>
              </el-form-item>
            </el-form>
            <!-- 登录 -->
            <el-form
              v-else
              :model="registerData"
              label-width="1"
              style="min-width: 200px; max-width: 400px"
              :rules="rules"
            >
              <h1>登录</h1>
              <el-form-item label="" prop="username">
                <el-input
                  v-model="registerData.username"
                  :prefix-icon="User"
                  placeholder="请输入用户名"
                />
              </el-form-item>
              <el-form-item label="" prop="password">
                <el-input
                  v-model="registerData.password"
                  :prefix-icon="Lock"
                  placeholder="请输入密码"
                  show-password
                />
              </el-form-item>
              <el-form-item>
                <el-checkbox label="记住我" size="small" />
              </el-form-item>
              <el-form-item>
                <el-link type="primary">忘记密码</el-link>
              </el-form-item>
              <el-form-item>
                <el-button
                  style="width: 100%"
                  type="primary"
                  @click="loginHandler"
                  >登录</el-button
                >
              </el-form-item>
              <el-form-item>
                <div>
                  <el-link :underline="false" @click="toRegister">
                    注册<el-icon><Right /></el-icon>
                  </el-link>
                </div>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
  </div>
</template>

<style lang="scss">
.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.common-layout {
  width: 100%;
  height: 100%;
}

.main_container {
  height: 100%;
}
.remember {
  display: flex;
  justify-content: space-between;
}
</style>
