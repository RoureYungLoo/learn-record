import { defineStore } from "pinia";
import { ref } from "vue";

export const useUserInfoStore = defineStore(
  "userInfo",
  () => {
    const info = ref({
      id: null,
      username: null,
      nickname: null,
      email: null,
      userPic: null,
      createdTime: null,
      updatedTime: null,
    });

    const setInfo = (newInfo) => {
      info.value = newInfo;
      // console.log('--setInfo---,',newInfo)
    };

    const removeInfo = () => {
      info.value = {};
    };

    return {
      info,
      setInfo,
      removeInfo,
    };
  },
  {
    persist: true,
  }
);
