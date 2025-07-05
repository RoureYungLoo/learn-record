<script>
import {mapActions} from "vuex";
import {ElMessage} from "element-plus";

export default {
  methods: {
    ...mapActions(['addOne', 'actionA', 'actionC']),
    ...mapActions({
      myAdd2: 'addOne2'
    }),
    handleActionA() {
      this.actionA().then(res => {
        console.log(res)
        ElMessage({
          type: "success",
          message: res
        })
      }).catch(err => {
        console.log(err)
        ElMessage({
          type: "error",
          message: err
        })
      })
    },
    handleActionC() {
      const start = Date.now();
      this.actionC().then(res => {
        console.log(res)
        const end = Date.now();
        ElMessage({
          type: "success",
          message: "success耗时" + (end - start)
        })
      }).catch(err => {
        console.log(err)
        ElMessage({
          type: "error",
          message: "error"
        })
      })
    },
    handleActionE() {
      this.$store.dispatch('ActionE')
    }

  }

}
</script>

<template>
  <h3>Counter</h3>
  <el-button @click="addOne">addOne</el-button>
  <el-button @click="myAdd2">myAdd2</el-button>

  <el-button @click="$store.dispatch('addOne')">addOne</el-button>
  <el-button @click="$store.dispatch('addOne2')">myAdd2</el-button>
  <!-- 组合action -->
  <el-button @click="handleActionA">
    ActionA
  </el-button>
  <el-button @click="handleActionC">
    ActionC
  </el-button>
  <el-button @click="handleActionE">
    ActionE
  </el-button>

</template>

<style scoped>

</style>