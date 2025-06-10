<script setup>

import {onBeforeRouteLeave, onBeforeRouteUpdate} from "vue-router";
import {ElMessageBox} from "element-plus";


onBeforeRouteUpdate((to, from) => {
  console.log("onBeforeRouteUpdate")
  return true
})

onBeforeRouteLeave(async (to, from) => {
  console.log("onBeforeRouteLeave")
  console.log(from)
  console.log(to)
  // const answer = window.confirm("还没保存就要离开吗?");
  // if (!answer) return false;
  let res = await ElMessageBox.confirm("还没有保存就离开吗?", "提示",
      {
        confirmButtonText: "离开",
        cancelButtonText: "继续编辑",
        type: 'warning'
      }
  ).then(() => {
    /*离开*/
    console.log("离开")
    return true
  }).catch(() => {
    /* 继续编辑 */
    console.log("继续编辑")
    return false
  })

  return res
})

const getConfirm = () => {

}
</script>

<template>
  <h3>TodoList</h3>
  <p>todo ID : {{ $route.params.id }}</p>
</template>

<style scoped>

</style>