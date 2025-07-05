<script setup>

import {useStore} from "vuex";

const store = useStore();
console.log("Home", store)

const sameAction = () => {
  store.dispatch('mA/sameAction')
}

const sameMutation = () => {
  store.commit('sameMutation')
}

const someAction = () => {
  store.dispatch("account/someAction")
}

const globalActionInAccount = () => {
  store.dispatch('globalActionInAccount',{user:"lisi",pwd:"c2rm4089um-2c3"})
}
</script>

<template>
  <h3>Home</h3>
  <el-text size="large" tag="b">moduleA.msg: {{ $store.state.mA.msg }}</el-text>
  <br>
  <el-text size="large" tag="b">moduleB.msg: {{ $store.state.mB.msg }}</el-text>
  <p>{{ $store.state.mA.count }}</p>
  <p>{{ $store.getters.dbCount }}</p>
  <el-button @click="$store.commit('increment')">mA.count+1</el-button>
  <el-button @click="$store.dispatch('incrementOnOdd')">incrementOnOdd</el-button>
  <el-button @click="sameAction">dispatch sameAction</el-button>
  <el-button @click="sameMutation">commit sameMutation</el-button>
  <p>{{ store.getters["account/isAdmin"] }}</p>
  <p>{{ store.getters["account/someGetter"] }}</p>
  <p>{{ store.dispatch("account/someAction") }}</p>

  <el-button @click="someAction">someAction</el-button>
  <el-button @click="globalActionInAccount">globalActionInAccount</el-button>

</template>

<style scoped>

</style>