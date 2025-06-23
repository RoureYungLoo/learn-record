<script>

import {useCountStore} from "@/store/storeUseSetup.js";
import {mapActions, mapGetters, mapState, mapWritableState} from "pinia";
/* 在选项式API中使用store, 需要使用mapXxx()函数
* 可以把 state getters 映射为 组件method
* 可以把 action 映射为 实例方法
*  */
export default {
  data() {
    const countStore = useCountStore();
    return {
      countStore
    }
  },
  computed: {
    // ...mapState(useCountStore, ['count']), // 注册为 this.count
    ...mapWritableState(useCountStore, ['count']), // 注册为 this.count
    ...mapState(useCountStore, {
      myOwnName: 'doubleCount',
      msg: (store) => `${store.count}:${store.name}`
    }),
  },
  methods:{
    ...mapActions(useCountStore,['upperName','increment'])
  }
}
</script>

<template>
  <!--  <h3>{{ countStore }}</h3>-->
  <el-button @click="count++">+1</el-button>
  <el-button @click="count--">-1</el-button>
  <h3>{{ count }}</h3>
  <h3>{{ myOwnName }}</h3>
  <h3>{{ msg }}</h3>
  <el-button @click="upperName">upperName</el-button>
  <el-button @click="increment">increment</el-button>
</template>

<style scoped>

</style>