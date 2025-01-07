import request from "@/utils/request";
import { useTokenStore } from "@/stores/token.js";

export const articlecCategoryService = () => {
  let tokenStore = useTokenStore();
  //   console.log("token: ", tokenStore.token);
  //   return request.get("/category", {
  //     headers: {
  //       'Authorization': tokenStore.token,
  //     },
  //   });

  return request.get("/category");
};

export const categoryAddService = (categoryData) => {
  return request.post("/category", categoryData);
};

export const categoryUpdateService = (categoryData) => {
  return request.put("/category", categoryData);
};

export const categoryDeleteService = (id) => {
  return request.delete(`/category/${id}`);
};

export const articleListService = (params) => {
  return request.get("/article", { params: params });
};

export const articlecAddService = (articleData) => {
  return request.post("/article", articleData);
};

export const articleDeleteService = (articleId) => {
  return request.delete(`/article/${articleId}`);
};

export const articlecUpdateService = (articleData) => {
  return request.put("/article", articleData);
};
