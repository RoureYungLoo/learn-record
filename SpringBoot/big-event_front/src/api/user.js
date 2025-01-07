import request from "@/utils/request.js";

// 注册
export const userRegisterService = (regData) => {
  const params = new URLSearchParams();
  for (const key in regData) {
    params.append(key, regData[key]);
  }
  return request.post("/user/register", params);
};

// 登录
export const userLoginService = (regData) => {
  const params = new URLSearchParams();
  for (const key in regData) {
    params.append(key, regData[key]);
  }
  return request.post("/user/login", params);
};

// 获取用户信息
export const userInfoService = () => {
  return request.get("/user");
};

// 更新用户信息
export const userUpdateService = (userData) => {
  return request.put("/user", userData);
};

// 更新用户头像
export const userUpdateAvatar = (imgUrl) => {
  const params = new URLSearchParams();
  params.append("avatarUrl", imgUrl);
  return request.patch("/user/updateAvatar", params);
};

// 更新用户密码
export const userUpdatePasswordService = (pwdData) => {
  return request.patch("/user/updatePwd",pwdData);
};
