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
  ArrowDown,
} from "@element-plus/icons-vue";
import { useRouter } from "vue-router";

import Profile from "@/components/icons/Profile.vue";
import Change from "@/components/icons/Change.vue";

import { useUserInfoStore } from "@/stores/userInfo.js";
import { userInfoService } from "@/api/user.js";

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
// 头像
const avatarSrc =
  "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png";

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
  console.log(id);
};

// 删除
const deleteHandler = (id) => {
  console.log(id);
};

// 发布文章
const postHandler = () => {};

// 左上角用户信息
const userInfoStore = useUserInfoStore();

const getUserInfo = async () => {
  let res = await userInfoService();
  // console.log('userinfo: ',res);
  if (res && res.data) {
    userInfoStore.setInfo(res.data);
  }
};
getUserInfo();

// 右上角头像下拉菜单路由
const router = useRouter();
const handleCommand = (command) => {
  if (command === "logout") {
    userInfoStore.removeInfo();
    router.push("/login");
  } else {
    router.push("/user/" + command);
  }
};
// watch(
//   ()=>,
//   (val)=>{

//   }
// )
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="180px">
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
              router
            >
              <el-menu-item><h1>大事件</h1> </el-menu-item>

              <el-menu-item index="/article/category">
                <template #title>
                  <el-icon><Notebook /></el-icon>
                  <span>文章分类</span>
                </template>
              </el-menu-item>
              <el-menu-item index="/article/manage">
                <template #title>
                  <el-icon><Position /></el-icon>
                  <span>文章管理</span>
                </template>
              </el-menu-item>
              <el-sub-menu index="">
                <template #title>
                  <el-icon><User /></el-icon>
                  <span>个人中心</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="/user/info">
                    <el-icon><Profile /></el-icon>
                    <span>基本资料</span>
                  </el-menu-item>
                  <el-menu-item index="/user/avatar">
                    <el-icon><Change /></el-icon>
                    <span>更换头像</span>
                  </el-menu-item>

                  <el-menu-item index="/user/password">
                    <el-icon><EditPen /></el-icon><span>重置密码</span>
                  </el-menu-item>
                </el-menu-item-group>
              </el-sub-menu>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-container>
        <el-header style="height: 20px">
          <div>
            <el-row justify="space-between">
              <el-text type="primary" size="large" tag="b"
                >当前用户: {{ userInfoStore.info.nickname }}</el-text
              >
              <el-dropdown trigger="click" @command="handleCommand">
                <span class="el-dropdown-link">
                  <el-avatar
                    shape="circle"
                    :size="30"
                    :src="userInfoStore.info.userPic"
                  ></el-avatar>
                  <el-icon class="el-icon--right">
                    <arrow-down />
                  </el-icon>
                </span>
                <template #dropdown>
                  <el-dropdown-menu>
                    <el-dropdown-item command="info">基本资料</el-dropdown-item>
                    <el-dropdown-item command="avatar"
                      >更换头像</el-dropdown-item
                    >
                    <el-dropdown-item command="password"
                      >重置密码</el-dropdown-item
                    >
                    <el-dropdown-item command="logout"
                      >退出登录</el-dropdown-item
                    >
                  </el-dropdown-menu>
                </template>
              </el-dropdown>
            </el-row>
          </div>
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
        <el-footer>版权信息©️</el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<style>
.common-layout {
  height: 100vh;
}
.el-menu-vertical-demo {
  height: 100vh;
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

.example-showcase .el-dropdown-link {
  cursor: pointer;
  color: var(--el-color-primary);
  display: flex;
  align-items: center;
}
.el-dropdown-link {
  display: flex;
  justify-content: center;
}
.el-icon--right {
  display: flex;
  justify-content: center;
}
</style>
