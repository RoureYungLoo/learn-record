<script setup>

import {useCounterStore} from "@/store/counter.js";

const counterStore = useCounterStore();
let unsubscribe = null

/* 开启监听action */
const subscribe = () => {
  unsubscribe = counterStore.$onAction((
      /* 注意这里参数是一个对象, 解构出来 */
      {name, store, args, after, onError}
  ) => {
    const ts = Date.now()

    console.log(JSON.stringify(store))

    if (args) {
      console.log(`Start  action: "${name}" with params [${args.join(', ')}].`)
    } else {
      console.log(`Start  action: "${name}" with params ${args}.`)
    }

    after((res) => {
      console.log(`action ${name} 耗时${Date.now() - ts},结果: ${JSON.stringify(res)}`)
    })

    onError((err) => {
      console.log(`action ${name} failed after ${Date.now() - ts}, err: ${JSON.stringify(err)}`)
    })

  }, true /* detached, 为true 表示 组件卸载后,监听器仍然被保留 */)

  if (unsubscribe) {
    console.log("注册监听action 成功")
  } else {
    console.log("注册监听action 失败")
  }

}
/* 取消监听action */
const cancelSubscribe = () => {
  /* 删除监听器 */
  unsubscribe()
  console.log("成功删除监听器")
}
</script>

<template>
  <hr/>
  <el-button type="primary" @click="subscribe">开启订阅</el-button>
  <el-button type="primary" @click="cancelSubscribe">关闭订阅</el-button>

  <el-button type="primary" @click="counterStore.increment()">+1</el-button>
  <el-button type="primary" @click="counterStore.decrement()">-1</el-button>
  <el-button type="primary" @click="counterStore.plusANumber(Math.floor(Math.random()*100))">add</el-button>
  <el-button type="primary" @click="counterStore.loadData()">loadData</el-button>

</template>

<style scoped>

</style>