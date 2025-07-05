<script setup>

import useStoreIdStore from "@/store/storeId.js";
import {onMounted} from "vue";
import useStoreId3Store from "@/store/storeId3.js";
import Home from "@/views/Home.vue";

const storeIdStore = useStoreIdStore();
const storeId3Store = useStoreId3Store();

onMounted(()=>{
  setInterval(()=>{
    storeIdStore.count++
    storeId3Store.count--
  },1000)
})


</script>


<template>
  <!--访问state-->
  <a-card>
    {{ storeIdStore.count }}
    {{ storeId3Store.count }}
  </a-card>
  <!--重置state-->
  <a-button type="primary" v-on:click="storeIdStore.$reset()">
    重置storeIdStore
  </a-button>
  <a-button type="primary" v-on:click="storeId3Store.$reset()">
    重置storeId3Store
  </a-button>
  <Home/>
</template>

<style scoped>

</style>
