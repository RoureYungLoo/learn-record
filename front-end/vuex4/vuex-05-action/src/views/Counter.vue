<script setup>

import {useStore} from "vuex";

const store = useStore();

const addOne = () => {
  /* store dispatch action */
  store.dispatch('addOne')
  store.dispatch('addOne2')
}
</script>

<template>
  <h3>Counter</h3>
  <p>{{ store.state.count}}</p>
  <el-button type="primary" @click="addOne">
    addOne
  </el-button>
</template>

<style scoped>

</style>