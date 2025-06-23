<script setup>

import {computed, defineComponent} from "vue";
import {useCountStore} from "@/store/storeUseSetup.js";

/* 在 setup() 语法糖中使用 store, 无需使用 mapXxx() 辅助函数 */

const countStore = useCountStore();

const counterMultiplyFour = computed(() => {
  return countStore.doubleCount * 2
})

</script>

<template>

  <h3>{{ counterMultiplyFour }}</h3>
</template>

<style scoped>

</style>