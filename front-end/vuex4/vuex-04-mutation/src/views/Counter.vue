<script setup>

import {useStore} from "vuex";
import {ref} from "vue";
import {ACCUMULATE_VER_TWO, ADD_ONE, SUB_ONE} from "@/store/mutaion-types.js";


const store = useStore();

const plusOne = () => {
  store.commit('increment')
}


const p1 = ref(null)
const p2 = ref(null)
const p3 = ref(null)
const p4 = ref(null)
const p5 = ref(null)

/* 在组件中提交mutation */
const onAccumulate = () => {
  // commit object
  /*    store.commit('accumulate',
          {
            p1: p1.value,
            p2: p2.value,
            p3: p3.value,
            p4: p4.value
          })*/
  // commit array
  /*  store.commit('accumulate',
        [
          p1.value,
          p2.value,
          p3.value,
          p4.value
        ])*/

  store.commit({
    type: 'accumulate',
    asdf: [
      p1.value,
      p2.value,
      p3.value,
      p4.value
    ],
    fff: "fafe",
    fdafd: {
      fd: [1, 2, 3],
      person: {
        name: "12312",
        age: 23,
        address: "ffipajdsfijd"
      }
    }
  })
}

const addOne = () => {
  store.commit(ADD_ONE, 11)
}
const subOne = () => {
  store.commit(SUB_ONE, 22)
}

const aCCUMULATE = () => {
  store.commit(ACCUMULATE_VER_TWO, {age: 12, score: 89})
}
</script>

<template>
  <h3>Counter</h3>
  <el-row>
    <p>count: {{ $store.state.count }}</p>
  </el-row>
  <el-row>
    <el-button @click="plusOne">+1</el-button>
  </el-row>
  <el-form label-width="50">
    <el-form-item label="数字1">
      <el-input type="number" v-model.number="p1"/>
    </el-form-item>
    <el-form-item label="数字2">
      <el-input type="number" v-model.number="p2"/>
    </el-form-item>
    <el-form-item label="数字3">
      <el-input type="number" v-model.number="p3"/>
    </el-form-item>
    <el-form-item label="数字5">
      <el-input type="number" v-model.number="p4"/>
    </el-form-item>
    <el-form-item label="数字5">
      <el-input type="number" v-model="p5"/>
    </el-form-item>
    <el-form-item>
      <el-button @click="onAccumulate">累加</el-button>
    </el-form-item>
  </el-form>
  <el-row>
    <el-button type="primary" @click="addOne">ADD_ONE</el-button>
    <el-button type="primary" @click="subOne">SUB_ONE</el-button>
    <el-button type="primary" @click="aCCUMULATE">ACCUMULATE</el-button>
  </el-row>
  <el-row>
    <el-button @click = "$store.commit('forTest')">forTest</el-button>
  </el-row>
</template>

<style scoped>

</style>