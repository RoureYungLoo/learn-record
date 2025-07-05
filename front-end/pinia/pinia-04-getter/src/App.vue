<script setup>

import {useCounterStore} from "@/store/store.js";
import User from "@/views/User.vue";
import UserSetup from "@/views/UserSetup.vue";
import UserSetup2 from "@/views/UserSetup2.vue";
import UserOption from "@/views/UserOption.vue";

const counterStore = useCounterStore();
</script>

<template>
  <p>count: {{ counterStore.count }}</p>
  <p>count*2: {{ counterStore.doubleCount }}</p>
  <p>count*2: {{ counterStore.doubleCount2 }}</p>
  <p>count*2 +1: {{ counterStore.doublePlusOne }}</p>

  <el-button type="primary" @click="counterStore.count++">+1</el-button>
  <el-button type="primary" @click="counterStore.count--">-1</el-button>
  <User/>
  <UserSetup/>
  <hr/>
  <UserSetup2/>
  <hr/>
  <hr/>
  <UserOption/>
</template>

<style scoped>

</style>
