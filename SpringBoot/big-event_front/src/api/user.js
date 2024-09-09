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
