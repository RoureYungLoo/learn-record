<script>

import {defineComponent} from "vue";
import {useCountStore} from "@/store/storeUseSetup.js";

/* 在 setup() 中使用 store, 无需使用 mapXxx() 辅助函数 */
export default defineComponent({
  setup() {
    const countStore = useCountStore();
    return {
      countStore
    }
  },
  computed: {
    counterMultiplyFour() {
      return this.countStore.doubleCount * 2
    }
  }
})
</script>

<template>

  <h3>{{ counterMultiplyFour }}</h3>
</template>

<style scoped>

</style>